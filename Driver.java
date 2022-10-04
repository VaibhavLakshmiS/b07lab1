package geometry;

import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// to test add and multipy 
		
		/*double c1[] = {2,3,5};
        int e1[] = {1,2,3};
        
        double c2[] = {-1,12,4};
        int e2[] = {1,2,6};*/
        
		double c3[] = {1,2};
        int e3[] = {2,3};
        
        double c4[] = {2,3,4};
        int e4[] = {2,3,4};
        
        /*Polynomial p3= new Polynomial (c1,e1);
        Polynomial p2= new Polynomial (c2,e2);
        Polynomial p_3=p2.add(p3);*/
        //p5=p2.multiply(p3);
        Polynomial p4=new Polynomial(c3, e3);
        Polynomial p5=new Polynomial(c4, e4);
        
        Polynomial p6=p4.add(p5);
        Polynomial p7=p4.multiply(p5);
        //System.out.println(p3.evaluate(0));
       for(int i=0; i<p6.coefficients.length; i++) {
            
            System.out.print(p6.coefficients[i] + " ");        
        }
        
        System.out.println();
        
        for(int i=0; i<p6.exponents.length; i++) {
            
            System.out.print(p6.exponents[i] + " ");            
        }
        System.out.println();
        
        
      for(int i=0; i<p7.coefficients.length; i++) {
            
            System.out.print(p7.coefficients[i] + " ");        
        }
        
        System.out.println();
        
        for(int i=0; i<p7.exponents.length; i++) {
            
            System.out.print(p7.exponents[i] + " ");            
        }
        System.out.println();
        // to test the constructor 
	       File test= new File("C:\\Users\\laksh\\Desktop\\CSCB07\\lecs\\lab2.txt");
	       Polynomial file = new Polynomial(test);
	       for ( int i=0; i<file.coefficients.length; i++) {
	    	   System.out.println(file.coefficients[i]);
	    	   
	       }
	       for ( int i=0; i<file.coefficients.length; i++) {
	    	   System.out.println(file.exponents[i]);
	    	   
	       }
	       file.SavetoFile("C:\\Users\\laksh\\Desktop\\CSCB07\\lecs\\new.txt"); // checks the last method
	       
	      
	       
	       
	       
	     
	       
	       
	        
	        
	}
}


		  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	
		
		
		

























		  
	

