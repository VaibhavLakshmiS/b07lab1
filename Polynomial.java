public class Polynomial {
	double []coefficients;
	public Polynomial () 
       {
          coefficients=new double[1];
          //coefficients[0]=0;
		
	}
	public Polynomial (double [] set_coefficients) {
		coefficients = new double[set_coefficients.length];
		
		for ( int i=0;i<this.coefficients.length;i++)
		{
			coefficients[i]=set_coefficients[i];
		}
		
	}
	public Polynomial add (Polynomial pol) {
		 Polynomial Polynomial_obj= null;
		 double [] newarr;
		 double [] smaller;
		 double []bigger;
		 if (this.coefficients.length>pol.coefficients.length)
		 {
			 bigger = this.coefficients;
			 smaller = pol.coefficients;
		 }
		 else 
		 {
			 bigger = pol.coefficients;
			 smaller = this.coefficients;
		 }
		 newarr = new double[bigger.length];
		for ( int i=0 ; i< smaller.length;i++)
			 {
				 newarr[i]=bigger[i]+ smaller[i]; 
			 }
		for ( int i=(smaller.length) ; i<bigger.length;i++) 
			{
				 newarr[i]= bigger[i];
			}
			 Polynomial_obj= new Polynomial(newarr);
			 return Polynomial_obj; // return new Polynomial(newarr); will also work 
		 }
		 
	public double evaluate (double x) {
		double eval_sum=0;
		for ( int i=0;i< this.coefficients.length;i++)
		{
			eval_sum = eval_sum+coefficients[i]*Math.pow(x, i);
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


}
