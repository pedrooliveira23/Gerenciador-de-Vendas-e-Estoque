package model.bo;

import model.entidades.Cliente;
import persistence.ClienteDao;

import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
public class ClienteBo {
    private ClienteDao dao = new ClienteDao();

    public void adicionar(Cliente cliente) {
        dao.adicionar(cliente);
    }

    public void remover(Cliente cliente) {
        dao.remover(cliente);
    }

    public List<Cliente> pesquisar(List<String> atributos) {
        if(!atributos.get(0).equals("")) {
            return dao.pesquisarPorCodigo(atributos.get(0));
        } else if(!atributos.get(1).equals("")) {
            return dao.pesquisarPorNomeEstabelecimento(atributos.get(1));
        } else if(!atributos.get(2).equals("")) {
            return dao.pesquisarPorEndereco(atributos.get(2));
        } else if(!atributos.get(3).equals("")) {
            return dao.pesquisarPorTelefone(atributos.get(3));
        } else if(!atributos.get(4).equals("")) {
            return dao.pesquisarPorResponsavel(atributos.get(4));
        }
        return null;
    }

    public List<Cliente> listar() {
        return dao.listar();
    }

}
