package geometry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Polynomial {
	double []coefficients;
	int [] exponents;
	
	public Polynomial () {
          coefficients=new double[1];
          exponents=new int[1];
          //coefficients[0]=0;
		}
	public Polynomial (double [] set_coefficients, int []set_exponents ) {
		coefficients = new double[set_coefficients.length];
		
		for ( int i=0;i<this.coefficients.length;i++)
		{
			coefficients[i]=set_coefficients[i];
		}
       exponents = new int[set_exponents.length];
		
		for ( int i=0;i<this.coefficients.length;i++)
		{
			exponents[i]=set_exponents[i];
		}
		
	}
	
	public Polynomial concatenate ( Polynomial pol) { // to concatenate the arrays of both polynomials
		
		double [] c_1;
		double [] c_2;
		double [] new_arr;
		int [] exponents_1;
		int [] exponents_2;
		int [] new_exponents;
		
		
        
		c_1=this.coefficients;
		c_2=pol.coefficients;
		exponents_1=this.exponents;
		exponents_2=pol.exponents;
		
		new_arr = new double[c_1.length+c_2.length];
		new_exponents = new int [exponents_1.length + exponents_2.length];
		int count=0;
		for ( int i=0; i<c_1.length;i++)
		{
			new_arr[i]=c_1[i];
			count++;
		}
		for ( int j=0;j<c_2.length;j++)
		{
			new_arr[count++]=c_2[j];
		}
		int count_1=0;
		for ( int i=0; i<exponents_1.length;i++)
		{
			new_exponents[i]=exponents_1[i];
			count_1++;
		}
		for ( int j=0;j<exponents_2.length;j++)
		{
			new_exponents[count_1++]=exponents_2[j];
		}
		return new Polynomial (new_arr,new_exponents);
		
	}
	
	public int count_length(Polynomial pol2) // to count the length of the new array 
	{
		int count=0;
		for ( int i=0;i<pol2.exponents.length;i++)
		{
			if ( pol2.exponents[i]!=-1) 
			{
				count++;
			}
		}
		return count;
	}
	public Polynomial remove_zero(Polynomial pol) // to remove 0 coefficient and its corresponding exponent's value
	{
	  double [] newarrr;
	  int [] new_expo;
	  int count=0;
	  for ( int i=0; i<pol.coefficients.length;i++) {
		  if (pol.coefficients[i]!=0)
		  {
			  count++;
		  }
	  }
	  newarrr = new double [count];
	  new_expo = new int[count];
	  int countt=0;
	  int counttt=0;
	  
	  for ( int i=0; i<pol.coefficients.length;i++) 
	  {
		  
		  if (pol.coefficients[i]!=0)
		  {
			  newarrr[countt++]=pol.coefficients[i];
			  new_expo[counttt++]=pol.exponents[i];
			  
		  }
		  
	  }
	   
	  return new Polynomial (newarrr,new_expo);
		

      }
	
    public Polynomial add(Polynomial pol1)
    {
       Polynomial new_pol = concatenate(pol1);
       double [] newarr1;
       int [] new_expo;
       for (  int i=0; i<new_pol.exponents.length;i++)
       {
    	 for ( int j=i+1;j<new_pol.coefficients.length;j++)
    	 {
    		 if ( new_pol.exponents[i]==new_pol.exponents[j]) 
    		 {
    				 new_pol.coefficients[i]+=new_pol.coefficients[j];
    			     new_pol.exponents[j]=-1; // marks the redundant exponents
    		 }
    		 
    	 }
       }
       int new_arr_len=count_length(new_pol);
       newarr1=new double[new_arr_len];
       new_expo=new int [new_arr_len];
       int count1=0;
       int count2=0;
       for ( int i=0; i<new_pol.coefficients.length;i++) 
       {
    	   if ( new_pol.exponents[i]!=-1) 
    	   {
    		   newarr1[count1++]=new_pol.coefficients[i];
    		   new_expo[count2++]=new_pol.exponents[i];
    	   }
       }
       Polynomial nozero= remove_zero(new Polynomial(newarr1,new_expo));
       return nozero;
    		   
       
    			 
}
    
   public Polynomial multiply ( Polynomial pol3)
 {
	     Polynomial Polynomial_obj= null;
	     double [] newarr; // the new arr
		 double [] smaller;// to store the smaller poly
		 double []bigger; // " " the bigger poly
		 double[] fin_pol; // final poly to be returned
		 int [] bigger_expo; // bigger expo
		 int [] smaller_expo; // smaller expo
		 int[] new_expo; // for the new expo
		 int [] fin_expo; // final expo to be returned
		 
		 
		
		 
		 if (this.coefficients.length>pol3.coefficients.length) // to find the bigger 
		 {
			 bigger = this.coefficients;
			 smaller = pol3.coefficients;
			 bigger_expo= this.exponents;
			 smaller_expo=pol3.exponents;
			 
		 }
		 else 
		 {
			 bigger = pol3.coefficients;
			 smaller = this.coefficients;
			 bigger_expo = pol3.exponents;
			 smaller_expo = this.exponents;
			 
		 }
		 
		 newarr=new double [bigger.length*smaller.length]; // size of array is m*n
		 new_expo=new int [bigger.length*smaller.length];
		 //int count=0;
		 int count1=0;
		 int count2=0;
		 for ( int i=0; i<bigger.length;i++) {
			 for (int j=0; j<smaller.length;j++)
			 {
				 newarr[count1++]=bigger[i]*smaller[j];
				 new_expo[count2++]=bigger_expo[i]+smaller_expo[j];
			 }
		 }
		 Polynomial_obj = new Polynomial ( newarr,new_expo);
		 
		 for (  int i=0; i<Polynomial_obj.coefficients.length;i++)
		 {
	    	 for ( int j=i+1;j<Polynomial_obj.coefficients.length;j++)
	    	 {
	    		 if ( Polynomial_obj.exponents[i]==Polynomial_obj.exponents[j])
	    		 {
	    			   Polynomial_obj.coefficients[i]+=Polynomial_obj.coefficients[j];
	    			   Polynomial_obj.exponents[j]=-1;
	    		 }
	    		 
	    	 }
		 }
		 int new_len = count_length(Polynomial_obj);
		 fin_expo=new int [new_len];
		 fin_pol=new double[new_len];
		 int count3=0;
		 int count4=0;
		 for ( int i=0; i<Polynomial_obj.coefficients.length;i++) 
		 {
	    	   if ( Polynomial_obj.exponents[i]!=-1) 
	    	   {
	    		   fin_pol[count3++]=Polynomial_obj.coefficients[i];
	    		   fin_expo[count4++]=Polynomial_obj.exponents[i];
	    	   }
	       }
		 Polynomial nozeroo = remove_zero(new Polynomial(fin_pol,fin_expo));
		 
		 return  nozeroo;
 }
  public double evaluate (double x) {
		double eval_sum=0;
		for ( int i=0;i< this.coefficients.length;i++)
		{
			eval_sum = eval_sum+coefficients[i]*Math.pow(x, this.exponents[i]);
		}
		return eval_sum;
		
	}
	public boolean hasRoot (double val) {
		if ( evaluate(val)==0)
		{
		    return true;
		}
		return false;
		
	}
	public int  count_white_spaces(String [] str) {
		int count_Space=0;
		for ( int i=0; i<str.length;i++)
		{
			if ( str[i].equals(""))
			{
				count_Space++;
			}
		}
		return count_Space;
		
	}
	public Polynomial(File file_name) throws FileNotFoundException 
	{
	  Scanner get_string= new Scanner(file_name);
	  double []coefficients_new ;
	  int [] exponents_new;
	  String line = get_string.nextLine();
	  String new_string=line.replaceAll("-","+-");
	  String [] split_the_string=new_string.split("[+]");
	  int count=count_white_spaces(split_the_string);
	  coefficients_new=new double[split_the_string.length-count];
	  exponents_new=new int [split_the_string.length-count];
	  this.exponents=new int[exponents_new.length];
	  this.coefficients=new double[coefficients_new.length];
	  int ind1=0;
	  int ind2=0;
	  for ( int i=0;i<split_the_string.length;i++)
	  {
		  if ( !split_the_string[i].equals("")) 
		  {
			  if (split_the_string[i].contains("x")== true)
			  {
	
				    if ( !split_the_string[i].contains("-x"))
					  { 
				    	 if( split_the_string[i].length()==2)
						  {
				    		 int index = split_the_string[i].indexOf("x");
				    		 String [] splx = split_the_string[i].split("x");
								 //String [] split_smallx = split_the_string[i].split("x");
								if ( index == 0) {
								
									exponents_new[ind2++]=Integer.parseInt(splx[1]);
								 }
				    	        else 
				    	        {
				    	        	coefficients_new[ind1++]=Double.parseDouble(splx[0]);
				    	        }
				    	        	
						  }
				    	  String [] split_smallx = split_the_string[i].split("x");
				    	  coefficients_new[ind1++]=Double.parseDouble(split_smallx[0]);
						  exponents_new[ind2++]=Integer.parseInt(split_smallx[1]);
					  }
						 
						  
			       if ( split_the_string[i].contains("-x"))
				        { 
						  
				    	 if (split_the_string[i].length()==3)
						  {
					    	  String [] split_smallx = split_the_string[i].split("-x");
							  coefficients_new[ind1++] = -1.0;
							  exponents_new[ind2++]=Integer.parseInt(split_smallx[1]);
						  }
						  if( split_the_string[i].length()==2)
						  {
							  coefficients_new[ind1++] = -1.0;
							  exponents_new[ind2++]=1;
						  }
				}
				}
				if ( !split_the_string[i].contains("x"))
				{
					  coefficients_new[ind1++]=Double.parseDouble( split_the_string[i]);
					  exponents_new[ind2++]=0;
				}
		  }
		   else 
			  {
				  continue;
			  }
	}
	 

		  
		 
	 for ( int i=0; i<coefficients_new.length;i++)
	  {
		this.coefficients[i]=coefficients_new[i];
		this.exponents[i]=exponents_new[i];
	  }
		  
	 get_string.close();
	}


	
	
	public void SavetoFile (String file_name) throws FileNotFoundException
	{
		
		PrintStream the_file= new PrintStream (file_name);
		for ( int i=0; i<this.coefficients.length;i++) {
			if (i==0)
			{
				if ( this.exponents[i]==0)
				{
					the_file.print(String.valueOf(coefficients[i]));
				}
				else if ( this.exponents[i]==1) {
					the_file.print(String.valueOf(coefficients[i])+'x');
				 }
				else if ( this.exponents[i]!=0)
				{
					the_file.print(String.valueOf(coefficients[i])+'x'+String.valueOf(exponents[i]));
				}
			}
			if ( i!=0 && coefficients[i]>0)
			{
				if (this.exponents[i]==0)
				{
						the_file.print('+'+String.valueOf(coefficients[i]));
				}
				else if ( this.exponents[i]==1) 
				{
					the_file.print('+'+String.valueOf(coefficients[i])+'x'+'1');
				}
				else if (this.exponents[i]!=0)
				{
					the_file.print('+'+String.valueOf(coefficients[i])+'x'+String.valueOf(exponents[i]));
				}
			}
			if ( i!=0 && coefficients[i]<0)
			{
				if ( this.exponents[i]==0)
				{
					the_file.print(String.valueOf(coefficients[i]));
				}
				else if ( this.exponents[i]==1) 
				{
					the_file.print(String.valueOf(coefficients[i])+'x'+'1');
				}
				else if ( this.exponents[i]!=0)
				{
					the_file.print(String.valueOf(coefficients[i])+'x'+String.valueOf(exponents[i]));
				}
			}
		}
			
			the_file.close();
		
	}
	}
