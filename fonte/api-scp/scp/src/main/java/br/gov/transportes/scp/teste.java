package br.gov.transportes.scp;

public class teste {
	
	  static int Max(int a, int b)
	  {
	    double parte1 = (float)(a + b) / 2.0;
	    float parte2 = (((float)(a - b) / 2)*((float)(a - b) / 2))/((float)(a - b) / 2);
	    
	    return (int) (parte1 + parte2);
	  }
	  
	  static int getmaximo(int a, int b) {
		    return (a + b) / 2 + Math.abs(a - b) / 2;
		  }
		  
	public static void main(String[] args) {
		
		System.out.println(getmaximo(888,777));
		
	}
}
