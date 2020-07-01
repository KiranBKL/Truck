<%-- 
    Document   : UserHome
    Created on : 16 Mar, 2020, 9:59:14 AM
    Author     : rgukt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     String uname = request.getParameter("uname"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="uhome.css">
    </head>
    <script>
function validate()
{
var num=document.reg.volume.value;

    if(isNaN(num))
    {
        alert("please enter number in volume field");
      return false;
    }
    
    else
    {
        return true;
    }


}
</script>
   <body>
<header>
<div class="container">
	<div id="branding">
		<h1>Truck</h1>
	</div>
   
	<nav>
		<ul>
			<li ><a href="#">Home</a></li>
                        <li><a href="TrackOrder.jsp">Track</a></li>
			<li><a href="UserProfile.jsp">Profile</a></li>
			
                       <li> <a href="Logout.jsp">Logout</a></li>



		</ul>
	</nav>
        </header>
       <div class="forms">
           <form action="Order" name="reg" method="post" onsubmit="return validate()">
         <p>Customer Name</p>
         <input type="text" name="uname" placeholder="Enter Customer Name" required="" >
         <p>Product Volume</p>
            <input type="text" name="volume" placeholder="Enter Packed Product volume in (c.m.)">
            <p>From</p>
            <%--  <input type="text" name="from" placeholder="Enter Where u are?"> --%>
            <select name="from" >
                <option value="Hyderabad">Hyderabad</option>
                <option value="Kurnool">Kurnool</option>
                <option value="Vijayawada">Vijayawada</option>
                <option value="Belagav">Belagav</option>
                <option value="Mangalore">Mangalore</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Nagarcoel">Nagarcoel</option>
                <option value="Thiruchirapalli">Thiruchirapalli</option>
                <option value="Kochi"> Kochi </option>
            </select>
            <p>Destination</p>
            <%--<input type="text" name="destination" placeholder="Enter Destination">--%>
             <select name="destination" >
                <option value="Hyderabad">Hyderabad</option>
                <option value="Kurnool">Kurnool</option>
                <option value="Vijayawada">Vijayawada</option>
                <option value="Belagav">Belagav</option>
                <option value="Mangalore">Mangalore</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Nagarcoel">Nagarcoel</option>
                <option value="Thiruchirapalli">Thiruchirapalli</option>
                <option value="Kochi"> Kochi </option>
            </select>
            <input type="submit" name="submit" value="Submit">
    </form>
       </div>
</div>

    

</body>
</html>