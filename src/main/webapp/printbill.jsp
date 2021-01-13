<%-- 
    Document   : GetReceipt
    Created on : Feb 20, 2018, 12:15:57 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <html>
<head>
    <style> 
           body {font-family: Arial, Helvetica, sans-serif;}
           </style>

 <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String name = request.getParameter("sid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost/";
String database = "news";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
 <%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from bill where name= '"+name+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
</head>
<body>
<center>
    <div style="background-color: #ffff33; color:black; width:530px; height: 800px;">
     <fieldset style="width:500px; height: 800px; ">
<h4>Shree H.V.P.Mandal's</h4>
<h4>DEGREE COLLEGE OF PHYSICAL EDUCATION, AMRAVATI</h4>
<h4>(An Autonomous College)</h4>
 <h4><%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %><br>
R.NO &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Date:  <%= df.format(new java.util.Date()) %> <h4>
<h4>Student Name :- &nbsp;   &nbsp; <%=resultSet.getString("name") %> </h4>   
<h4>Course :-&nbsp;   &nbsp; </h4>
<table  style="width:100%" border="" >
    <tr>
    <th>SR. NO.</th>
    <th>College Fee</th> 
    <th>Amount</th>
  </tr>
    <tr>
    <td>1</td>
    <td>Paper Name</td>
    <td><%=resultSet.getString("newspaper") %></td>
  </tr>
  <tr> 
  


      <td>2</td>
   <td>Total Days</td>
    <td><%=resultSet.getString("tdate") %></td>   
      </tr>
  <tr> 
      <td>3</td>
    <td>Delivery Charges</td>
    <td><%=resultSet.getString("delcharges") %></td>   
      </tr>
  <tr> cdate
      <td>4</td>
    <td>Billing Date</td>
    <td><%=resultSet.getString("cdate") %></td>   
      </tr>
      <tr> 
      <td>5</td>
    <td>Amount</td>
    <td><%=resultSet.getString("amount") %></td>   
      </tr>
  <tr> 
      <td>6</td>
    <td>Vehicle Parking Fee</td>
    <td></td>   
      </tr>
  <tr> 
      <td>7</td>
    <td><h5>Total Fee Rupees<h5></td>
    <td>
    
    
    
    </td>   
      </tr>  
</table>

<h3> Signature<h3>
        .......................................
      <h3 style="right: "> Fee Collection Clerk</h3>




 
 </fieldset>
     <form>
<input type="button" value="Print this page" onClick="window.print()">
</form> 
 </div>
  
  <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>   
  
      
</center>

</body>
</html>

