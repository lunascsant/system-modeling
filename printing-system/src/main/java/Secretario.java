import java.util.Calendar;
import java.util.List;

public class Secretario extends Usuario {

    private String horarioTrabalho;
    private List<Usuario> usuariosRegistrados;

    public Secretario(String nome, String sexo, Calendar dataNascimento, String horarioTrabalho) {
        super(nome, sexo, dataNascimento);
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public void adicionaUsuario(Usuario usuario) {
        this.usuariosRegistrados.add(usuario);
    }

}
