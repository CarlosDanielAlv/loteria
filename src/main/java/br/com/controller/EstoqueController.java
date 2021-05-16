package br.com.controller;

import br.com.BO.EstoqueBO;
import br.com.model.EstoqueModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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

            List<EstoqueModel> produtos = new ArrayList<>();

            try {
                produtos = estoqueBO.getAll();
                request.setAttribute("arrayEstoque", listaEstoque);
            } catch (Exception e) {
                System.out.println("Erro ao buscar produtos: " + e.getMessage());
            }
            
            
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
