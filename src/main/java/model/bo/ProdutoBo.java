package model.bo;

import model.beans.Produto;
import persistence.ProdutoDao;

import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
public class ProdutoBo {
    private ProdutoDao dao = new ProdutoDao();

    public void adicionar(Produto produto) {
        dao.adicionar(produto);
    }

    public void remover(Produto produto) {
        dao.remover(produto);
    }

    public void editar(Produto produto) {
        Produto antigo = dao.pesquisar(new Integer(produto.getCodigo()).toString()).get(0);
        dao.editar(produto, antigo);
    }

    public List<Produto> pesquisar(String dadoCadastral) {
        return dao.pesquisar(dadoCadastral);
    }

    public List<Produto> listar() {
        return dao.listar();
    }

}
