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
       background-color: #offwhite;
       align="center"
}  
table {
    border-collapse: collapse;
    width: 100%;
    align="center"
    
}

th, td {
    text-align: left;
    padding: 6px;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14px;
    align="center"
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
    font-family: Arial, Helvetica, sans-serif;
    align="center"
}
 body
{
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}
table
{
    align="center"
}

tr td:first-child:before
{
  counter-increment: Serial;      /* Increment the Serial counter */
  content: " " counter(Serial); /* Display the counter */
  align="center"
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
<center><h1>Papers</h1>
            </form>
            <div style="align:center;">
               <table style="width:70%"  border="1"  >
             <tr>
                   <th>Sr. No.</th>
                    <th>Paper Name</th>
                      <th>Paper Rate</th>
                       <th>Paper Description</th>
                       
                   
                </tr>
               
                <%
                Student stud=new Student();
                Vector vlist=stud.list211(10);
                for(int i=0;i<vlist.size();i++)
            {
                Student s=(Student)vlist.get(i);
                %>
                <tr> 
                     <td></td>  
                    <td><%=s.getName()%></td>  
                    <td><%=s.getRate()%></td>   
                    <td><%=s.getPaperdesc()%></td>
                      
                   </tr>
                <%  
            }
             %>
            </table>
            </div>
             </center>
            <hr>
          
    </body>
</html>

