import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  
  static int N, Q, apple[][];
  static TreeMap<Integer, Integer> dp = new TreeMap<>();
  static TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
  
  static void readLine() throws Exception{
    st = new StringTokenizer(in.readLine());
  }
  
  static int read() throws Exception{
    return Integer.parseInt(st.nextToken());
  }
  
  static void input() throws Exception{
    readLine();
    N = read();
    Q = read();
    apple = new int[N][2];
    
    readLine();
    for(int n=0; n<N; n++){
      apple[n][0] = read();
      map.put(apple[n][0], new TreeMap<>());
    }
    
    readLine();
    for(int n=0; n<N; n++){
      apple[n][1] = read();
      TreeMap<Integer, Integer> tMap = map.get(apple[n][0]);
      
      if(tMap.containsKey(apple[n][1])){
        tMap.put(apple[n][1], tMap.get(apple[n][1]) + 1);
      }
      else{
        tMap.put(apple[n][1], 1);
      }
    }
  }
  
  static void calDp(){
    Integer t = map.lastKey();
    int maxVal = 0, cnt = 0;
    
    while(t != null){
      TreeMap<Integer, Integer> cntMap = map.get(t);
      int temp = cntMap.lastKey();
      if(temp == maxVal){
        cnt += cntMap.get(maxVal);
      }
      else if(maxVal < temp){
        maxVal = temp;
        cnt = cntMap.get(maxVal);
      }
      
      dp.put(t, cnt);
      t = map.lowerKey(t);
    }
  }
  
  
  static void solution() throws Exception {
    calDp();
    
    for(int q=0; q<Q; q++){
      int cnt = 0, maxVal = 0;
      int p = Integer.parseInt(in.readLine());
      
      if(dp.containsKey(p)){
        sb.append(dp.get(p) + "\n");
      }
      else{
        Integer temp = dp.higherKey(p);
        if(temp == null)
          sb.append("0\n");
        else
          sb.append(dp.get(dp.higherKey(p)) + "\n");
      }
    }
    
    System.out.println(sb);
  }
  
	public static void main (String[] args) throws java.lang.Exception
	{
		input();
		solution();

	}
}
