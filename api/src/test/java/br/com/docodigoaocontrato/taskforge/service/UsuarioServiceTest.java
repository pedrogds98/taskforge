package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.LoginRespostaDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Test
    void EmailRepetidoNaoCadastra() {
//        DADO QUE:
        UsuarioCadastroDTO usuarioTest = new UsuarioCadastroDTO();
        usuarioTest.setEmail("joao123");
        when(usuarioRepository.existsByEmail(usuarioTest.getEmail())).thenReturn(true);

//        QUANDO:
        Optional<UsuarioDTO> usuarioTeste = usuarioService.cadastrar(usuarioTest);

//        ENTAO:
        verify(usuarioRepository, never()).save(any(Usuario.class));
        assertTrue(usuarioTeste.isEmpty());
    }

    @Test
    void SenhaErradaNaoLoga() {
//        DADO QUE:
        LoginDTO loginTest = new LoginDTO("joao@teste.com", "32135459");
        Usuario usuarioTeste = new Usuario();
        usuarioTeste.setEmail("joao@teste.com");
        usuarioTeste.setSenha(
                new BCryptPasswordEncoder().encode(("123456")));
        when(usuarioRepository.findByEmail(loginTest.getEmail())).thenReturn(Optional.of(usuarioTeste));

//        QUANDO:
        Optional<LoginRespostaDTO> testeLogin = usuarioService.login(loginTest);

//        ENTÃO:
        assertTrue(testeLogin.isEmpty());
    }

    void DevolverLoginQuandoSenhaCorreta() {
//        DADO QUE:
        LoginDTO loginTest = new LoginDTO("joao@teste.com", "32135459");
        Usuario usuarioTeste = new Usuario();
        usuarioTeste.setEmail("joao@teste.com");
        usuarioTeste.setSenha(
                new BCryptPasswordEncoder().encode(("123456")));

//        QUANDO:
        Optional<LoginRespostaDTO> testeLogin = usuarioService.login(loginTest);

//        ENTÃO:
        assertTrue(testeLogin.isEmpty());
    }
}