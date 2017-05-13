package controllers.servlets;

import model.entidades.Produto;
import model.bo.ProdutoBo;

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
@WebServlet(value = "/cadastroDeProdutos")
public class CadastrarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession sessao;
    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        sessao = req.getSession();

        req.setAttribute("mensagem", "");

        String acaoParam = req.getParameter("acao");
        String acao = acaoParam == null ? "" : acaoParam;

        ProdutoBo produtoBo = new ProdutoBo();

        listarProdutos(req, produtoBo);

        if (acao.equals("adicionar")) {
            adicionarProduto(req, produtoBo);
        } else if(acao.equals("pesquisar")) {
            pesquisarProduto(req, produtoBo);
        }

        req.getRequestDispatcher("sistema/cadastroDeProdutos.jsp").forward(req, resp);
    }

    private List<String> getParametros(HttpServletRequest req) {
        String codigoParam = req.getParameter("codigo");
        String nomeParam = req.getParameter("nome");
        String valorUnitarioParam = req.getParameter("valorUnitario");

        String codigo = codigoParam == null ? "" : codigoParam;
        String nome = codigoParam == null ? "" : nomeParam;
        String valorUnitario = codigoParam == null ? "" : valorUnitarioParam;

        List<String> listaDeParametros = new ArrayList<String>();
        listaDeParametros.add(codigo);
        listaDeParametros.add(nome);
        listaDeParametros.add(valorUnitario);

        return listaDeParametros;
    }

    private void listarProdutos(HttpServletRequest req, ProdutoBo produtoBo) {
        sessao.setAttribute("listaDeProdutos", produtoBo.listar());
    }

    private void adicionarProduto(HttpServletRequest req, ProdutoBo produtoBo) {
        try {

            List<String> parametros = getParametros(req);

            Produto novoProduto = new Produto(Integer.parseInt(parametros.get(0)), parametros.get(1), Long.parseLong(parametros.get(2)));

            produtoBo.adicionar(novoProduto);

            req.setAttribute("mensagem", "O produto foi adicionado com sucesso!");

            listarProdutos(req, produtoBo);
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao adicionar o produto!");
        }

    }

    private void pesquisarProduto(HttpServletRequest req, ProdutoBo produtoBo) {
        if(produtoBo.pesquisar(getParametros(req)) == null) {
            listarProdutos(req, produtoBo);
            req.setAttribute("mensagem", "Não foram encontrados nenhum produto com os dados informados!");
        } else {
            sessao.setAttribute("listaDeProdutos", produtoBo.pesquisar(getParametros(req)));
        }
    }
}
