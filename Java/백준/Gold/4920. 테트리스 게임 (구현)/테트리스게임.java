import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  
  static int maxVal;
  static int N, graph[][];
  static int[][][] dx = {
    // 1
    {
      {0, 0, 0, 0}, {0, 1, 2, 3}
    },
    {
      {0 ,1, 2, 3}, {0, 0, 0, 0}
    },
    {
      {0, 0, 0, 0}, {0, -1, -2, -3}
    }, 
    {
      {0, -1, -2, -3}, {0, 0, 0, 0}
    },
    // 2
    {
      {0, 0, 1, 1}, {0, 1, 1, 2}
    }, 
    {
      {0, 1, 1, 2}, {0, 0, -1, -1}
    },
    {
      {0, 0, -1, -1}, {0, -1, -1, -2}
    }, 
    {
      {0, -1, -1, -2}, {0, 0, 1, 1}
    },
    // 3
    {
      {0, 0, 0, 1}, {0, 1, 2, 2}
    }, 
    {
      {0, 1, 2, 2}, {0, 0, 0 , -1}
    }, 
    {
      {0, 0, 0, -1}, {0, -1, -2, -2}
    },
    {
      {0, -1, -2, -2}, {0, 0, 0, 1}
    }, 
    // 4
    {
      {0, 0, 0, 1}, {0, 1, 2, 1}
    },
    {
      {0, 1, 2, 1}, {0, 0, 0, -1}
    }, 
    {
      {0, 0, 0, -1}, {0, -1, -2, -1}
    },
    {
      {0, -1, -2, -1}, {0, 0, 0, 1}
    }, 
    // 5
    {
      {0, 0, 1, 1}, {0, 1, 0, 1}
    }
  };
  
  static void readLine() throws Exception {
    st = new StringTokenizer(in.readLine());
  }
  
  static int read() throws Exception {
    return Integer.parseInt(st.nextToken());
  }
  
  static void input() throws Exception {
    int t = 1;
    
    while(true){
      readLine();
      N = read();
      
      if(N == 0)
        return;
      
      maxVal = Integer.MIN_VALUE;
      graph = new int[N][N];
      
      for(int r=0; r<N; r++){
        readLine();
        for(int c=0; c<N; c++){
          graph[r][c] = read();
        }
      }
      
      solution();
      
      sb.append(String.format("%d. %d\n", t, maxVal));
      
      t++;
    }
  }
  
  static int calMaxSumOf(int r, int c) {
    int maxSum = Integer.MIN_VALUE;
    
    loop: for(int i=0; i<dx.length; i++){
      int sum = 0;
      for(int j=0; j<4; j++){
        int nr = r + dx[i][0][j];
        int nc = c + dx[i][1][j];
        
        if(nr < 0 || nr >= N || nc < 0 || nc >= N)
          continue loop;

        sum += graph[nr][nc];
      }
      
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
  
  static void solution() {
    for(int r=0; r<N; r++){
      for(int c=0; c<N; c++){
        maxVal = Math.max(maxVal, calMaxSumOf(r, c));
      }
    }
  }
  
	public static void main (String[] args) throws java.lang.Exception
	{
	 // System.out.println(248863  + 742357 + 305111  + 379263  );
		input();
		System.out.println(sb);

	}
}
// 4, 8, 8, 8, 8 * 10000
