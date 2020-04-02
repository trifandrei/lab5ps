import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Iterator;

import model.Product;

public class Test {

	@org.junit.Test
	public void testDell() {
	
			Product p=new Product(1,"soft",3);
			Product p1=new Product(2,"soft",3);
			p.insertProduct(p1);
			p.insertProduct(p);
			p.selectALLProduct();
			int aux=p.productSize();
			 
			p.deleteProdus(1);
			
			p.selectALLProduct();
			
					if(aux+1==p.productSize()) 
						assert(true);
					  else
						  assert(false);
			 
	}
@org.junit.Test
public void TestSel() throws SQLException {
		
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
		    	assert(true);
			  else
				  assert(false);
	}

@org.junit.Test
public  void TestUP() throws SQLException {
	
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
	    	assert(true);
		  else
			  assert(false);
 }
@org.junit.Test
public  void TestIns() throws SQLException {
	
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
	    	assert(true);
		  else
			  assert(false);
}
}