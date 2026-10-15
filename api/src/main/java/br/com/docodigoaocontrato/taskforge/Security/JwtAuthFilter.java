package br.com.docodigoaocontrato.taskforge.Security;

import br.com.docodigoaocontrato.taskforge.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    // mesma ferramenta da service, criada com new (igual o BCrypt). Mesmo segredo -> cracha compativel.
    private final JwtService jwtService = new JwtService();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);                   // tira o "Bearer "
            String email = jwtService.validarObterEmail(token);  // null se cracha invalido

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(email, null, List.of());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}