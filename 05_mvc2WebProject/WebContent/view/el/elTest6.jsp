<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>표현식</th><th>결과</th>
		</tr>
		<tr>
			<th>\${num1 + num2 }</th><th>${num1 + num2 }</th>
		</tr>
		<tr>
			<th>\${num1 / num2 }</th><th>${num1 / num2 }</th>
		</tr>
		<tr>
			<th>\${num1 div num2 }</th><th>${num1 div num2 }</th>
		</tr>
		<tr>
			<th>\${num1 < num2 }</th><th>${num1 < num2 }</th>
		</tr>
		
		<tr><!-- > -->
			<th>\${num1 gt num2 }</th><th>${num1 gt num2 }</th><th> > </th>
		</tr>
		<tr><!-- < -->
			<th>\${num1 lt num2 }</th><th>${num1 lt num2 }</th><th> < </th>
		</tr>
		
		<tr><!-- >= -->
			<th>\${num1 ge num2 }</th><th>${num1 gt num2 }</th><th> >= </th>
		</tr>
		<tr><!-- <= -->
			<th>\${num1 le num2 }</th><th>${num1 lt num2 }</th><th> <= </th>
		</tr>
		
		<tr><!-- == -->
			<th>\${num1 eq num2 }</th><th>${num1 eq num2 }</th><th> == </th>
		</tr>
		<tr><!-- <= -->
			<th>\${(num1 > num2)?num1:num2 }</th><th>${(num1 > num2)?num1:num2 }</th>
		</tr>
	</table>
</html>









