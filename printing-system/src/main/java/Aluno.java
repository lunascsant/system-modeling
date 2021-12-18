import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Aluno extends Usuario {

    private String matricula;
    private String curso;
    static int MAX_COPIAS_GRATUITAS = 50;

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

    public static int getMaxCopiasGratuitas() {
        return MAX_COPIAS_GRATUITAS;
    }

    public void solicitarPedidoImpressao(int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        Secretario.registrarPedidoImpressao(this, this.getMaxCopiasGratuitas(), numero, dataHoraPedido, arquivosImpressao, corImpressao);
    }
}
