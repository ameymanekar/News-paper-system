<%-- 
    Document   : viewaddmission
    Created on : Feb 25, 2018, 1:50:41 PM
    Author     : Asus
--%>
<%@page import="hvpm.dcpe.Student"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
   body {
       background-color: #cccccc;
}  
table {
    border-collapse: collapse;
    width: 100%;
    
}

th, td {
    text-align: left;
    padding: 6px;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
    font-family: Arial, Helvetica, sans-serif;
}
 body
{
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}
table
{
    
}

tr td:first-child:before
{
  counter-increment: Serial;      /* Increment the Serial counter */
  content: " " counter(Serial); /* Display the counter */
}

</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      </form>
            <hr>
<center><h1>Customers</h1></center>
            <table style="width:100%"  border="1"  >
             <tr>
         <th>Sr no.</th>

                    <th>Name</th>
                     <th>Email</th>
                    <th>Contact No</th>
                    <th>House No </th>
                   <th>Colony </th>
                   <th>Landmark </th>
                   <th> City </th>
                    <th>Flag </th>
                     <th>NewsPaper </th>
                      <th>Delivery Charges</th>
                       <th>Join Date </th>
                    
                   
                </tr>
                
                <%
                Student stud=new Student();
                Vector vlist=stud.list2(10);
                for(int i=0;i<vlist.size();i++)
            {
                Student s=(Student)vlist.get(i);
                %>
                <tr> 
                  <td></td>
                    <td><%=s.getName()%></td> <td><%=s.getEmail()%></td> <td><%=s.getContactno()%></td>
                    <td><%=s.getHouseno()%></td> <td><%=s.getColony()%></td> <td><%=s.getLandmark ()%></td>
                    <td><%=s.getCity ()%></td> <td><%=s.getFlag()%></td> <td><%=s.getNamen()%></td>
                       <td><%=s.getDelcharges()%>  Rs.</td>  <td><%=s.getDate()%></td>

                   </tr> 
                <%  
            }
             %>
           
            </table>
             
            <hr>
            
           
    </body>
</html>

