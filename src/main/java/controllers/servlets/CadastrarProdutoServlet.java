package controllers.servlets;

import model.beans.Produto;
import model.bo.ProdutoBo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pedro on 14/04/17.
 */
@WebServlet(value = "/cadastroDeProdutos")
public class CadastrarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            HttpSession sessao = req.getSession();
            ProdutoBo produtoBo = new ProdutoBo();
            sessao.setAttribute("listaDeProdutos", produtoBo.listar());

            String acaoParam = req.getParameter("acao");
            String acao = acaoParam == null ? "" : acaoParam;

            if(acao.equals("adicionar")) {
                adicionarProduto(req, resp, produtoBo);
                sessao.setAttribute("listaDeProdutos", produtoBo.listar());
            }

            req.getRequestDispatcher("sistema/cadastroDeProdutos.jsp").forward(req, resp);
        }

    private void adicionarProduto(HttpServletRequest req, HttpServletResponse resp, ProdutoBo produtoBo) {
        String codigoParam = req.getParameter("codigo");
        String nomeParam = req.getParameter("nome");
        String valorUnitarioParam = req.getParameter("valorUnitario");


        try {
            int codigo = Integer.parseInt(codigoParam == null ? "" : codigoParam);
            String nome = codigoParam == null ? "" : nomeParam;
            long valorUnitario = Long.parseLong(codigoParam == null ? "" : valorUnitarioParam);

            Produto novoProduto = new Produto(codigo, nome, valorUnitario);

            produtoBo.adicionar(novoProduto);

            req.setAttribute("mensagem", "O produto foi adicionado com sucesso!");
        } catch (Exception ex) {
            req.setAttribute("mensagem", "Ocorreu um erro ao adicionar o produto! Erro: " + ex.getMessage());
        }

    }
}
