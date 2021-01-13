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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
public class Student 
{
  

private int sid;
private String name; 
private String email;
private String contactno; 
private String houseno;
private String colony;
private String landmark; 
private String city;
private String flag;
private String newspaper; 
private String date;
private int delcharges;
private String userid;
private String pwd;
private String userrole;
private int rate;
private String paperdesc;

private int amount;
private int tdate;
private String date1;
private String date2;
private String paperrate;
private String namen;
private String cdate;





public String getCdate() {
	return cdate;
}
public void setCdate(String cdate) {
	this.cdate = cdate;
}
public String getNamen() {
	return namen;
}
public void setNamen(String namen) {
	this.namen = namen;
}
public String getPaperrate() {
	return paperrate;
}
public void setPaperrate(String paperrate) {
	this.paperrate = paperrate;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getTdate() {
	return tdate;
}
public void setTdate(int tdate) {
	this.tdate = tdate;
}
public String getDate1() {
	return date1;
}
public void setDate1(String date1) {
	this.date1 = date1;
}
public String getDate2() {
	return date2;
}
public void setDate2(String date2) {
	this.date2 = date2;
}






public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public String getPaperdesc() {
	return paperdesc;
}
public void setPaperdesc(String paperdesc) {
	this.paperdesc = paperdesc;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getUserrole() {
	return userrole;
}
public void setUserrole(String userrole) {
	this.userrole = userrole;
}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getHouseno() {
	return houseno;
}
public void setHouseno(String houseno) {
	this.houseno = houseno;
}
public String getColony() {
	return colony;
}
public void setColony(String colony) {
	this.colony = colony;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
public String getNewspaper() {
	return newspaper;
}
public void setNewspaper(String newspaper) {
	this.newspaper = newspaper;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getDelcharges() {
	return delcharges;
}
public void setDelcharges(int delcharges) {
	this.delcharges = delcharges;
}

    



public boolean Customerinsert() throws ClassNotFoundException
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="insert into customer(name,email,contactno,houseno,colony,landmark,city,flag,newspaper,date,delcharges,namen,rate) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String msql2="select * from newspaper where sid = "+newspaper+"";
        Statement smt2=con.createStatement();
        ResultSet rs=smt2.executeQuery(msql2);
        while(rs.next())
        {
          
           rs.getInt("sid");
         String namen =  rs.getString("name");
          int rate = rs.getInt("rate");
        
        
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setString(1,name);
        smt.setString(2,email);
        smt.setString(3,contactno);
        smt.setString(4,houseno);
        smt.setString(5,colony);
        smt.setString(6,landmark);
        smt.setString(7,city);
        smt.setString(8,flag);  
        smt.setString(9,newspaper);
        smt.setString(10,date);
        smt.setInt(11,delcharges);
        smt.setString(12,namen);
        smt.setInt(13,rate);
      
        smt.executeUpdate();
        con.close();
        return true;
    }
    }
   catch( SQLException er) 
   {
      er.printStackTrace();  
   }
    return false;
}


public boolean Productinsert() throws ClassNotFoundException
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="insert into newspaper(name,rate,paperdesc) values(?,?,?)";
      
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setString(1,name);
        smt.setInt(2,rate);
        smt.setString(3,paperdesc);
       
      
        smt.executeUpdate();
        con.close();
        return true;
    
    }
   catch( SQLException er) 
   {
      er.printStackTrace();  
   }
    return false;
}





















public Vector list(int max)
{
    Vector vlist=new Vector();
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from newspaper order by sid desc"  ;
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      {
          Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setRate(rs.getInt("rate"));
          s.setPaperdesc(rs.getString("paperdesc"));
         
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

public Vector list2(int max)
{
    Vector vlist=new Vector();
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from customer order by sid desc"  ;
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      { 
          Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setEmail(rs.getString("email"));
          s.setContactno(rs.getString("contactno"));
          s.setHouseno(rs.getString("houseno"));
          s.setColony(rs.getString("colony"));
          s.setLandmark(rs.getString("landmark"));
          s.setCity(rs.getString("city"));
          s.setFlag(rs.getString("flag"));
          s.setNewspaper(rs.getString("newspaper"));
          s.setNamen(rs.getString("namen"));
          s.setDate(rs.getString("date"));
          s.setDelcharges(rs.getInt("delcharges"));
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
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from customer where flag like '"+pattern+"%'order by sid desc"  ;
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      {
    	  Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setEmail(rs.getString("email"));
          s.setContactno(rs.getString("contactno"));
          s.setHouseno(rs.getString("houseno"));
          s.setColony(rs.getString("colony"));
          s.setLandmark(rs.getString("landmark"));
          s.setCity(rs.getString("city"));
          s.setFlag(rs.getString("flag"));
          s.setNewspaper(rs.getString("newspaper"));
          s.setNamen(rs.getString("namen"));
          s.setDate(rs.getString("date"));
          s.setDelcharges(rs.getInt("delcharges"));
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


public Vector list21(String pattern)
{
    Vector vlist=new Vector();
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from newspaper where name like '"+pattern+"%'order by sid desc"  ;
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      {
    	  Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setPaperdesc(rs.getString("paperdesc")); 
          s.setRate(rs.getInt("rate"));
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

public Vector list211(int max)
{
    Vector vlist=new Vector();
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from newspaper order by sid desc"  ;
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      { 
          Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setPaperdesc(rs.getString("paperdesc")); 
          s.setRate(rs.getInt("rate"));
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
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      String msql="select * from customer where name like '%"+pattern+"%'order by sid desc"  ;
      System.out.println(pattern);
      Statement smt=con.createStatement();
      ResultSet rs=smt.executeQuery(msql);
      while(rs.next())
      {
          Student s=new Student();
          s.setSid(rs.getInt("sid"));
          s.setName(rs.getString("name"));
          s.setRate(rs.getInt("rate"));
          s.setPaperdesc(rs.getString("paperdesc"));
         
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



public boolean deleteproduct() throws ClassNotFoundException
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="DELETE FROM newspaper WHERE sid= "+sid+"";
        PreparedStatement smt=con.prepareStatement(msql);
     
         smt.executeUpdate();
        
        return true;
    }
   catch(SQLException er) 
   {
      er.printStackTrace();  
   }
    return false;
}










public boolean delete() throws ClassNotFoundException
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="DELETE FROM customer WHERE sid= "+sid+"";
        PreparedStatement smt=con.prepareStatement(msql);
     
         smt.executeUpdate();
        
        return true;
    }
   catch(SQLException er) 
   {
      er.printStackTrace();  
   }
    return false;
}


public boolean update() throws ClassNotFoundException
{
    try{                                              
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="Update customer set name=?,email=?,contactno=?,houseno=?,colony=?,landmark=?,city=?,flag=?,newspaper=?,date=?,delcharges=? where sid=" +sid;
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setString(1,name);
        smt.setString(2,email);
        smt.setString(3,contactno);
        smt.setString(4,houseno);
        smt.setString(5,colony);
        smt.setString(6,landmark);
        smt.setString(7,city);
        smt.setString(8,flag);  
        smt.setString(9,newspaper);
        smt.setString(10,date);
        smt.setInt(11,delcharges);
      
        smt.executeUpdate();
        con.close();
        return true;
    }
   catch(SQLException er) 
   {
     er.printStackTrace();  
   }
    return false;
}





public boolean updateproduct() throws ClassNotFoundException
{
    try{                                              
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="Update newspaper set name=?,rate=?,paperdesc=? where sid=" +sid;
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setString(1,name);
        smt.setInt(2,rate);
        smt.setString(3,paperdesc);
      
        
      
        smt.executeUpdate();
        con.close();
        return true;
    }
   catch(SQLException er) 
   {
     er.printStackTrace();  
   }
    return false;
}





public boolean billupdate() throws ClassNotFoundException, ParseException
{
	 
    try{
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date dt1 = sdf.parse(date1);
    	Date dt2 = sdf.parse(date2);
    	long diff = dt2.getTime() - dt1.getTime();
    	System.out.println("Days: " + diff / 1000L / 60L / 60L / 24L);
    	long Days =  diff / 1000L / 60L / 60L / 24L ;
    	int i=(int)Days;
    	tdate = i;
    	int b = tdate * delcharges ;
    	int c = rate * tdate;
    	amount = b + c;
    	
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
      
           String msql3="Update bill set amount=?,tdate=?,date1=?,date2=?,cdate=? where name= '"+name+"'";
           PreparedStatement smt4=con.prepareStatement(msql3);
           
           smt4.setInt(1,amount);
           smt4.setInt(2,tdate);
           smt4.setString(3,date1);   
           smt4.setString(4,date2);
           smt4.setString(5,cdate);
           smt4.executeUpdate();
           con.close();
           return true;
           
       
    }
    
   catch( SQLException er) 
   {
      er.printStackTrace();  
     
   }
    
    return false;
}

public boolean billinsert() throws ClassNotFoundException, ParseException
{
	 
    try{
    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/news", "root", "root");
        String msql="insert into bill(name,email,contactno,houseno,colony,landmark,city,delcharges,amount,tdate,date1,newspaper,date2,cdate,rate,namen) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String msql2="select * from newspaper where sid = "+newspaper+"";
        Statement smt2=con.createStatement();
        ResultSet rs=smt2.executeQuery(msql2);
        while(rs.next())
        {
          
           rs.getInt("sid");
         String namen =  rs.getString("name");
          int rate = rs.getInt("rate");
          
        PreparedStatement smt=con.prepareStatement(msql);
        smt.setString(1,name);
        smt.setString(2,email);
        smt.setString(3,contactno);
        smt.setString(4,houseno);
        smt.setString(5,colony);
        smt.setString(6,landmark);
        smt.setString(7,city);
        smt.setInt(8,delcharges);
        smt.setInt(9,amount);
        smt.setInt(10,tdate);
        smt.setString(11,date1);
        smt.setString(12,newspaper);
        smt.setString(13,date2);
        smt.setString(14,cdate);
        smt.setInt(15,rate);
        smt.setString(16,namen);
        smt.executeUpdate();
        con.close();
        
        return true;
        
        }
    }
   catch( SQLException er) 
   {
      er.printStackTrace();  
     
   }
    
    return false;
}





















    
    
    
}

    
    


