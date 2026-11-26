
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int b=20;
public void say(){
	System.out.println("Hello");

}
{
	System.out.println("i am in servlet");
}
public boolean validate(String name,String password){
	if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")){
		return true;
	}else{
		return false;
		}
}

%>
<%
	String name= request.getParameter("n1");
	String password= request.getParameter("p1");
	if(validate(name, password)){
			out.println("Welcome : "+name);
	}else{
		response.sendRedirect("form.html?msg=User Name or password is incorrect");
	}
	
%>

</body>  
</html>