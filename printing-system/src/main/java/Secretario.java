import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Secretario extends Funcionario {

    private String horarioTrabalho;
    private List<Usuario> usuariosRegistrados;
    private static FilaImpressao filaParaImprimir;
    private List<PedidoImpressao> impressoesConcluidas;

    public Secretario(String nome, String sexo, Date dataNascimento,String matricula, String unidade, String departamento, String horarioTrabalho) {
        super(nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.horarioTrabalho = horarioTrabalho;
        this.filaParaImprimir = new FilaImpressao();
        this.impressoesConcluidas = new ArrayList<PedidoImpressao>();
        this.usuariosRegistrados = new ArrayList<Usuario>();
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public List<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public FilaImpressao getFilaParaImprimir() {
        return filaParaImprimir;
    }
    public void adicionaUsuario(Usuario usuario) {
        this.usuariosRegistrados.add(usuario);
    }

    public void imprimeProximo(){
        PedidoImpressao pedidoConcluido = filaParaImprimir.getProximoPedido();
        pedidoConcluido.imprimir();
        System.out.println("Impressão N."+ pedidoConcluido.getNumero() + " concluído.");
        impressoesConcluidas.add(pedidoConcluido);
    }

    public void entregarPedidoImpressao(String metodoPagamento, int numeroPedido) {
        PedidoImpressao pedido = null;
        for(PedidoImpressao p : impressoesConcluidas) {
            if(p.getNumero() == numeroPedido){
                pedido = p;
            }

        }

        if(pedido == null) {
            System.out.println("Pedido N."+ numeroPedido+ " inválido.");
        } else if(metodoPagamento.equals("Dinheiro") || metodoPagamento.equals("Crédito") ||
                metodoPagamento.equals("Débito")|| pedido.calculaPagamento() == 0.0f) {
                pedido.pagamentoConcluido();
                System.out.println("Pedido N."+ numeroPedido+ " pago e entregue.");
        } else {
            System.out.println("Método de pagamento inválido.");
        }
    }

    public static void registrarPedidoImpressao(Usuario solicitante, int maxCopiasGratuitas, int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        PedidoImpressao novoPedido = new PedidoImpressao(solicitante, maxCopiasGratuitas, numero, dataHoraPedido, arquivosImpressao, corImpressao);
        float valorPedido = novoPedido.calculaPagamento();
        if (valorPedido > 0.0f) {
            novoPedido.setStatusImpressao("Na fila");
            filaParaImprimir.adicionarPedido(novoPedido);
            System.out.println("Pedido adicionado na fila de impressão. Valor: R$" + valorPedido);
        } else {
            novoPedido.setStatusImpressao("Na fila");
            filaParaImprimir.adicionarPedido(novoPedido);
            System.out.println("Pedido adicionado na fila de impressão.");
        }
    }

    public void consultaPedidosImpressaoSolicitados() {
        System.out.println("--------------------- FILA DE IMPRESSÕES ----------------------");
        for(PedidoImpressao p : filaParaImprimir.getPedidos()) {
            System.out.println("Impressão N° " + p.getNumero() + " - Status: " + p.getStatusImpressao());
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void consultaPedidosImpressaoConcluidos() {
        System.out.println("--------------------- IMPRESSÕES CONCLUÍDAS ----------------------");
        for(PedidoImpressao p : impressoesConcluidas) {
            System.out.println("Impressão N° " + p.getNumero() + " - Status: " + p.getStatusImpressao());
            if (p.getStatusImpressao().equals("Entregue"))
                System.out.println("Data e hora: " + p.getDataHoraEntrega());
        }
        System.out.println("------------------------------------------------------------------");
    }
}
