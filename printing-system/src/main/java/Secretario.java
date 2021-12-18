import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Secretario extends Usuario {

    private String horarioTrabalho;
    private List<Usuario> usuariosRegistrados;
    private static FilaImpressao filaParaImprimir;

    public Secretario(String nome, String sexo, Calendar dataNascimento, String horarioTrabalho) {
        super(nome, sexo, dataNascimento);
        this.horarioTrabalho = horarioTrabalho;
        this.filaParaImprimir = new FilaImpressao();
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

    public static void registrarPedidoImpressao(Usuario solicitante, int maxCopiasGratuitas, int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        PedidoImpressao novoPedido = new PedidoImpressao(solicitante, maxCopiasGratuitas, numero, dataHoraPedido, arquivosImpressao, corImpressao);
        filaParaImprimir.adicionarPedido(novoPedido);
    }
}
