<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Calculette en JSP</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script type=”text/javascript” src=”js/bootstrap.min.js”></script>
</head>
<body>

<form action =calculette.jsp method=GET>
	<fieldset>
		
		<div class="col-6">
			<h2> Calculette</h2>
			 <div class="form-group">
			    <label for="num1"> Nombre 1 </label>
			    <input type="number" name="num1" class="form-control" id="formGroupExampleInput">
			 </div>
			 <div class="form-group">
			    <label for="num2"> Nombre 2 </label>
			    <input type="number" name="num2" class="form-control" id="example-number-input" value="" min="0" max="200" >
			 </div>
			 <label class="col-form-legend col-sm-5"> Operation  : </label>
			  <div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="customRadioInline1" name="operation" class="custom-control-input" value="+">
			  <label class="custom-control-label" for="customRadioInline1" > + </label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="customRadioInline2" name="operation" class="custom-control-input" value="-">
			  <label class="custom-control-label" for="customRadioInline2"> - </label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="customRadioInline3" name="operation" class="custom-control-input" value="*">
			  <label class="custom-control-label" for="customRadioInline3"> * </label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="customRadioInline4" name="operation" class="custom-control-input" value="/">
			  <label class="custom-control-label" for="customRadioInline4"> / </label>
			</div>
			  <br> 
			<button type="submit" class="btn btn-primary">Calculer</button>
			
		</div>
	  </fieldset>
</form>
<p>
<% try{
	double num1= Double.parseDouble(request.getParameter("num1"));
	double num2= Double.parseDouble(request.getParameter("num2"));
	String oper= request.getParameter("operation");
	String affiche="";
	
		if (oper.equals("+")){
			double resul = num1+num2;
			affiche= num1+"+"+num2+"="+resul;
			out.println(affiche);
		}
		if(oper.equals("-")){
			double resul = num1-num2;
			affiche= num1+"-"+num2+"="+resul;
			out.println(affiche);
		}
		if(oper.equals("*")){
			double resul = num1*num2;
			affiche= num1+"*"+num2+"="+resul;
			out.println(affiche);
		}
		if(oper.equals("/") && num2==0){
			affiche = "Division impossible sur 0";
			out.println(affiche);
		}
		else if(oper.equals("/") && num2!=0){
			double resul = num1/num2 ;
			affiche= num1+"/"+num2+"="+resul;
			out.println(affiche);
		}
	
}catch(Exception e){
	System.out.println(e);
}				  %>
</p>
  
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
</body>
</html>