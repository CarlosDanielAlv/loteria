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
                <a class="py-2 d-none d-md-inline-block" href="https://getbootstrap.com.br/docs/4.1/examples/product/#">NOVO JOGO</a>
                <a class="py-2 d-none d-md-inline-block" href="https://getbootstrap.com.br/docs/4.1/examples/product/#">MEUS JOGOS</a>
                <a class="py-2 d-none d-md-inline-block" href="https://getbootstrap.com.br/docs/4.1/examples/product/#">SOBRE</a>
            </div>
        </nav>

        <!-- CONTEÚDO DE JOGOS -->
        <div class="container">
            <form>
                <div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
                    <div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
                        <div class="my-3 py-3">
                            <span><h5 style="color: black;" class="mesmLinhaEsquerda">JOGO(S:)</h5></span>
                            <span><h5 style="color: black;" class="mesmLinhaDireita">QUANTIDADE</h5></span>
                            
                            <!-- MEGA SENA -->
                            <div class="form-group">
                                <div class="input-group mb-3">

                                    <div class="input-group-prepend">

                                        <label class="lblTamanho input-group-text" for="inputGroupSelect01">MegaSena</label>
                                        <div class="input-group-text">

                                            <input type="checkbox" aria-label="Chebox para permitir input text">
                                        </div>

                                    </div>
                                    <input type="text" class="form-control" aria-label="Input text com checkbox">
                                </div>
                            </div>

                            <!-- LOTO FÁCIL -->
                            <div class="form-group">
                                
                                <div class="input-group mb-3">

                                    <div class="input-group-prepend">

                                        <label class="lblTamanho input-group-text" for="inputGroupSelect01">Loto Fácil</label>
                                        <div class="input-group-text">

                                            <input type="checkbox" aria-label="Chebox para permitir input text">
                                        </div>

                                    </div>
                                    <input type="text" class="form-control" aria-label="Input text com checkbox">
                                </div>
                            </div>
                            
                             <!-- LOTO QUINA -->
                            <div class="form-group">
                                
                                <div class="input-group mb-3">

                                    <div class="input-group-prepend">

                                        <label class="lblTamanho input-group-text" for="inputGroupSelect01">Quina</label>
                                        <div class="input-group-text">

                                            <input type="checkbox" aria-label="Chebox para permitir input text">
                                        </div>

                                    </div>
                                    <input type="text" class="form-control" aria-label="Input text com checkbox">
                                </div>
                            </div>


                        </div>
                    </div>
                    <div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
                        <div class="my-3 p-3">


                        </div>
                    </div>
                </div>
            </form>
        </div>

























        <h1>Tabela Estoque</h1>
        <!-- TABELA ESTOQUE -->
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Código do Produto</th>
                    <th scope="col">Unidade</th>
                    <th scope="col">Preço</th>
                    <th scope="col">Estoque</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${arrayEstoque}" var="estoque">
                    <tr>
                        <td><c:out value="${estoque.getEstoque_id()}" /></td>
                        <td><c:out value="${estoque.getDescricao()}" /></td>
                        <td><c:out value="${estoque.getCodigo()}" /></td>
                        <td><c:out value="${estoque.getUnidade()}" /></td>
                        <td>R$ <c:out value="${estoque.getPreco()}" /></td>
                        <td><c:out value="${estoque.getEstoque()}" /></td>

                        <td><a class="btn btn-secondary btn-sm"
                               href="StockController?action=edit&estoque_id=<c:out value ="${estoque.getEstoque_id()}"/>">Editar</a>
                            <a class="btn btn-danger btn-sm"
                               href="StockController?action=delete&estoque_id=<c:out value ="${estoque.getEstoque_id()}"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
