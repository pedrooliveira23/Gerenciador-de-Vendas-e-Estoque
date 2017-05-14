package controllers.servlets;

import model.bo.EstoqueBo;
import model.bo.ProdutoBo;
import model.entidades.Estoque;

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
@WebServlet(value = "/gerenciarEstoque")
public class GerenciarEstoqueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession sessao;
    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        sessao = req.getSession();

        req.setAttribute("mensagem", "");

        String acaoParam = req.getParameter("acao");
        String acao = acaoParam == null ? "" : acaoParam;

        EstoqueBo estoqueBo = new EstoqueBo();

        listarEstoques(req, estoqueBo);

        if (acao.equals("adicionar")) {
            adicionarEstoque(req, estoqueBo);
        } else if(acao.equals("pesquisar")) {
            pesquisarEstoque(req, estoqueBo);
        } else if(acao.startsWith("remover")){
            removerEstoque(req, estoqueBo, acao.substring(8, acao.length()));
        } else if(acao.startsWith("alterar")) {
            alterarEstoque(req, estoqueBo, acao.substring(8, acao.length()));
        }

        ProdutoBo produtos = new ProdutoBo();

        sessao.setAttribute("listaProdutos", produtos.listar());

        req.getRequestDispatcher("sistema/gerenciarEstoque.jsp").forward(req, resp);
    }

    private List<String> getParametros(HttpServletRequest req) {
        String codigoParam = req.getParameter("codigo");
        String nomeParam = req.getParameter("nome");
        String valorUnitarioParam = req.getParameter("valorUnitario");

        String codigo = codigoParam == null ? "" : codigoParam;
        String nome = nomeParam == null ? "" : nomeParam;
        String valorUnitario = valorUnitarioParam == null ? "" : valorUnitarioParam;

        List<String> listaDeParametros = new ArrayList<String>();
        listaDeParametros.add(codigo);
        listaDeParametros.add(nome);
        listaDeParametros.add(valorUnitario);

        return listaDeParametros;
    }

    private void listarEstoques(HttpServletRequest req, EstoqueBo estoqueBo) {
        sessao.setAttribute("listaDeEstoques", estoqueBo.listar());
    }

    private void adicionarEstoque(HttpServletRequest req, EstoqueBo estoqueBo) {
        try {

            List<String> parametros = getParametros(req);

            //Estoque novoEstoque = new Estoque(Integer.parseInt(parametros.get(0)), parametros.get(1), Long.parseLong(parametros.get(2)));

           // estoqueBo.adicionar(novoEstoque);

            req.setAttribute("mensagem", "O estoque foi adicionado com sucesso!");

            listarEstoques(req, estoqueBo);
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao adicionar o estoque!");
        }

    }

    private void pesquisarEstoque(HttpServletRequest req, EstoqueBo estoqueBo) {
        if(estoqueBo.pesquisar(getParametros(req)) == null || estoqueBo.pesquisar(getParametros(req)).size() == 0) {
            listarEstoques(req, estoqueBo);
            req.setAttribute("mensagem", "Não foram encontrados nenhum estoque com os dados informados!");
        } else {
            sessao.setAttribute("listaDeEstoques", estoqueBo.pesquisar(getParametros(req)));
        }
    }

    private void removerEstoque(HttpServletRequest req, EstoqueBo estoqueBo, String codigo) {
        List<String> codigos = new ArrayList<String>();
        codigos.add(codigo);
        try {
            estoqueBo.remover(estoqueBo.pesquisar(codigos).get(0));
            listarEstoques(req, estoqueBo);
            req.setAttribute("mensagem", "Estoque removido com sucesso!");
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao remover o estoque!");
        }
    }

    private void alterarEstoque(HttpServletRequest req, EstoqueBo estoqueBo, String substring) {
    }
}
