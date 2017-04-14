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
@WebServlet(value = "/sistema")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Referência para a sessão.

        HttpSession sessaoLogin = req.getSession();

        // Obtém referência para o atributo "usuarioLogado".
        Boolean usuarioLogado = (Boolean) sessaoLogin
                .getAttribute("usuarioLogado");

        if (usuarioLogado == null || usuarioLogado == false) {
            req.getRequestDispatcher("sistema/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("sistema/index.jsp").forward(req, resp);
        }
    }
}

