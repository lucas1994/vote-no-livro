<%@page import="control.CtrlLivros"%>
<%@page import="org.hibernate.dialect.RDMSOS2200Dialect"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="entity.Internautas"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="entity.Voto"%>
<%@ page import="entity.Livro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Carrega o Array List com as informações dos livros  -->
<%try{ArrayList<Object[]> lista = (ArrayList<Object[]>)request.getAttribute("lista");}
catch(Exception e){
	 session.setAttribute("Opc", "Rank");
	RequestDispatcher rd = request.getRequestDispatcher("./CtrlVotoRG");}%>

  <link rel="stylesheet" type="text/css" href="./CSS/formato.css">





<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=request.getAttribute("TpRanking") %></title>
</head>
<body bgcolor="black">
<div class="header"> <img alt="Logo" src="https://uploaddeimagens.com.br/images/000/415/929/full/Logo.png?1418882743" align="left" width="50" height="50">
	Votesibn </div>

<div class="content">
<div class="collumn1">
<%=request.getAttribute("TpRanking") %><br>
<table align="center"><tr><td>Posição</td><td>Nome</td><td>Votos</td></tr>
	<%int posi = 1;
	ArrayList<Object[]>l = (ArrayList<Object[]>)request.getAttribute("lista");
	for(Object[] li:l)
	{ %>
			<tr><td><%=posi%></td><td><%=li[1] %></td><td><%=li[0] %></td></tr>
		<br>
	<%posi++;}%>
</table>
</div>

<%Object[]primeiro=l.get(0); %>
<div class="collumn2" align="center">
O primeiro colocado é:<br><h2><%=primeiro[1] %></h2><br>
<%ArrayList<Livro>listaPrimeiro= new CtrlLivros().listarNome(primeiro[1].toString());  %>
     <img name="img2" class="img" src=<%=listaPrimeiro.get(0).getUrlImagem() %> width="50%" height="60%"/>
</div>
</div>
<div class="footer">
<a href="./CtrlVoto"> <div class="btn">Votar </div></a>


<a href="<%=request.getAttribute("pag") %>"> <div class="btn"><%=request.getAttribute("TpNRanking") %></div></a>
</div>

</body>
</html>