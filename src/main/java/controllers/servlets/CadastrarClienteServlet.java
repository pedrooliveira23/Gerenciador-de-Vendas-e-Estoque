package controllers.servlets;

import model.bo.ClienteBo;
import model.entidades.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
@WebServlet(value = "/cadastroDeClientes")
public class CadastrarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession sessao;
    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        sessao = req.getSession();

        req.setAttribute("mensagem", "");

        String acaoParam = req.getParameter("acao");
        String acao = acaoParam == null ? "" : acaoParam;

        ClienteBo clienteBo = new ClienteBo();

        listarClientes(req, clienteBo);

        if (acao.equals("adicionar")) {
            adicionarCliente(req, clienteBo);
        } else if(acao.equals("pesquisar")) {
            pesquisarCliente(req, clienteBo);
        } else if(acao.startsWith("remover")){
            removerCliente(req, clienteBo, acao.substring(8, acao.length()));
        }

        req.getRequestDispatcher("sistema/cadastroDeClientes.jsp").forward(req, resp);
    }

    private List<String> getParametros(HttpServletRequest req) {
        String codigoParam = req.getParameter("codigo");
        String nomeParam = req.getParameter("nomeEstabelecimento");
        String enderecoParam = req.getParameter("endereco");
        String telefoneParam = req.getParameter("telefone");
        String responsavelParam = req.getParameter("responsavel");

        String codigo = codigoParam == null ? "" : codigoParam;
        String nome = nomeParam == null ? "" : nomeParam;
        String endereco = enderecoParam == null ? "" : enderecoParam;
        String telefone = telefoneParam == null ? "" : telefoneParam;
        String responsavel = responsavelParam == null ? "" : responsavelParam;

        List<String> listaDeParametros = new ArrayList<String>();
        listaDeParametros.add(codigo);
        listaDeParametros.add(nome);
        listaDeParametros.add(endereco);
        listaDeParametros.add(telefone);
        listaDeParametros.add(responsavel);

        return listaDeParametros;
    }

    private void listarClientes(HttpServletRequest req, ClienteBo clienteBo) {
        sessao.setAttribute("listaDeClientes", clienteBo.listar());
    }

    private void adicionarCliente(HttpServletRequest req, ClienteBo clienteBo) {
        try {

            List<String> parametros = getParametros(req);

            Cliente novoCliente = new Cliente(Integer.parseInt(parametros.get(0)), parametros.get(1), parametros.get(2), parametros.get(3), parametros.get(4));

            clienteBo.adicionar(novoCliente);

            req.setAttribute("mensagem", "O cliente foi adicionado com sucesso!");

            listarClientes(req, clienteBo);
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao adicionar o cliente!");
        }

    }

    private void pesquisarCliente(HttpServletRequest req, ClienteBo clienteBo) {
        if(clienteBo.pesquisar(getParametros(req)) == null || clienteBo.pesquisar(getParametros(req)).size() == 0) {
            listarClientes(req, clienteBo);
            req.setAttribute("mensagem", "Não foram encontrados nenhum cliente com os dados informados!");
        } else {
            sessao.setAttribute("listaDeClientes", clienteBo.pesquisar(getParametros(req)));
        }
    }

    private void removerCliente(HttpServletRequest req, ClienteBo clienteBo, String codigo) {
        List<String> codigos = new ArrayList<String>();
        codigos.add(codigo);
        try {
            clienteBo.remover(clienteBo.pesquisar(codigos).get(0));
            listarClientes(req, clienteBo);
            req.setAttribute("mensagem", "Cliente removido com sucesso!");
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao remover o cliente!");
        }

    }
}
