<%-- 
    Document   : list
    Created on : 10 de mai de 2021, 17:49:42
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="_css/estilo.css">

        <title>Estoque - Lista</title>
    </head>


    <body>
        <!-- BANNER -->
        <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light backgroundBanner">
            <div class="col-md-5 p-lg-5 mx-auto my-5">
            </div>
            <div class="product-device shadow-sm d-none d-md-block"></div>
            <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
        </div>

        <!-- BARRA DE NAVEGAÇÃO -->
        <nav class="m-md-3 site-header sticky-top py-1">
            <div class="container d-flex flex-column flex-md-row justify-content-between">
                <a class="py-2 d-none d-md-inline-block" href="index.jsp">NOVO JOGO</a>
                <a class="py-2 d-none d-md-inline-block" href="MeusJogos.jsp">MEUS JOGOS</a>
                <a class="py-2 d-none d-md-inline-block" href="sobre.html">SOBRE</a>
            </div>
        </nav>

        <h5 style="margin-left: 210px;center">MEGA SENA</h5>
        <div style="width: 500px; margin-left: 15px"class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">

                <!-- TABELA RESULTADOS DE JOGOS -->
                <table class="table">

                    <tbody>
                        <c:forEach items="${arrayEstoque}" var="estoque">
                            <tr>
                                <td><c:out value="${estoque.getEstoque_id()}" /></td>
                                <td><c:out value="${estoque.descricao()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>
        
        <h5 style="margin-left: 230px;center">QUINA</h5>
        <div style="width: 500px; margin-left: 15px"class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">

                <!-- TABELA RESULTADOS DE JOGOS -->
                <table class="table">
                    

                    <tbody>
                        <c:forEach items="${arrayEstoque}" var="estoque">
                            <tr>
                                <td><c:out value="${estoque.getEstoque_id()}" /></td>
                                <td><c:out value="${estoque.descricao()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>
</body>
</html>
