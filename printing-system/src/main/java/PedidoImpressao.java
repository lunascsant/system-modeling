import java.util.Date;
import java.util.List;

public class PedidoImpressao {
    private int numero;
    private Date dataHoraPedido;
    private List<Impressao> arquivosImpressao;
    private String corImpressao;
    private String statusImpressao;
    private Date dataHoraEntrega;
    private boolean entregue;
    private String metodoPagamento;
    private Usuario solicitante;
    private static float PRECO_IMPRESSAO= 0.25f;
    private int maxImpressoesGratuitas;

    public PedidoImpressao(Aluno solicitante, int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        this.numero = numero;
        this.dataHoraPedido = dataHoraPedido;
        this.arquivosImpressao = arquivosImpressao;
        this.corImpressao = corImpressao;
        this.solicitante = solicitante;
        maxImpressoesGratuitas=solicitante.getMaxImpressoesGratuitas();
    }

    public PedidoImpressao(Professor solicitante, int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        this.numero = numero;
        this.dataHoraPedido = dataHoraPedido;
        this.arquivosImpressao = arquivosImpressao;
        this.corImpressao = corImpressao;
        this.solicitante = solicitante;
        maxImpressoesGratuitas=solicitante.getMaxImpressoesGratuitas();
    }

    public float calculaPagamento(){
        if(maxImpressoesGratuitas <= arquivosImpressao.size()){
            return 0.0f;
        }
        else{
            float preco = (maxImpressoesGratuitas - arquivosImpressao.size())*PRECO_IMPRESSAO;
            return preco;
        }
    }

    public void pagarImpressao(){

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public List<Impressao> getArquivosImpressao() {
        return arquivosImpressao;
    }

    public void setArquivosImpressao(List<Impressao> arquivosImpressao) {
        this.arquivosImpressao = arquivosImpressao;
    }

    public String getCorImpressao() {
        return corImpressao;
    }

    public void setCorImpressao(String corImpressao) {
        this.corImpressao = corImpressao;
    }

    public String getStatusImpressao() {
        return statusImpressao;
    }

    public void setStatusImpressao(String statusImpressao) {
        this.statusImpressao = statusImpressao;
    }

    public Date getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(Date dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
