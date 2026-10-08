package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    UsuarioRepository senhaCripto = encoder()
//    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO usuarioCadastroDTO) {
//        if (usuarioRepository.existsByEmail(usuarioCadastroDTO.getEmail())) {
//            return Optional.empty();
//        }
//    }
}
