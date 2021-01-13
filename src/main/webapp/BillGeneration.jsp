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
.errmsg{font-family: arial;
    font-size: 20pt;
    color: #ffffff;
    text-align: center;}

</style>
<%
 String loginmsg="";
 if(request.getParameter("login")!=null)
    loginmsg="Invalid UserID/Pwd";
 %>
 <%
        String search = "Yes";
        if (request.getParameter("search") != null) {
            search = request.getParameter("search");
        }
    %>
<form>
               <h3>  <input type="hidden" name="search" size="40" value='<%=search%>' placeholder="Search.." required />
               </h3>
            </form>
               <table style="width:100%"  border="1"  >
             <tr>
                     <th>Name</th>
                   
                    <th>Contact No</th>
                    
                     <th>NewsPaper </th>
                      <th>Delivery Charges</th>
                    
                       <th>Calculate Bill</th>
                       <th>Print Bill</th>
                   
                </tr>
                
                 <%
                Student stud=new Student();
                Vector vlist=stud.list(search);
                for(int i=0;i<vlist.size();i++)
            {
                Student s=(Student)vlist.get(i);
                %>
                <tr> 
                    <td><%=s.getName()%></td> <td><%=s.getContactno()%></td> 
                     <td><%=s.getNamen()%></td>
                      <td><%=s.getDelcharges()%>Rs.</td>  
                      <td><a href='getbill.jsp?sid=<%=s.getSid()%>'><img src="images/bill.png" height="30px"></a></td>
                    <td><a href='printbill22.jsp?sid=<%=s.getName()%>'><img src="images/print.png" height="30px"></a></td>
                    
                   </tr>
                <%  
            }
             %>
                    
                    
            </table>
             <div  class="errmsg">  <%=loginmsg%>
					</div>