<%-- 
    Document   : index
    Created on : 05/09/2017, 19:52:25
    Author     : 5967082
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="newpackage.Requisicao"%>
<%@page import="newpackage.Procurador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="req" class="newpackage.Requisicao"/>
<jsp:setProperty name="req" property="*" />

<%
    
    if ("post".equalsIgnoreCase(request.getMethod())) { //se chegou algo por 
        Procurador procurador = new Procurador();
        List<String> lista = procurador.procura(req.getIp(), req.getInicioPorta(), req.getFinalPorta());
        req.setOpenPorts(lista);
    }
   
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>scan de portas</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Scanner de portas abertas de um ip</h2>
            <form action="" method="post">
                <div class="form-group">
                    <label for="ip">Qual ip será escaneado?</label>
                    <input type="text" class="form-control" id="ip" placeholder="Digite o ip" name="ip">
                </div>
                <div class="form-group">
                    <label for="portai">Porta inicial</label>
                    <input type="numeric" class="form-control" id="portai" placeholder="Primeira porta" name="inicioPorta">
                </div>
                <div class="form-group">
                    <label for="portaf">Porta final</label>
                    <input type="numeric" class="form-control" id="portaf" placeholder="Primeira porta" name="finalPorta">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <br>
        <div class="container">
            <h1>Portas Abertas</h1>
            <ul class="list-group">
                <c:forEach items="${req.openPorts}" var="porta">
                    <li class="list-group-item list-group-item-info"> porta: ${porta} </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>