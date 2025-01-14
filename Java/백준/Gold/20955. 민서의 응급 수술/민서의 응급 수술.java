import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  
  static int N, M, cnt, parent[];
  static boolean visited[];
  
  static void input() throws Exception{
    st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    parent = new int[N+1];
    visited = new boolean[N+1];
    
    for(int i=0; i<N+1; i++){
      parent[i] = i;
    }
    
    for(int m=0; m<M; m++){
      st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      a = root(a);
      b = root(b);
      if(a == b){
        cnt++;
      }
      else{
        union(a, b);
      }
      
    }
  }
  
  static int root(int x){
    int temp = parent[x];
    while(temp != parent[temp]){
      temp = parent[temp];
    }
    parent[x] = temp;
    return parent[x];
  }
  
  static void union(int a, int b){
    a = root(a);
    b = root(b);
    
    if(a != b){
      if(a < b)
        parent[b] = a;
      else
        parent[a] = b;
    }
  }
  
  static void solution(){
    
    // find all trees
    HashSet<Integer> treeRoots = new HashSet<>();
    for(int i=1; i<N+1; i++){
      treeRoots.add(root(i));
    }
    
    cnt += treeRoots.size() - 1;
  }
  
	public static void main (String[] args) throws java.lang.Exception
	{
	  input();
	  solution();
		System.out.println(cnt);
	}
}
