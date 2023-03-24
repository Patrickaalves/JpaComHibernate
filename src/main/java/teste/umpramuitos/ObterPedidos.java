package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedidos {
    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorId(1L);

        for (ItemPedido ped: pedido.getItens()) {
            System.out.println(ped.getQuantidade());
        }

        dao.fechar();
    }
}
