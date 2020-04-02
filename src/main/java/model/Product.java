package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Product {
	public List<Product> l=new ArrayList<Product>();
	private String name;
	private int employ_id;
	private int id;
	public Product (int id, String name,int employ_id) {
		
		this.id=id;
		this.name=name;
		this.employ_id=employ_id;
	
	}
	public  void createTbProduct(){

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("CREATE TABLE IF NOT EXISTS Product(id int NOT NULL AUTO_INCREMENT,nume varchar(50) , employ_id int,PRIMARY KEY(id),FOREIGN KEY (employ_id) REFERENCES employe(id))");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	
	public void selectProduct(int id2) {
		 ResultSet rs=null;
			try {
				Db_conection con=new Db_conection();
				 Connection conn=con.getConection();
				 PreparedStatement post=conn.prepareStatement("SELECT id, nume, employ_id  FROM product WHERE id="+id2+"");
				 rs=post.executeQuery();
					
						 while (rs.next()) {
							  int id1 = rs.getInt("id");
							 // System.out.println(id );
							  String name1 = rs.getString("nume");
							//  System.out.println(name );
							  int employe_id1 = rs.getInt("employ_id");
							  //System.out.println(employe_id1);
							
							  Product p=new Product(id1,name1,employe_id1);
							  l.add(p);
							}
				
						 
			 }catch(Exception e){
				 System.out.println(e);
			 }
	}

			public void selectALLProduct() {
				 ResultSet rs=null;
					try {
						Db_conection con=new Db_conection();
						 Connection conn=con.getConection();
						 PreparedStatement post=conn.prepareStatement("SELECT *  FROM product");
						 rs=post.executeQuery();
							
								 while (rs.next()) {
									  int id1 = rs.getInt("id");
									 // System.out.println(id );
									  String name1 = rs.getString("nume");
									//  System.out.println(name );
									  int employe_id1 = rs.getInt("employ_id");
									  //System.out.println(employe_id1);
									
									  Product p=new Product(id1,name1,employe_id1);
									  l.add(p);
									}
						
								 
					 }catch(Exception e){
						 System.out.println(e);
					 }
			}
	
			public int productSize() {
				return l.size();
				
			}
	public void insertProduct(Product p){

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("INSERT INTO product(id, nume,employ_id) VALUES ( '"+p.getProductid()+"' , '"+p.getProductName()+"','"+p.getProductEmployid()+"' )");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
	
	public void deleteProdus(int idProdus) {

		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("DELETE FROM product WHERE id="+idProdus+"");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
		}
		
	public void updateProdus(String nume,int employid) {
		 try {
			 Db_conection con=new Db_conection();
			 Connection conn=con.getConection();
			 PreparedStatement post=conn.prepareStatement("UPDATE product SET nume='"+nume+"',employ_id="+employid+" WHERE id="+this.id+"");
			 post.executeUpdate();
		 }catch(Exception e){
			 System.out.println(e);
		 }
	}
	
	public int getProductid() {
		return this.id;
	}
	public String getProductName() {
		return this.name;
	}
	
	public int getProductEmployid() {
		return this.employ_id;
	}
	public boolean contProduct() {

	return true;
	}
}
