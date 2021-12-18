import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilaImpressao {
    private LinkedList<PedidoImpressao> pedidos;
    private int proximo;

    public FilaImpressao() {
        proximo=0;
        pedidos = new LinkedList<PedidoImpressao>();
    }

    public LinkedList<PedidoImpressao> getPedidos() {
        return pedidos;
    }

    public void setPedidos(LinkedList<PedidoImpressao> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(PedidoImpressao pedido){
        pedidos.add(pedido);
    }

    public PedidoImpressao getProximoPedido(){

        return pedidos.poll();
    }

    public void removePedido(int numero){
        for(PedidoImpressao p: pedidos){
            if(numero==p.getNumero()){
                pedidos.remove(p);
            }
        }
    }
}
