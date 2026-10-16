package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.LoginRespostaDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Getter
@Setter
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO) {
        Optional<UsuarioDTO> usuarioNovo = usuarioService.cadastrar(usuarioCadastroDTO);
        if (usuarioNovo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNovo.get());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRespostaDTO> login(@RequestBody LoginDTO dto) {
        Optional<LoginRespostaDTO> usuarioAut = usuarioService.login(dto);
        if (usuarioAut.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioAut.get());
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<UsuarioDTO> desativar(@PathVariable Long id) {
        Optional<UsuarioDTO> usuarioInativo = usuarioService.desativar(id);
        if (usuarioInativo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioInativo.get());
    }
}
