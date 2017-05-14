package model.bo;

import model.entidades.Estoque;
import persistence.EstoqueDao;

import java.util.List;

/**
 * Created by pedro on 13/05/17.
 */
public class EstoqueBo {
    private EstoqueDao dao = new EstoqueDao();
    
    public void adicionar(Estoque estoque) {
        dao.adicionar(estoque);
    }

    public void remover(Estoque estoque) {
        dao.remover(estoque);
    }

    public void editar(Estoque estoqueAnterior, Estoque estoque) {
        dao.editar(estoqueAnterior, estoque);
    }

    public List<Estoque> pesquisar(List<String> atributos) {
        if(!atributos.get(0).equals("")) {
            return dao.pesquisarPorCodigo(atributos.get(0));
        } else if(!atributos.get(1).equals("")) {
            return dao.pesquisarPorNome(atributos.get(1));
        }
        return null;
    }

    public List<Estoque> listar() {
        return dao.listar();
    }
}
