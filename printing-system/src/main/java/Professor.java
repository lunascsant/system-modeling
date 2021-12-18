import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Professor extends Usuario {

    private String horarioAtendimento;
    private static int MAX_COPIAS_GRATUITAS = 200;

    public Professor(String nome, String sexo, Calendar dataNascimento, String horarioAtendimento) {
        super(nome, sexo, dataNascimento);
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public static int getMaxCopiasGratuitas() {
        return MAX_COPIAS_GRATUITAS;
    }

    public void solicitarPedidoImpressao(int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        Secretario.registrarPedidoImpressao(this, this.getMaxCopiasGratuitas(), numero, dataHoraPedido, arquivosImpressao, corImpressao);
    }
}
