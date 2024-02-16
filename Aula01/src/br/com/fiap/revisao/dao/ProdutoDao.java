package br.com.fiap.revisao.dao;

import br.com.fiap.revisao.model.Produto;
import java.util.List;

//Interface: contrato que define os métodos que as classes devem implementar
//Interfaces servem para diminuir o acoplamento entre os objetos
public interface ProdutoDao {

    void cadastrar(Produto produto);
    List<Produto> listar();

}
