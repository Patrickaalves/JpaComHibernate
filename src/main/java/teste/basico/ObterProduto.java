package teste.basico;

import infra.ProdutoDAO;
import modelo.basico.Produto;

import java.util.List;

public class ObterProduto {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();

        for (Produto prod: produtos) {
            System.out.println("ID: "+prod.getId()+" Nome: "+prod.getNome()+ " Preco: "+prod.getPreco());
        }

        double precoTotal = produtos
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t, p) -> t+p)
                .doubleValue();

        System.out.println("O valor total = " + precoTotal);
    }
}
