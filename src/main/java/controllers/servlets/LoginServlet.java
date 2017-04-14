package controllers.servlets;

import model.beans.Usuario;
import model.bo.UsuarioBo;

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
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession sessaolog = req.getSession();

        req.setAttribute("erro", "");

        Usuario usuario = getUsuario(req);
        UsuarioBo bo = new UsuarioBo();

        sessaolog.setAttribute("usuarioLogado", bo.validar(usuario));
        sessaolog.setAttribute("nomeUsuario", usuario.getUsername());

        if (sessaolog.getAttribute("usuarioLogado").equals(true)) {
;            resp.sendRedirect("sistema");
        } else {
            if (!usuario.getUsername().equals("")
                    || !usuario.getSenha().equals("")) {
                req.setAttribute("erro",
                        "Usuário ou senha incorreta! Contate o administrador.");
            }
            req.getRequestDispatcher("sistema/login.jsp").forward(req, resp);
        }
    }

    private Usuario getUsuario(HttpServletRequest req) {
        String usuarioParam = req.getParameter("username");
        String senhaParam = req.getParameter("senha");
        String nomeUsuario = usuarioParam == null ? "" : usuarioParam;
        String senha = usuarioParam == null ? "" : senhaParam;

        Usuario usuario = new Usuario(nomeUsuario, senha);
        return usuario;
    }
}
