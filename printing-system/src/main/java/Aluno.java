import java.util.Calendar;

public class Aluno extends Usuario {

    private String matricula;
    private String curso;
    static int MAX_COPIAS_PERMITIDAS = 50;

    public Aluno(String nome, String sexo, Calendar dataNascimento, String matricula, String curso) {
        super(nome, sexo, dataNascimento);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
