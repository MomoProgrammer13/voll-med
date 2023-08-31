package med.voll.api.domain.usuarioArlequim;

public record DadosUsuarioArlequim(String login, String senha) {

    public DadosUsuarioArlequim(UsuarioArlequim usuarioArlequim){
        this(usuarioArlequim.getLogin(), usuarioArlequim.getSenha());
    }
}
