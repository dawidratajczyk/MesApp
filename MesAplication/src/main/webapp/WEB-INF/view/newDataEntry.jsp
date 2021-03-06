	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isELIgnored="false"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wszystkie rekordy</title>
	<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
  	<link href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" rel="stylesheet">
	<script src="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/tabela4.css" />
	<link rel="stylesheet" type="text/css" href="css/main.css" />

	
  	<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>--%>
	<script src="/js/dane.js"></script>
	<script src="/js/recordValidator.js"></script>

</head>
<body>
<div align="center" id="main">


											
								
								
<form:form action="saveprod" method="post" modelAttribute="zapis" id="saverec">
	<table class="greenTable" style="width:100%">
	<%-- Pierwszy rekord, wybÃ³r fragmentu kodu --%>
	<tr>
	<td>WPROWADZ FRAGMENT KODU</td>
	<td ><input type="text" id="fragment" title="Wprowadz np. 22 i wyszukaj"/></td>
	<td><button id="szukaj" type="button">szukaj</button></td>
	</tr>
	

	<%-- drugi rekord, wybor pelnego kodu --%>
	<tr>
		<td>WYBIERZ KOD</td>
		<td>
		<form:select id ="material" path="material">
																					
		</form:select>
		</td>
	</tr>
	
	<%-- trzeci rekord, wybÃ³r operacji --%>
	<tr>
		<td>OPERACJA</td>
		<td>
		<form:select id ="operacja" path="operacja"></form:select>
		</td>
	</tr>
	
		<%-- Pierwszy drugi, maszyna --%>
	<tr>
		<td>MASZYNA</td>
		<td>
		<form:select id ="machine" path="maszyna">
		<c:forEach items="${maszyny}" var = "maszyny">
		<form:option value="${maszyny.maszyna}" />
		</c:forEach>
		</form:select>	                    
		</td>
    </tr>
	
	
	<%-- Czwarty rekord - czas --%>
	<tr>
		<td>CZAS</td>
		<td>
		<form:select id ="czas" path="czas" style="background-color:#e6e6e6"></form:select>
		</td>
	
	
	</tr>
	
		<%-- PiÄty rekord - norma --%>
	<tr>
		<td>NORMA</td>
		<td>
		<form:select id ="norma" path="norma" style="background-color:#e6e6e6"></form:select>
		</td>
	
	
	</tr>
	
		<%-- Szosty rekord - opis --%>
  	<tr>
                    <td>WYKONANO</td>
                    <td><form:input path="opis" id="quantity"/></td>
    </tr>    
	
	                <tr>
                    <td colspan="2"><input type="button" onclick="checkform();" value="Zapisz">
                   <input type="button" onclick="history.back();" value="Wstecz"></td>

                </tr>      
</table>
</form:form>

</div>
</body>
	<style>
	/* Tooltip container */
	.tooltip {
	  position: relative;
	  display: inline-block;
	  border-bottom: 1px dotted black; /* If you want dots under the hoverable text */
	}
	
	/* Tooltip text */
	.tooltip .tooltiptext {
	  visibility: hidden;
	  width: 120px;
	  background-color: black;
	  color: #fff;
	  text-align: center;
	  padding: 5px 0;
	  border-radius: 6px;
	 
	  /* Position the tooltip text - see examples below! */
	  position: absolute;
	  z-index: 1;
	}
	
	/* Show the tooltip text when you mouse over the tooltip container */
	.tooltip:hover .tooltiptext {
	  visibility: visible;
	}
	</style>
</html>