<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
body {
    margin-top: 20px;
}
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
<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong><%=resultSet.getString("name") %></strong>
                        <br>
                        <%=resultSet.getString("houseno") %>,<%=resultSet.getString("colony") %>
                        <br>
                        <%=resultSet.getString("landmark") %>,<%=resultSet.getString("city") %>
                        <br>
                        <abbr title="Phone">P:</abbr> <%=resultSet.getString("contactno") %>
                    </address>
                </div>
                	
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
          	
                    <p>
                        <em>Date Of Bill Genration: <%=resultSet.getString("cdate") %></em>
                    </p>
                    <p>
                        <em>Newspaper Name: <%=resultSet.getString("namen") %></em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Paper Name</th>
                            <th>#</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-md-9"><em><%=resultSet.getString("namen") %></em></h4></td>
                            <td class="col-md-1" style="text-align: center">  </td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("rate") %></td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("rate") %></td>
                        </tr>
                        <tr>
                            <td class="col-md-9"><em> </em></h4></td>
                            <td class="col-md-1" style="text-align: center">Delivery Charges</td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("delcharges") %></td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("delcharges") %></td>
                        </tr>
                        <tr>
                            <td class="col-md-9"><em> </em></h4></td>
                            <td class="col-md-1" style="text-align: center"> Total Days</td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("tdate") %></td>
                            <td class="col-md-1 text-center"><%=resultSet.getString("tdate") %></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal: </strong>
                            </p>
                            <p>
                             
                            </p></td>
                            <td class="text-center">
                            <p>
                                <strong>Rs. <%=resultSet.getString("amount") %></strong>
                            </p>
                            <p>
                              
                            </p></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>Rs. <%=resultSet.getString("amount") %></strong></h4></td>
                        </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-success btn-lg btn-block" value="Print this page" onClick="window.print()">
                    Print this page
                </button></td>
                  <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%> 
            </div>
        </div>
    </div>