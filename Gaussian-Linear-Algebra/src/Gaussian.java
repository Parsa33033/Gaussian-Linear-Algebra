
public class Gaussian 
{
  //field
	private static final int N = 4;
  //methods
	public static void main(String[] args)
	{
		double[][] a = {{4,1,4,6},{6,5,3,6},{1,3,5,8},{3,5,6,2}};
		double[] b = {5,2,1,1};
		double[] x = new double[N];
		linearAlgebra(a,b,x,N);
	}//main method
	
	public static void linearAlgebra(double[][] a , double[] b , double[] x , int n)
	{
	    for(int j = 0 ; j<n ; j++)
	    {
	        for(int i = 0 ; i<n ; i++)
	        {
	            if(j<i)//lower triangle of A matrix
	            {
	                double factor = 1 ;
	                int k=i-1;
	                while(k>=0)//find the Gaussian factor from the upper rows of the current row
	                {
	                    if(k==i)continue;
	                    if(a[k][j]!=0)//if the upper rows same column is not zero
	                    {
	                        factor = (double)(-a[i][j])/a[k][j];
	                        break;
	                    }//if
	                    k--;
	                }//while checking the upper rows of the current row to find the Gaussian factor

	                for(int m = 0 ; m<n ; m++)
	                {
	                    a[i][m] += factor*a[k][m];// Gaussian factor
	                }//for
	                b[i] += factor*b[k];//do the same thing that we did with A to B
	            }//if j<i

	        }//i

	    }//j

	    for(int i=n-1 ; i>=0 ;i--)
	    {
	        //for example if we have 2*x2 + 3*x3 = b2 we already found x3 the rest is history :)
	        double sum = 0 ;
	        for(int j = i+1 ; j<n ; j++)
	        {
	            sum += a[i][j]*x[j];
	        }//j
	        x[i] = (b[i]-sum)/a[i][i];//calculate x_i --> for example the first loop will find x_n
	    }//i



	    //output the linear Algebra
	    System.out.print("A's matrix after Gaussian:");
	    System.out.println();
	    for(int row = 0 ; row<n ; row++)
	    {
	        for(int col = 0 ; col<n ; col++)
	        {
	            System.out.print(a[row][col]+ " ");
	        }
	        System.out.println();
	    }//i
	    System.out.println();
	    System.out.print("B's matrix after Gaussian:");
	    for(int col = 0 ; col<n ; col++)
	    {
	        System.out.println(b[col]);
	    }//for
	    System.out.println();
	    System.out.print("x's vector is:");
	    for(int col = 0 ; col<n ; col++)
	    {
	        System.out.println(x[col]);
	    }//for

	}//linearAlgebra method
}//Gaussian class
