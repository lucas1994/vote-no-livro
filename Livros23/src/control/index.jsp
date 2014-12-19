<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <link rel="stylesheet" type="text/css" href="./CSS/formato.css">



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votacao Maneira</title>
</head>

<body bgcolor="black">



<div class="header">
	
	<img alt="Logo" src="https://uploaddeimagens.com.br/images/000/415/929/full/Logo.png?1418882743" align="left" width="50" height="50">
	Votesibn

</div>
	<div class="content">
	 <div class="collumn1" align="left">
	 	<form method="post" action="./CtrlInternautas"> 
	 	Coloque aqui seu email para começar a votar.<br>
	 	Email<br>
		<input type="email" placeholder="email" name="txtEmail"/>
		<input type="submit" name="cmd" value="Iniciar"/>
		</form>
		<%try{String msg =request.getAttribute("msg").toString();%>
		<%=msg %>
		<%}catch(Exception e){} %>
		<br>
	 	<br>
	 	<hr>
	 	Caso ainda não seja cadastrado, preencha os campos abaixo
	 	<form method="post" action="./CtrlInternautas"> 
	    Nome<br>
		<input type="text" placeholder="ex:Peter Parker" name="txtNome"/><br>
		Email<br>
		<input type="email" placeholder="ex:email@servidor.com" name="txtEmail"/><br><br>
		<input type="submit" name="cmd" value="Cadastrar"/>
		</form>
	   </div>
	    <div class="collumn2">
	    	<h1>Venha Escolher</h1>
	    	Esse site foi feito com o fim que as pessoas pudessem escolher qual os melhores livros na atualidade. Cada vez apresentando
	    	5 opções em diversos confrontos. Vote e se divirta nessa disputa.
	    </div>
	</div>
	<div class="footer"></div>

</body>
</html>