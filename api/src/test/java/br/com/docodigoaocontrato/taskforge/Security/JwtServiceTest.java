package br.com.docodigoaocontrato.taskforge.Security;

import br.com.docodigoaocontrato.taskforge.service.JwtService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    @Test
    void deveDevolverOEmailDeQuemGerouOToken() {
//        DADO EMAIL:
        String usuario = "Joao";
        String email = "teste@gmail.com";

//        quando:
        String token = jwtService.gerarToken(email, usuario);
        String emailToken = jwtService.validarObterEmail(token);

//        então:
        assertEquals(email, emailToken);
    }

    @Test
    void deveDevolverNullQuandoOTokenFoiAdulterado() {
//        DADO:
        String usuario = "joao";
        String email = "joao@email.com";

//        Quando:
        String token = jwtService.gerarToken(email, usuario);
        String tokenAlterado = jwtService.validarObterEmail(token + 1);

//        Então:
        assertNull(tokenAlterado);
    }
}
