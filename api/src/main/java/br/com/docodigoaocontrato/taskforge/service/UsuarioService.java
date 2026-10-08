package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO usuarioCadastroDTO) {
        if (usuarioRepository.existsByEmail(usuarioCadastroDTO.getEmail())) {
            return Optional.empty();
        }
        String senhaCripto = encoder.encode(usuarioCadastroDTO.getSenha());
        Usuario usuario1 = new Usuario();
        usuario1.setNome(usuarioCadastroDTO.getNome());
        usuario1.setEmail(usuarioCadastroDTO.getEmail());
        usuario1.setSenha(senhaCripto);
        Usuario usuarioSalvar = usuarioRepository.save(usuario1);
        return Optional.of(toDTO(usuarioSalvar));
    }

    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}


