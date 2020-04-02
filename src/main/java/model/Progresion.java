package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Progresion {
	private int id;
	private int id_bug;
	private String status;
	private String progresion;
	
	public Progresion(int id,int id_bug,String status,String progresion) {
		this.id=id;
		this.id_bug=id_bug;
		this.progresion=progresion;
		this.status=status;
	}

	public  void createTbProgresion(){
		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("CREATE TABLE IF NOT EXISTS Progresion(id int NOT NULL AUTO_INCREMENT,id_bug int ,status varchar(50),progresion varchar(50),PRIMARY KEY(id),FOREIGN KEY (id_bug) REFERENCES Bug(id))");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	
	public int getId() {
		return id;
	}
	public int getId_bug() {
		return  id_bug;
	}
	public String getStatus() {
		return status;
	}
	public String getProgresion() {
		return progresion;
	}
	
}
