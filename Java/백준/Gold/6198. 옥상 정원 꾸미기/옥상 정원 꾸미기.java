import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, height[], cnt[];
    static long ans;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    
	public static void main (String[] args) throws java.lang.Exception
	{
		N = Integer.parseInt(in.readLine());
		height = new int[N];
		cnt = new int[N];
		
		for(int i=0; i<N; i++){
		    height[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i=N-1; i>=0; i--){
    	    while(!dq.isEmpty() && dq.peekFirst()[0] < height[i]){
    	           dq.pollFirst();
    	       }
	       if(dq.isEmpty()){
		        cnt[i] = N - 1 - i;
		       
		    }
		    else{
		       cnt[i] = dq.peekFirst()[1] - i - 1;
		   }
		   dq.addFirst(new int[]{height[i], i});
		}
		
		for(int i=0; i<N; i++){
		    ans += cnt[i];
		}

	    System.out.println(ans);

	}
}
