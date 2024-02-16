package br.com.fiap.revisao.view;

import br.com.fiap.revisao.dao.ProdutoDao;
import br.com.fiap.revisao.dao.oracle.ProdutoOracleDao;
import br.com.fiap.revisao.model.Produto;

public class DaoTeste {

    public static void main(String[] args) {
        //Instanciar dois Produto
        Produto caneta = new Produto(1, "Caneta Azul", 4.0);
        Produto caderno = new Produto(2, "Caderno 10 matérias", 20.0);

        //Instanciar um objeto do tipo ProdutoDao
        ProdutoDao dao = new ProdutoOracleDao();

        //Cadastrar os produtos
        dao.cadastrar(caneta);
        dao.cadastrar(caderno);

        //Listar os produtos
        for (var item : dao.listar()){
            System.out.println(item.getId() + " " + item.getNome() + " " + item.getValor());
        }

    }
}
