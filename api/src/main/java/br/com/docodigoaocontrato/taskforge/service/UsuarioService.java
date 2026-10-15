package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.dto.*;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService = new JwtService();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO usuarioCadastroDTO) {
        Boolean emailExiste = usuarioRepository.existsByEmail(usuarioCadastroDTO.getEmail());
        if (emailExiste) {
            return Optional.empty();
        }
        String senhaCripto = encoder.encode(usuarioCadastroDTO.getSenha());
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioCadastroDTO.getNome());
        novoUsuario.setEmail(usuarioCadastroDTO.getEmail());
        novoUsuario.setSenha(senhaCripto);
        novoUsuario.setAtivo(true);
        usuarioRepository.save(novoUsuario);
        return Optional.of(toDTO(novoUsuario));
    }

   public Optional<LoginRespostaDTO> login (LoginDTO dto){
        Optional<Usuario> usuarioAut = usuarioRepository.findByEmail(dto.getEmail());
        if (usuarioAut.isEmpty()){
            return Optional.empty();
        } else if (encoder.matches(dto.getSenha(), usuarioAut.get().getSenha())) {
            String token = jwtService.gerarToken(dto.getEmail(), usuarioAut.get().getNome());
            LoginRespostaDTO loginRespDTO = new LoginRespostaDTO();
            loginRespDTO.setNome(usuarioAut.get().getNome());
            loginRespDTO.setToken(token);
            return Optional.of(loginRespDTO);

        }return Optional.empty();
   }

    public Optional<UsuarioDTO> desativar(Long id) {
        Optional<Usuario> usuarioInativo = usuarioRepository.findById(id);
        if (usuarioInativo.isEmpty()){
            return Optional.empty();
        }
        Usuario usuario = usuarioInativo.get();
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
        return Optional.of(toDTO(usuario));
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setAtivo(true);
        return dto;
    }
}
