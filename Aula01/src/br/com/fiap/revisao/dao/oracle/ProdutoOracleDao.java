package br.com.fiap.revisao.dao.oracle;

import br.com.fiap.revisao.dao.ProdutoDao;
import br.com.fiap.revisao.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoOracleDao implements ProdutoDao {

    //Armazenar em memória os produtos
    private static List<Produto> lista = new ArrayList<>();

    @Override
    public void cadastrar(Produto produto) {
        lista.add(produto);
    }

    @Override
    public List<Produto> listar() {
        return lista;
    }
}
