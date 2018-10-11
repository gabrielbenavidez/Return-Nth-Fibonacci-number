/************************************************** 

Purpose/ Description: A program to return the nth fibonacci number by implementing sublinear time

**************************************************/






import java.math.BigInteger;
import java.util.Scanner;
public class Problem3
{
     static BigInteger array[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
     static int input;
    
  
    public static void fibonacci(BigInteger [][]arr, int number)
    {
        
        if (number == 0)
        {
            System.out.println("Fib = 0");
        }
        
        // sends array to method to multiply tables and keep dividing number in half
         else
        {
            inHalf(arr, number -1);
        
            //returns upper left position which is n fib result
            System.out.println("fib(" + number + ") = "+ arr[0][0]);
        }
    }
    
    
    public static void inHalf(BigInteger[][] arr, int n)
    {
       
        // if n is 1 or 0 get out of method
        if (n == 1 || n == 0)
        {
            
            return; 
        }
         
        //creates original table of f(1) and f(0)
         BigInteger originalTable [][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        
        //calls recursive method to divide number in half 
        inHalf(arr,(n/2));
      
        
       
        // calls method multiplies table times itself
        multiplyTables(arr,arr);
        
        //if the number is odd (not a power of 2) multiply table times original
        if(n % 2 != 0)
        {
            multiplyTables(arr, originalTable);
           
        }
     
    }
     
    //array is sent to this method to be multiplied n times
    public static void multiplyTables(BigInteger [][]arr, BigInteger [][]arr2)
    {
           
        BigInteger a;
        BigInteger b;
        BigInteger c;
        BigInteger d;
       
        
       
        a = (arr[0][0].multiply(arr2[0][0])).add(arr[0][1].multiply(arr2[1][0]));
        b = (arr[0][0].multiply(arr2[0][1])).add(arr[0][1].multiply(arr2[1][1]));
        c = (arr[1][0].multiply(arr2[0][0])).add(arr[1][1].multiply(arr2[1][0]));
        d = (arr[1][0].multiply(arr2[0][1])).add(arr[1][1].multiply(arr2[1][1]));
        
            
        arr[0][0] =a;
        arr[0][1] =b;
        arr[1][0] =c;
        arr[1][1] =d;
        

       
    }
        
    
    public static void main(String[] args) 
    {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a number: ");
      input = in.nextInt();
      
      fibonacci(array, input);  
    }

}

