package model;


import java.sql.SQLException;
import java.util.Iterator;

public class main {
    
	public static void TestDell() throws SQLException {
	
		Product p=new Product(1,"soft",3);
		Product p1=new Product(2,"soft",3);
		p.insertProduct(p1);
		p.insertProduct(p);
		p.selectALLProduct();
		int aux=p.productSize();
		 
		p.deleteProdus(1);
		
		p.selectALLProduct();
		
				if(aux+1==p.productSize()) 
					 System.out.println("Test OK");
				  else
					  System.out.println("Test BAD");
		 }
	public static void TestSel() throws SQLException {
		
		Product p=new Product(1,"soft",3);

		p.insertProduct(p);
		p.selectProduct(1);
	
		int ok = 0;

		 Iterator<Product> iterator = p.l.iterator();
		    while (iterator.hasNext()) {
		      Product c = iterator.next();
		        if (c.getProductid()==p.getProductid()) 
		        	ok=1;
		    }
		    if (ok==1)
		   	 	System.out.println("Test OK");
			  else
				  System.out.println("Test BAD");
	}
	public static void TestIns() throws SQLException {
		
		Product p=new Product(1,"soft",3);

		//p.insertProduct(p);
		p.selectProduct(1);
	
		int ok = 0;

		 Iterator<Product> iterator = p.l.iterator();
		    while (iterator.hasNext()) {
		      Product c = iterator.next();
		        if (c.getProductid()==p.getProductid()) 
		        	ok=1;
		    }
		    if (ok==1)
		   	 	System.out.println("Test OK");
			  else
				  System.out.println("Test BAD");
	}
	public static void TestUP() throws SQLException {
		
		Product p=new Product(1,"soft",3);
	
		
		int f1=p.getProductid();
		String f2=p.getProductName();
		int f3=p.getProductEmployid();
		p.updateProdus("hard", 6);
		
		p.selectProduct(f1);
		int ok = 0;

		 Iterator<Product> iterator = p.l.iterator();
		    while (iterator.hasNext()) {
		      Product c = iterator.next();
		        if (c.getProductid()==f1 && f2!=c.getProductName() && f3!=c.getProductEmployid()) 
		        	ok=1;
		    }
		    if (ok==1)
		   	 	System.out.println("Test OK");
			  else
				  System.out.println("Test BAD");
	}
		
		
	
	public static void main(String[] args) throws SQLException {
	
		Db_conection con=new Db_conection();
		
		con.getConection();
		/*
		Bug b=new Bug(1,"bug1",1,"c://img1.img","program1");
		Bug b1=new Bug(2,"bug2",2,"c://img2.img","program2");
		Bug b2=new Bug(3,"bug3",1,"c://img3.img","program1");
		Bug b3=new Bug(4,"bug4",3,"c://img4.img","program3");
		//b.createTbBug();
		
		Employe e=new Employe(1, "andrei", "trifandrei@yahoo.com");
		Employe e1=new Employe(2, "matei", "mate1@yahoo.com");
		Employe e3=new Employe(3, "paul", "paul@yahoo.com");
	    // e.createTbEmploye();
		
		Product p=new Product(1,"soft",3);
		//p.createTbProduct();
		
		Progresion pr=new Progresion(1,1,"hard","50%");
		//pr.createTbProgresion();
		
		//e.insertBug(b);
		//e.insertBug(b1);
		//e.insertBug(b2);
		//e.insertBug(b3);
		
		//b.assigneBug(e.getNume(),e.getEmail(), b.getId());
		//b1.assigneBug(e1.getNume(), e1.getEmail(), b1.getId());
		//b2.assigneBug(e3.getNume(), e3.getEmail(), b2.getId());
		
		p.insertProduct(p);
		//p.deleteProdus(1);
		//p.updateProdus(nume, employid);
		//p.selectProduct();
		
		//e.addProgresion(pr, b);
		//System.out.println("------------------------------------------");
		//e.readBug(1);
		*/
		TestDell();
		TestSel();
		TestIns();
		TestUP();
	}

}
