 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
   
  </head>
  
  <body>
   <form action="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/" %>login.do">
	<input name="username" type="text"/>
	<input name="password" type="text"/>
	<input name="age" type="text"/>
	
	<input type="submit">
   </form>
  </body>
</html>
