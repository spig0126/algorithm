import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, leftSum;
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] isPrime;

    static void findPrimes(){
        isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = isPrime[1] = false;

		for(int i=2; i<isPrime.length; i++){
		    if(!isPrime[i])
		        continue;
		        
		    primes.add(i);
		    int temp = i << 1;
		    while(temp < isPrime.length){
		        isPrime[temp] = false;
		        temp += i;
		    }
		}
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		N = Integer.parseInt(in.readLine());
		
		findPrimes();

		if(N < 8){
		    System.out.println(-1);
		    return;
		}
		else if(N % 2 == 1){
		    System.out.print("2 3 ");
		    leftSum = N - 5;
		} else {
		    System.out.print("2 2 ");
		    leftSum = N - 4;
		}
		
	    for(int prime: primes){
	        if(isPrime[leftSum - prime]){
	            System.out.println(prime + " " + (leftSum - prime));
	            return;
	        }
	    }
	}
        

}
