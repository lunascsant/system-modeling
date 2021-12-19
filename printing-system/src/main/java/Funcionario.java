import java.util.Calendar;
import java.util.Date;

public class Funcionario extends Usuario {

    private String matricula;
    private String unidade;
    private String departamento;

    public Funcionario(String nome, String sexo, Date dataNascimento, String matricula, String unidade, String departamento) {
        super(nome, sexo, dataNascimento);
        this.matricula = matricula;
        this.unidade = unidade;
        this.departamento = departamento;
    }
}
