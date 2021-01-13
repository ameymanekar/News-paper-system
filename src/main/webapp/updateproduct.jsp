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
                   
                    <th>Paper Name</th>
                      <th>Paper Rate</th>
                       <th>Paper Description</th>
                       <th>Delete Paper</th>
                   
                </tr>
               
                <%
                Student stud=new Student();
                Vector vlist=stud.list21(search);
                for(int i=0;i<vlist.size();i++)
            {
                Student s=(Student)vlist.get(i);
                %>
                <tr> 
                    
                    <td><%=s.getName()%></td>  
                    <td><%=s.getRate()%></td>   
                    <td><%=s.getPaperdesc()%></td>
                      <td><a href='frmupdateproduct.jsp?sid=<%=s.getSid()%>' ><img src="images/update data.png" height="30px"></a></td>
                    
                   </tr>
                <%  
            }
             %>
            </table>