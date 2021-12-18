import java.util.Calendar;

public class Funcionario extends Usuario {

    private String matricula;
    private String unidade;
    private String departamento;

    public Funcionario(String nome, String sexo, Calendar dataNascimento, String matricula, String unidade, String departamento) {
        super(nome, sexo, dataNascimento);
        this.matricula = matricula;
        this.unidade = unidade;
        this.departamento = departamento;
    }
}
