package br.com.controller;

import br.com.BO.EstoqueBO;
import br.com.model.EstoqueModel;
import br.com.persistence.EstoqueDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlo
 */
@WebServlet(name = "EstoqueController", urlPatterns = {"/EstoqueController"})
public class EstoqueController extends HttpServlet {

    // Variáveis globais
    private static String INSER_OR_EDIT = "/";
    private static String LISTA_ESTOQUE = "/index.jsp";
    private ArrayList<EstoqueModel> listaEstoque = new ArrayList<EstoqueModel>();
    private EstoqueBO estoqueBO = new EstoqueBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = ""; // Recebe a página desejada
        String action = request.getParameter("action"); // Armazena a ação desejada.

        if (action.equalsIgnoreCase("listStock")) {
            forward = LISTA_ESTOQUE;

            try {
                listaEstoque = (ArrayList<EstoqueModel>) estoqueBO.getAll();
                request.setAttribute("arrayEstoque", listaEstoque);
            } catch (Exception ex) {
                Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EstoqueDAO edao = new EstoqueDAO();

        String descricao = request.getParameter("descricao");
        String codigo = request.getParameter("codigo");
        String unidade = request.getParameter("unidade");
        String preco = request.getParameter("preco");
        String estoque = request.getParameter("estoque");

        try {
            edao.save(new EstoqueModel(descricao, codigo, unidade, Float.parseFloat(preco), Integer.parseInt(estoque)));
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
