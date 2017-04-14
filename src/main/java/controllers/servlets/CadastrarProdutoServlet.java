package controllers.servlets;

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

            req.getRequestDispatcher("sistema/cadastroDeProdutos.jsp").forward(req, resp);
        }
}
