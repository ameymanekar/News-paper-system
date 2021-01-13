<%@page import="hvpm.dcpe.Student"%>
<%@page import="java.util.Vector"%>

<style>
    
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
</style>
 <%
        String search = "";
        if (request.getParameter("search") != null) {
            search = request.getParameter("search");
        }
    %>
<form>
               <h3> Name : <input type="text" name="search" size="40" value='<%=search%>' placeholder="Search.." required />
               </h3>
            </form>
               <table style="width:100%"  border="1"  >
             <tr>
                   
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
                       <th>Delete</th>
                   
                </tr>
               
                <%
                Student stud=new Student();
                Vector vlist=stud.list(search);
                for(int i=0;i<vlist.size();i++)
            {
                Student s=(Student)vlist.get(i);
                %>
                <tr> 
                    <td><%=s.getName()%></td> <td><%=s.getEmail()%></td> <td><%=s.getContactno()%></td>
                    <td><%=s.getHouseno()%></td> <td><%=s.getColony()%></td> <td><%=s.getLandmark ()%></td>
                    <td><%=s.getCity ()%></td> <td><%=s.getFlag()%></td> <td><%=s.getNamen()%></td>
                       <td><%=s.getDelcharges()%></td> <td><%=s.getDate()%></td> 
                      <td><a href='staffdel2.jsp?sid=<%=s.getSid()%>' ><img src="images/Delete.png" height="30px"></a></td>
                    
                   </tr>
                <%  
            }
             %>
            </table>
            
            
            
           