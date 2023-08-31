package med.voll.api.controller;

import med.voll.api.domain.usuarioArlequim.EncryptToRSA;
import med.voll.api.domain.usuarioArlequim.DadosUsuarioArlequim;
import med.voll.api.domain.usuarioArlequim.UsuarioArlequim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private EncryptToRSA encrypt;
    @GetMapping
    public String olaMundo() {
        return "Hello World Spring!";
    }

    @PostMapping
    public ResponseEntity encripta (@RequestBody DadosUsuarioArlequim dadosUsuario){
        var usuarioArlequim = new UsuarioArlequim(dadosUsuario.login(), encrypt.encryptMessage(dadosUsuario.senha()));

        return ResponseEntity.ok(new DadosUsuarioArlequim(usuarioArlequim));
    }

}
