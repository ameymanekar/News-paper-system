/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvpm.dcpe;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
public class Student 
{
  
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
    public int getReFees() {
        return refees;
    }

    public void setReFees(int refees) {
        this.refees = refees;
    }

    public int getFeespaid() {
        return feespaid;
    }

    public void setFeespaid(int feespaid) {
        this.feespaid = feespaid;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getcast() {
        return cast;
    }

    public void setcast(String cast) {
        this.cast = cast;
    }
    
    
    
    
    
    
    
    
     public String getaddrno() {
        return addrno;
    }

    public void setaddrno(String addrno) {
        this.addrno = addrno;
    }
      public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }
    
    private String addrno;
            private String gender;
   private String cast;
private int sid;
private String name;
private String course;
private int fees;
private int feespaid;
private String DOB;
private String email;
private String joindate;
private String status;
private String contactno;


 private int fp;
     private String name2;               
   private int newfeespaid;
   private int refees;
    private int ddd;
    public String getname() {
        return name;
    }
    public void setname2(String name2) {
        this.name2 = name2;
    }        
   
                
public int getfp() {
        return fp;
    }

    public void setfp(int fp) {
        this.fp = fp;
    }




    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    
    
    
    
    public boolean update55()
    {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="select * from students where sid= "+sid+"";
            
            Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          if(rs.next())
          {
           refees=rs.getInt("refees");  
          feespaid=rs.getInt("feespaid");
          
	System.out.println("rows effected"+feespaid);
        System.out.println("rows effected"+fp);
	
          
        newfeespaid = refees - fp;
       if(newfeespaid<=fees)
           newfeespaid=newfeespaid+0;
       else
           newfeespaid=feespaid;
            update33(newfeespaid,sid);
        
        
         
         System.out.println("rows effected"+newfeespaid); 
        }
        }
       catch(ClassNotFoundException | SQLException er) 
       {
          er.printStackTrace();
       }
        return false;
        
    }
    
     private void update33(int newfeespaid, int sid) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
         
            String sql="Update students Set refees= "+newfeespaid+" where sid= "+sid+"";
            
            Statement smt=con.createStatement();
           int count =smt.executeUpdate(sql);
           System.out.println("rows effected55555"+count);
        }
        
       catch(ClassNotFoundException | SQLException er) 
       {
           er.printStackTrace();
       }
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean update2()
    {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="select * from students where sid= "+sid+"";
            
            Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          if(rs.next())
          {
           refees=rs.getInt("refees");  
          feespaid=rs.getInt("feespaid");
          
	System.out.println("rows effected"+feespaid);
        System.out.println("rows effected"+fp);
	
          
        newfeespaid = feespaid + fp;
       if(newfeespaid<=fees)
           newfeespaid=newfeespaid+0;
       else
           newfeespaid=feespaid;
            update3(newfeespaid,sid);
        
        
         
         System.out.println("rows effected"+newfeespaid); 
        }
        }
       catch(ClassNotFoundException | SQLException er) 
       {
          er.printStackTrace();
       }
        return false;
        
    }
    
    
     private void update3(int newfeespaid, int sid) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
         
            String sql="Update students Set feespaid= "+newfeespaid+" where sid= "+sid+"";
            String sql2="Update students Set fp= "+fp+" where sid= "+sid+"";
            Statement smt=con.createStatement();
           int count =smt.executeUpdate(sql);
           int count2 =smt.executeUpdate(sql2);
           System.out.println("rows effected"+count);
           System.out.println("rows effected"+count2);
        }
        
       catch(ClassNotFoundException | SQLException er) 
       {
           er.printStackTrace();
       }
    
    
    
    }
    
    
    
    
    public boolean load()
    {
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
          String msql="select * from students where sid="+sid  ;
          Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          if(rs.next())
          {
              
              
              this.name=rs.getString("name");
              this.course= rs.getString("course");
              this.fees= rs.getInt("fees");
              this.feespaid=rs.getInt("feespaid");
              this.joindate=rs.getString("joindate");
              this.cast=rs.getString("cast");   
              this.DOB=rs.getString("DOB");
              this.email=rs.getString("email");
              this.addrno=rs.getString("addrno");
              this.gender=rs.getString("gender");
              this.fp=rs.getInt("fp");
              
              this.contactno=rs.getString("contactno");
             
              
          }
          con.close();
          return true;
        }
        catch(Exception er)
        {
            
        }
        return false;
    }
    public Vector list(int max)
    {
        Vector vlist=new Vector();
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
          String msql="select * from students order by sid desc"  ;
          Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          while(rs.next())
          {
              Student s=new Student();
              s.setSid(rs.getInt("sid"));
              s.setName(rs.getString("name"));
              s.setCourse(rs.getString("course"));
              s.setFees(rs.getInt("fees"));
              
              s.setFeespaid(rs.getInt("feespaid")); 
              s.setJoindate(rs.getString("joindate"));
              s.setcast(rs.getString("cast"));
              s.setDOB(rs.getString("DOB"));
              s.setemail(rs.getString("email"));
              s.setaddrno(rs.getString("addrno"));
              s.setgender(rs.getString("gender"));
              s.setContactno(rs.getString("contactno"));
              vlist.add(s);
              
          }
          con.close();
          return vlist;
        }
        catch(Exception er)
        {
            
        }
        return vlist;
    }
    
    public Vector list(String pattern)
    {
        Vector vlist=new Vector();
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
          String msql="select * from students where name like '"+pattern+"%' OR cast like '"+pattern+"%' OR course like '"+pattern+"%'   order by sid desc"  ;
          Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          while(rs.next())
          {
              Student s=new Student();
              s.setSid(rs.getInt("sid"));
              s.setName(rs.getString("name"));
              s.setCourse(rs.getString("course"));
              s.setFees(rs.getInt("fees"));        
              s.setFeespaid(rs.getInt("feespaid"));
              s.setJoindate(rs.getString("joindate"));
              s.setaddrno(rs.getString("addrno"));
              s.setgender(rs.getString("gender"));
              s.setDOB(rs.getString("DOB"));
              s.setemail(rs.getString("email"));
              s.setcast(rs.getString("cast"));
              s.setContactno(rs.getString("contactno"));
               s.setReFees(rs.getInt("refees"));
              vlist.add(s);
              
          }
          con.close();
          return vlist;
        }
        catch(Exception er)
        {
            
        }
        return vlist;
    }
    
    public Vector list22(String pattern)
    {
        Vector vlist=new Vector();
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
          String msql="select * from students where cast  like '"+pattern+"%'  order by sid desc"  ;
          Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          while(rs.next())
          {
              Student s=new Student();
              s.setSid(rs.getInt("sid"));
              s.setName(rs.getString("name"));
              s.setCourse(rs.getString("course"));
              s.setFees(rs.getInt("fees"));        
              s.setFeespaid(rs.getInt("feespaid"));
              s.setJoindate(rs.getString("joindate"));
              s.setaddrno(rs.getString("addrno"));
              s.setgender(rs.getString("gender"));
              s.setDOB(rs.getString("DOB"));
              s.setemail(rs.getString("email"));
              s.setcast(rs.getString("cast"));
              s.setContactno(rs.getString("contactno"));
              vlist.add(s);
              
          }
          con.close();
          return vlist;
        }
        catch(Exception er)
        {
            
        }
        return vlist;
    }
    
    
    
    public Vector list33(String pattern)
    {
        Vector vlist=new Vector();
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
          String msql="select * from students where name   like '"+pattern+"%' OR cast like '"+pattern+"%' OR course like '"+pattern+"%' order by sid desc"  ;
          Statement smt=con.createStatement();
          ResultSet rs=smt.executeQuery(msql);
          while(rs.next())
          {
              Student s=new Student();
              s.setSid(rs.getInt("sid"));
              s.setName(rs.getString("name"));
              s.setCourse(rs.getString("course"));
              s.setFees(rs.getInt("fees"));        
              s.setFeespaid(rs.getInt("feespaid"));
              s.setJoindate(rs.getString("joindate"));
              s.setaddrno(rs.getString("addrno"));
              s.setgender(rs.getString("gender"));
              s.setDOB(rs.getString("DOB"));
              s.setemail(rs.getString("email"));
              s.setcast(rs.getString("cast"));
              s.setContactno(rs.getString("contactno"));
              vlist.add(s);
              
          }
          con.close();
          return vlist;
        }
        catch(Exception er)
        {
            
        }
        return vlist;
    }
    
    
    
    
    
    
    
    
    
    
    public boolean updatePhoto(int sid,InputStream istream)
    {
        try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
      
      this.sid=sid;
      String ssql="select * from photos where sid="+sid;
      Statement ssmt=con.createStatement();
      ResultSet rs=ssmt.executeQuery(ssql);
      if(rs.next())
      {
         String msql="update photos set photo=? where sid=?";
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setInt(2,sid);
        smt.setBlob(1, istream);
        smt.executeUpdate();
        System.out.print("Updated..");
      }
      else
      {
        String msql="insert into photos values(?,?)";
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setInt(1,sid);
        smt.setBlob(2, istream);
        smt.executeUpdate();
        System.out.print("Inserted..");
      }
      con.close();
    
      return true;
      }
      catch(Exception er)   
      {
          
      }
     return false;
    }
    
    public String getPhotoURL()
    {
        String purl="images/photo.png";
         try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
      
      
      String ssql="select * from photos where sid="+sid;
      Statement ssmt=con.createStatement();
      ResultSet rs=ssmt.executeQuery(ssql);
      if(rs.next())
          purl="getdbphoto.jsp?sid="+sid;
      }
         catch(Exception er)
         {
             
         }
         return purl;
    }
    public byte[] getPhoto(int sid)
    {
        byte arr[]=null;
         try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
      
      
      String ssql="select photo from photos where sid="+sid;
      Statement ssmt=con.createStatement();
      ResultSet rs=ssmt.executeQuery(ssql);
      if(rs.next())
        {
            
        InputStream in=rs.getBinaryStream("photo");
        arr=new byte[in.available()];
        in.read(arr);
        in.close();
        System.out.println("found photo..");
        return arr;
        }
       con.close();
      }
         catch(Exception er)
         {
             
         }
         return arr;
    }
    
    public boolean insert()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="insert into students(name,course,fees,feespaid,contactno,joindate,DOB,email,cast,addrno,gender,refees) values(?,?,?,?,?,'"+joindate+"','"+DOB+"',?,?,?,?,?)";
            PreparedStatement smt=con.prepareStatement(msql);
            smt.setString(1,name);
            smt.setString(2,course);
            smt.setInt(3,fees);
            smt.setInt(4, feespaid);
            smt.setString(5,contactno);
            smt.setString(6,email);
            smt.setString(7,cast);
            smt.setString(8,addrno);  
            smt.setString(9,gender);
            refees = fees - feespaid;
             smt.setInt(10,refees);
            smt.executeUpdate();
            con.close();
            return true;
        }
       catch(ClassNotFoundException | SQLException er) 
       {
          er.printStackTrace();  
       }
        return false;
    }
    
    
    public boolean update()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="Update students set name=?,course=?,fees=?,feespaid=?,joindate=?,contactno=?,DOB=?,cast=?,addrno=?,gender=?,email=? where sid=" +sid;
            PreparedStatement smt=con.prepareStatement(msql);
            smt.setString(1,name);
            smt.setString(2,course);     
            smt.setInt(3,fees);
            smt.setInt(4, feespaid);
            smt.setString(5,joindate);
            smt.setString(6,contactno);
            smt.setString(7,DOB);
            smt.setString(8,cast);
            smt.setString(9,addrno);
            smt.setString(10,gender);
            smt.setString(11,email);
            smt.executeUpdate();
            
            con.close();
            return true;
        }
       catch(ClassNotFoundException | SQLException er) 
       {
         er.printStackTrace();  
       }
        return false;
    }

   
           public boolean delete()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
            String msql="DELETE FROM students WHERE sid= "+sid+"";
            PreparedStatement smt=con.prepareStatement(msql);
           //  Backup(sid);
             smt.executeUpdate();
            
            return true;
        }
       catch(ClassNotFoundException | SQLException er) 
       {
          er.printStackTrace();  
       }
        return false;
    }
    
    
   private void Backup(int sid) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hvpm", "root", "root");
         
            String sql="Update students Set feespaid= "+newfeespaid+" where sid= "+sid+"";
            String sql2="Update students Set fp= "+fp+" where sid= "+sid+"";
            Statement smt=con.createStatement();
           int count =smt.executeUpdate(sql);
           int count2 =smt.executeUpdate(sql2);
           System.out.println("rows effected"+count);
           System.out.println("rows effected"+count2);
        }
        
       catch(ClassNotFoundException | SQLException er) 
       {
           er.printStackTrace();
       }
   
    
    
    }

    private void alert(String feespaid_is_greater_than_fees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setrefees(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class session {

        public session() {
        }
    }

    private static class response {

        private static void sendRedirect(String indexjsplogin0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public response() {
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

    
    


