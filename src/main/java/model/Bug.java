package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Bug {
	private int id;
	private String bug_name;
	private String screenshots;
	private String tag;
	private int productid;
	
	public Bug( int id,String bug_name,int product_id1,String screenshots,String tag) {
		this.id=id;
		this.bug_name=bug_name;
		this.screenshots=screenshots;
		this.tag=tag;
		this.productid=product_id1;
	}
	public  void createTbBug(){
		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("CREATE TABLE IF NOT EXISTS Bug(id int NOT NULL AUTO_INCREMENT,bug_name varchar(50) ,product_id int,screenshots varchar(50),tag varchar(50),PRIMARY KEY(id))");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	public void assigneBug(String employe_name,String email,int noBug) {

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("INSERT INTO employe 	( nume,e_mail,asignned_bug) VALUES ('"+employe_name+"','"+email+"','"+noBug+"')");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		
	}
	
	public int getProductid() {
		return this.productid;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.bug_name;
	}
	public String getScreenshots() {
		return this.screenshots;
	}
	public String getTag() {
		return this.tag;
	}
}
