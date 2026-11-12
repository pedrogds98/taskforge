package br.com.docodigoaocontrato.taskforge.Security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class BCryptTresFormasTest {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Test
    void asTresFormasDeConferirASenha() {
        String doBanco = encoder.encode("123456");   // o que o cadastro salvou

        String encodeDeNovo = encoder.encode("123456");
        String recalculado = BCrypt.hashpw("123456", doBanco);

        System.out.println("doBanco      = " + doBanco);
        System.out.println("encodeDeNovo = " + encodeDeNovo);
        System.out.println("recalculado  = " + recalculado);

        // 1) encode + equals: NUNCA bate (o encode sorteia bytes novos)
        assertFalse(encodeDeNovo.equals(doBanco));

        // 2) hashpw + equals: bate (reaproveita os bytes do hash do banco)
        assertTrue(recalculado.equals(doBanco));
        assertFalse(BCrypt.hashpw("654321", doBanco).equals(doBanco));   // senha errada

        // 3) matches: o mesmo que a 2, numa linha
        assertTrue(encoder.matches("123456", doBanco));
        assertFalse(encoder.matches("654321", doBanco));
    }

    @Test
    void comValorQueNaoEBCryptOMatchesNaoQuebra() {
        String senhaSemHash = "123456";   // ex.: usuário antigo salvo sem embaralhar

        assertFalse(encoder.matches("123456", senhaSemHash));   // só avisa no log
        assertThrows(IllegalArgumentException.class,
                () -> BCrypt.hashpw("123456", senhaSemHash));   // "Invalid salt"
    }
}
