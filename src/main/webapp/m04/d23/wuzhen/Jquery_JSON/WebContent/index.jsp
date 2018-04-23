<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/json2.js"></script>
<script>
$(function(){
	/* var ary=[["武汉","黄冈","仙桃","孝感"],["广州","深圳"],["苏州","南京","淮安","张家港"]];
    var $ary=$("ary"); */
    var $c=$("#c");
    var $pro=$("#pro");
    $("#pro").change(function(){    	
    	var p=$("#pro").val();
    	 $.ajax({
    	    	"url":"ajax",
    	    	"type":"POST",
    	    	 "data":"pid="+p,
    	    	"dataType":"json",
    	    	"success":function(data){  
     	        			$c.empty();  
     	        			for(var i=0;i<data.length;i++){
    	                	$c.append("<option>"+data[i].name+"</option>"); 
     	        			}   	        			    	
    	    },
    	    "error":function(){
    	    	}
    	    });
    	/* for(var i=0;i<o.length;i++){
    		if(p==i){
    			$pro.empty();
            	$(ary[i]).each(function(){      		
            		$pro.append("<option>"+this+"</option>");
            	});
    		}
    	}   	 */
    });     
    
});
</script>

<select id="pro">
<option name="province" value="">---</option>
<c:forEach items="${listpro }" var="pro">
<option name="province" value="${pro.pid }">${pro.pname }</option>
</c:forEach>
</select>
<select id="c">
</select>
</body>
</html>