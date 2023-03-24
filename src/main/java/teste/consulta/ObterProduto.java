package teste.consulta;

import infra.DAO;
import modelo.basico.Produto;

import java.util.List;

public class ObterProduto {
    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);

        List<Produto> produtos = dao.consultar("obterProdutosMaiorQue", "nota", 50.5);

        for (Produto prod: produtos) {
            System.out.println(prod.getNome());
        }
    }
}
