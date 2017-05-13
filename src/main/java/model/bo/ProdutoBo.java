package model.bo;

import model.entidades.Produto;
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

    public List<Produto> pesquisar(List<String> atributos) {
        if(!atributos.get(0).equals("")) {
            return dao.pesquisarPorCodigo(atributos.get(0));
        } else if(!atributos.get(1).equals("")) {
            return dao.pesquisarPorNome(atributos.get(1));
        } else if(!atributos.get(2).equals("")) {
            return dao.pesquisarPorValor(atributos.get(2));
        }
    }

    public List<Produto> listar() {
        return dao.listar();
    }

}
