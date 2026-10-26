package br.com.docodigoaocontrato.taskforge.Security;

import br.com.docodigoaocontrato.taskforge.service.JwtService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    @Test
    void deveDevolverOEmailDeQuemGerouOToken() {
        // DADO que um email
        String email = "teste@teste.com";
        String usuario = "joao";

        // QUANDO eu gero um token e depois leio o token de volta
        String token = jwtService.gerarToken(email, usuario);
        String emailDoToken = jwtService.validarObterEmail(token);

        // ENTAO o email que retorna é o mesmo que entrou
        assertEquals(email, emailDoToken);
    }

    @Test
    void deveDevolverNullQuandoOTokenFoiAdulterado() {
        // DADO que um token foi adulterado por alguem
        String token = jwtService.gerarToken("teste@teste.com", "joao");
        String tokenAdulterado = token.concat("adulterado");

        // QUANDO eu tentar ler
        String emailDoToken = jwtService.validarObterEmail(tokenAdulterado);

        // ENTAO
        assertNull(emailDoToken);
    }
}
