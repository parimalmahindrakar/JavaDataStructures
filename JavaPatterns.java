package javapatterns;

public class JavaPatterns {
	
	public static void Pattern1(int rows) {
		/*
		 		1 
				1 2 
				1 2 3 
				1 2 3 4 
				1 2 3 4 5 
		*/
		for (int i = 0; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void Pattern2(int rows) {
		/*
			 	1 
				2 2 
				3 3 3 
				4 4 4 4 
				5 5 5 5 5 	
		*/
		for (int i = 0; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void Pattern3(int rows) {
		/*		
				1 
				1 2 
				1 2 3 
				1 2 3 4 
				1 2 3 4 5 
				1 2 3 4 
				1 2 3 
				1 2 
				1 
		*/
		for(int i = 0;i <= rows; i++ ) {
			for(int j = 1;j <= i; j++ ) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for(int i = rows;i > 0; i-- ) {
			for(int j = 1;j < i; j++ ) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	

	public static void Pattern4(int rows) {
		/*
		 		1 2 3 4 5 
				1 2 3 4 
				1 2 3 
				1 2 
				1 
				1 
				1 2 
				1 2 3 
				1 2 3 4 
				1 2 3 4 5 
		*/
		for(int i = rows; i > 0; i--) {
			for(int j = 1;j <= i ;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for(int i = 0; i <= rows; i++) {
			for(int j = 1;j <= i ;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void Pattern5(int rows) {
		/*
		 		5 4 3 2 1 
				4 3 2 1 
				3 2 1 
				2 1 
				1 
				1 
				2 1 
				3 2 1 
				4 3 2 1 
				5 4 3 2 1  
		*/
		
		for(int i = rows; i > 0; i--) {
			for(int j = i;j >0 ;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for(int i = 0; i <= rows; i++) {
			for(int j = i;j >0 ;j--)  {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
	}
	public static void Pattern6 (int rows) {
		/*          1 
			   1 2 
			  1 2 3 
			 1 2 3 4 
			1 2 3 4 5 
		*/
					
		for(int i = 1;i <= rows; i++) {
			for(int j = rows; j > i ; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print(k+" ");
			}
			System.out.println();
			
		}
		
	}
	
	
	public static void Pattern7(int rows) {
		/*	5 4 3 2 1 
			5 4 3 2 
			5 4 3 
			5 4 
			5 
		*/
		for(int i = 1; i <= rows; i++  ) {
			for(int j = rows;j>=i;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern8(int rows) {
		/*	5 
			5 4 
			5 4 3 
			5 4 3 2 
			5 4 3 2 1 
		*/
		for(int i = rows; i > 0; i--  ) {
			for(int j = rows;j>=i;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern9(int rows) {
		/*
		  		1 2 3 4 5 
				1 2 3 4 
				1 2 3 
				1 2 
				1 
		*/
		for(int i = rows ; i> 0; i--) {
			for(int j = 1; j <= i ; j++) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
	}
	
	
	public static void Pattern10(int rows) {
		/*		1 
				2 3 
				4 5 6 
				7 8 9 10 
				11 12 13 14 15 
		*/
		int k = 1;
		for(int i = 1; i <= rows; i++ ) {
			for(int j = 1; j<=i ; j++) {
				System.out.print(k+" ");
				k++;
			}
			System.out.println();
		}
	}
	
	public static void Pattern11(int rows) {
		/*	1	 
			2 1 
			3 2 1 
			4 3 2 1 
			5 4 3 2 1 
		*/
		for(int i= 1 ; i<=rows;i++) {
			for(int j = i;j>=1;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern12(int rows) {
		/*	1 
			2 7 
			3 8 13 
			4 9 14 19 
			5 10 15 20 25
		 */
		
		for(int i= 1;i<=rows;i++) {
			int k = i;
			for(int j = 1;j<=i;j++) {
				System.out.print(k+" ");
				k+=rows;
			}
			System.out.println();
		}
	}
	
	public static void Pattern13(int rows) {
		/*   	    1 
			   1 1     => VIMP 
			  1 2 1 
			 1 3 3 1 
			1 4 6 4 1
		*/
		for(int i = 1; i <= rows; i++  ) {
			for(int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			int temp =1 ;
			for(int k = 1 ; k <= i; k++ ) {
				System.out.print(temp+" ");
				temp = temp *(i-k)/k;
			}
			System.out.println();
		}
	}
	public static void Pattern14(int rows) {
		/*
		  	1 
			1 2 1 
			1 2 3 2 1 
			1 2 3 4 3 2 1 
			1 2 3 4 5 4 3 2 1
		*/
		for(int i = 1 ; i <= rows; i++) {
			for(int j = 1;j <= i;j++) {
				System.out.print(j+" ");
			}
			for(int k = i-1;k>= 1 ; k--) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern15(int rows) {
		/*	1 2 3 4 5 
			 1 2 3 4 
			  1 2 3 
			   1 2 
			    1
		*/
		for(int i = 1; i <= rows; i++) {
			for(int j = 1 ; j < i ; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= rows-i+1 ;k++) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern16(int rows) {
		/*           1 
			    1 2 
			   1 2 3 
			  1 2 3 4 
			 1 2 3 4 5 
			  1 2 3 4 
			   1 2 3 
			    1 2 
			     1 
		*/
		for(int i = 1; i <= rows; i++)  {
			for(int j = rows; j>= i;j--) {
				System.out.print(" ");
			}
			for (int k = 1 ; k <= i;k++ ) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		for(int i = rows-1; i >= 1; i--)  {
			for(int j = rows; j>= i;j--) {
				System.out.print(" ");
			}
			for (int k = 1 ; k <= i;k++ ) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void Pattern17(int rows) {
		/*		12345
				 2345
				  345
				   45
				    5
				    5
				   45
				  345
				 2345
				12345
		*/
		for(int i = 1; i<=rows;i++) {
			for(int k = 1;k < i;k++) {
				System.out.print(" ");
			}
			for(int j = i ;j <=rows;j++) {
				System.out.print(j);
			}
			
			System.out.println();
		}
		for(int i = rows; i>=1;i--) {
			for(int k = 1;k < i;k++) {
				System.out.print(" ");
			}
			for(int j = i ;j <= rows;j++) {
				System.out.print(j);
			}
			
			System.out.println();
		}
	}
	
	
	public static void Pattern18( int rows) {
		/*
		  	1 2 3 4 5 
			 2 3 4 5 
			  3 4 5 
			   4 5 
			    5 
			    5 
			   4 5 
			  3 4 5 
			 2 3 4 5 
			1 2 3 4 5 
		*/
		for(int i = 1; i <= rows ;i++) {
			for(int k = 1; k<i;k++) {
				System.out.print(" ");
			}
			for(int j = i; j <= rows ; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		 for (int i = rows; i >= 1; i--)
	        {
	            for (int j = 1; j < i; j++)
	            {
	                System.out.print(" ");
	            }

	            for (int k = i; k <= rows; k++)
	            {
	                System.out.print(k + " ");
	            }
	            System.out.println();
	        }
	}
	
	public static void Pattern19(int rows) {
		/*          5 
			   4 5 
			  3 4 5 
			 2 3 4 5 
			1 2 3 4 5
		*/
		for(int i = rows;i>=1;i--) {
			
			for(int j = 1;j<i;j++) {
				System.out.print(" ");
			}
			for(int k = i;k<=rows;k++) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern20(int rows) {
		/*
		    	    1
			   121
			  12321
			 1234321
			123454321
		 */
		for(int i = 1;i<=rows;i++) {
			for(int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 1 ; k <= i; k++ ) {
				System.out.print(k);
			}
			for(int l = i - 1 ;l >= 1; l--) {
				System.out.print(l);
			}
			System.out.println();
		}
	}
	
	public static void Pattern21(int rows) {
		/*	1 
			1 0 
			1 0 1 
			1 0 1 0 
			1 0 1 0 1 
		*/
		for(int i = 1; i <= rows; i++ ) {
			for(int j = 1; j <= i ; j++) {
				System.out.print(j%2 + " ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern22(int rows) {
		/*
		  	1 0 0 0 0 
			0 2 0 0 0 
			0 0 3 0 0 
			0 0 0 4 0 
			0 0 0 0 5 
		*/
		for(int i =  1; i <= rows; i++ ) {
			for(int j =1 ;j< i ;j++) {
				System.out.print("0 ");
			}
			System.out.print(i+" ");
			for(int k = i ; k< rows; k++) {
				System.out.print("0 ");
			}
			System.out.println();
		}
	}
	
	
	public static void Pattern23(int rows) {
		/*
		 	1 1 1 1 1 
			1 1 1 2 2 
			1 1 3 3 3 
			1 4 4 4 4 
			5 5 5 5 5 
		*/
		for(int i = 1; i <= rows ; i++) {
			for(int j = rows;j > i; j--) {
				System.out.print(1+" ");
			}
			for(int k = 1; k<= i;k++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern24(int rows) {
		/*
		  		1 2 3 4 5 4 3 2 1 
				2 3 4 5 4 3 2 
				3 4 5 4 3 
				4 5 4 
				5 
		*/
	
		for(int i = 1;i <= rows; i++) {
			for( int  j = i; j <= rows ; j++ ) {
				System.out.print(j+" ");
			}
			for( int  k = rows - 1; k >= i; k-- ) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void Pattern25(int rows) {
		
		/*
		      	    1 
			   2 2 
			  3 3 3 
			 4 4 4 4 
			5 5 5 5 5 
		*/
		
		for(int i = 1; i <= rows; i++ ) {
			for(int j = rows; j > i ; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k<=i; k++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static void  Pattern26(int rows) {
		
		/*
		 	5 5 5 5 5 
			4 5 5 5 5 
			3 4 5 5 5 
			2 3 4 5 5 
			1 2 3 4 5 
		 */
		
		
		for(int i = rows;i >= 1 ; i-- ) {
			for(int j = i; j< rows; j++) {
				System.out.print(j+ " ");
			}
			for(int k =rows-i;k<rows;k++ ) { 
				System.out.print(5+" ");
			}
			System.out.println();
		}
	}
	
	public static void Pattern27(int rows) {
		/*	1 
			2 6 
			3 7 10 
			4 8 11 13 
			5 9 12 14 15 
		*/
		for(int i = 1 ;i <= rows; i++) {
			int k  = i;
			for(int j = 1 ; j <= i; j++) {
				System.out.print(k+" ");
				k+=rows-j;
			}
			System.out.println();
		}
	}
	
	public static void Pattern28(int rows) {
		/* 
		  	1 
			2 4 
			3 6 9   ====> VIMP , need to be checked !
			4 8 
			5 
		*/
		int temp = 1;
        for(int i=1; i<=rows/2+1; i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(temp*j+" ");
            }
            System.out.println();
            temp++;
        }
        for(int i=1; i<=rows/2; i++)
        {
            for(int j=1;j<=rows/2+1-i;j++)
            {
                System.out.print(temp*j+" ");
            }
            System.out.println();
            temp++;
        }
	}
	
	
	public static void main(String[] args) {
		
	}



	
	
}
