package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Employe {
	private int  id;
	private String name;
	private String e_mail;
	
	public Employe(int id1,String name1,String e_mail1) {
		this.id=id1;
		this.name=name1;
		this.e_mail=e_mail1;	
	}
	
	public  void createTbEmploye(){

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("CREATE TABLE IF NOT EXISTS Employe(id int NOT NULL AUTO_INCREMENT,nume varchar(50) , e_mail varchar(50),asignned_bug int,PRIMARY KEY(id),FOREIGN KEY (asignned_bug) REFERENCES Bug(id))");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	public  void insertBug(Bug bug){

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("INSERT INTO bug(id, bug_name,product_id, screenshots, tag) VALUES ( '"+bug.getId()+"' , '"+bug.getName()+"','"+bug.getProductid()+"', '"+bug.getScreenshots()+"' , '"+bug.getTag()+"' )");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	public  void addProgresion(Progresion pr,Bug bug){

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("INSERT INTO Progresion(id, id_bug,status, progresion) VALUES ( '"+pr.getId()+"' , '"+bug.getId()+"','"+pr.getStatus()+"', '"+pr.getProgresion()+"' )");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}

	public  void readBug(int nobug){
		 ResultSet rs=null;
		try {
			Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("SELECT bug_name, product_id,screenshots, tag  FROM bug WHERE bug.id="+nobug+"");
			 rs=post.executeQuery();
				
					 while (rs.next()) {
						  String bug_name = rs.getString("bug_name");
						  System.out.println(bug_name );
						  String product_id = rs.getString("product_id");
						  System.out.println(product_id );
						  String screenshots = rs.getString("screenshots");
						  System.out.println(screenshots );
						  String tag = rs.getString("tag");
						  System.out.println(tag );
						}
			 
			
		 }catch(Exception e){
			 System.out.println(e);
		 }
		
		}

	public int getId() {
		return this.id;
	}
	public String getNume() {
		return this.name;
	}
	
	public String getEmail() {
		return this.e_mail;
	}
}
