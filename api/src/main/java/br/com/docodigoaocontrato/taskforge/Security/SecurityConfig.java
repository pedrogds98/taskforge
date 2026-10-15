package br.com.docodigoaocontrato.taskforge.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;   // o porteiro

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())                 // API com token nao usa cookie de sessao
                .authorizeHttpRequests(auth -> auth
                        // quem entra SEM cracha:
                        .requestMatchers(HttpMethod.POST, "/usuarios/cadastrar", "/usuarios/login").permitAll()
                        .requestMatchers("/usuarios/cadastrar").permitAll()
                        .requestMatchers("/usuarios/desativar/{id}").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        // todo o resto EXIGE cracha valido (sem esta linha, rota sem regra = 403):
                        .anyRequest().authenticated()
                )
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                // sem cracha valido -> 401 (sem esta linha, o padrao do Spring e 403):
                .exceptionHandling(ex -> ex.authenticationEntryPoint(
                        (request, response, erro) -> response.sendError(401)))
                // nosso porteiro entra ANTES do porteiro padrao:
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
