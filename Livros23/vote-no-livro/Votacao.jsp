<%@page import="entity.Internautas"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="entity.Livro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Carrega o Array List com as informações dos livros  -->
<%ArrayList<Livro> lista = (ArrayList<Livro>)request.getAttribute("listaLivros");%>

 <%session.setAttribute("listaLivros", lista) ;%>       

<!--Carrega o usuário que vai votar  -->
<% Internautas it = new Internautas();
  it= (Internautas) request.getAttribute("it");%>
  
  <% session.setAttribute("it", it);%>
 <link rel="stylesheet" type="text/css" href="./CSS/formato.css">





<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votando</title>
</head>
<body bgcolor="black">
<div class="header">
	
	<img alt="Logo" src="https://uploaddeimagens.com.br/images/000/415/929/full/Logo.png?1418882743" align="left" width="50" height="50">
	Votesibn

</div>

<div class="content">
<div class="collumn2">
Bem vindo <%=  it.getEmail() %><br>
Na sua esquerda você pode escolher o seu livro favorito, ao passar o mouse por cima ele se expandirá. Ali você faz sa escolha
</div>

<form action=".\CtrlVotoV" method="get">

 <div class="Votacao" align="left"> 
 <div class="subcollumn1"> 
    <div class="shrink" align="center">
     <a href="./CtrlVotoV" >
      <img  name="img1" class="img" src=<%=lista.get(0).getUrlImagem() %> width="50%" height="50%" alt=<%=lista.get(1).getIsbn()%>></div>
     </a>
       <br>

   <a href="./CtrlVotoV1">
           <%=lista.get(0).getNome()%>
   </div>
   
   
    <div class="subcollumn2"> 
    <div class="shrink">
     <img name="img2" class="img" src=<%=lista.get(1).getUrlImagem() %> width="50%" height="50%" alt=<%=lista.get(1).getIsbn()%> value="">
    </div>   
   </a>
     <%=lista.get(1).getNome()%>
</div>
</div>


</div>
<div class="footer">
<a href="./CtrlVotoRG"><div class="btn"> Ranking de Geral </div></a>
<a href="./CtrlVotoU"> <div class="btn"> Ranking de Usuário</div></a>
</div>
</form>

</body>
</html>