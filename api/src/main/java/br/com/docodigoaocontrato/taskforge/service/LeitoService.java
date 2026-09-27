package br.com.docodigoaocontrato.taskforge.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
public class LeitoService {

    public String ConsultarLeitos(){
        return "Existem 10 leitos disponíveis";
    }
}
