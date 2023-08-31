package med.voll.api.domain.usuarioArlequim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class UsuarioArlequim {

    private String login;

    private String senha;

    public UsuarioArlequim(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
