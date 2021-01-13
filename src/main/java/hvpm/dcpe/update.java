
package hvpm.dcpe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author amey
 */
public class update {
    
    private int fp;
     private String name;           
   private int feespaid;      
   private int newfeespaid;
private int sid;
    public String getname() {
        return name;
    }


    public void setname(String name) {
        this.name = name;
    }        
      public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }        
                
public int getfp() {
        return fp;
    }

    public void setfp(int fp) {
        this.fp = fp;
    }




public boolean update2()
    {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="select * from students where sid="+sid;
            Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          if(rs.next())
          {
             
          this.feespaid=rs.getInt("feespaid");
		
	newfeespaid = feespaid + fp;
        
        }
        }
       catch(Exception er) 
       {
          
       }
        return false;
        
    }
    
}
