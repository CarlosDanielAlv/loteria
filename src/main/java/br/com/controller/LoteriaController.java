package br.com.controller;

import br.com.BO.LoteriaBO;
import br.com.model.LoteriaModel;
import br.com.persistence.LoteriaDAO;
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
public class LoteriaController extends HttpServlet {

    // Variáveis globais
    private static String INSER_OR_EDIT = "/index.jsp";
    private static String LISTA_JOGOS = "/MeusJogos.jsp";
    private ArrayList<LoteriaModel> listaJogos = new ArrayList<LoteriaModel>();
    private LoteriaBO lbo = new LoteriaBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = ""; // Recebe a página desejada
        String action = request.getParameter("action"); // Armazena a ação desejada.

        if (action.equalsIgnoreCase("listStock")) {
            forward = LISTA_JOGOS;
            try {
                listaJogos = (ArrayList<LoteriaModel>) lbo.getAll();
                request.setAttribute("arrayEstoque", listaJogos);
            } catch (Exception ex) {
                Logger.getLogger(LoteriaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } //  DELETAR JOGO
        else if (action.equalsIgnoreCase("delete")) {
            forward = LISTA_JOGOS;

            try {
                int jogo_id = Integer.parseInt(request.getParameter("estoque_id"));
                lbo.delete(jogo_id);
                listaJogos = (ArrayList<LoteriaModel>) lbo.getAll();
            } catch (Exception ex) {
                Logger.getLogger(LoteriaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("arrayJogos", listaJogos);
        } //  EDITAR Produto
        else if (action.equalsIgnoreCase("edit")) {
            forward = INSER_OR_EDIT;
            try {
                int jogo_id = Integer.parseInt(request.getParameter("jogo_id"));
                LoteriaModel lm = new LoteriaModel();
                lbo.update(lm);
                request.setAttribute("stock", lm);
            } catch (Exception e) {
                System.out.println("Erro no update: " + e.getMessage());
            }

            
        }
        
        //  INSERIR PRODUTO
        else {
            forward = INSER_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoteriaDAO edao = new LoteriaDAO();

        String descricao = request.getParameter("descricao");
        String codigo = request.getParameter("codigo");
        String unidade = request.getParameter("unidade");
        String preco = request.getParameter("preco");
        String estoque = request.getParameter("estoque");

        try {
            edao.save(new LoteriaModel(descricao, codigo, unidade, Float.parseFloat(preco), Integer.parseInt(estoque)));
        } catch (Exception ex) {
            Logger.getLogger(LoteriaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
