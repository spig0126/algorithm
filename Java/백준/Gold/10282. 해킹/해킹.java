import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int T, N, D, C;
    static int visited[];
    static ArrayList<int[]>[] edge;
    static HashSet<Integer> infected;
    
    static void input() throws IOException{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        edge = new ArrayList[N + 1];
        visited = new int[N + 1];
        infected = new HashSet<>();
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for(int d=0; d<D; d++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            if(edge[b] == null)
                edge[b] = new ArrayList<>();
            edge[b].add(new int[]{a, s});
        }
    }
    
    static void bfs(){
        int infectCnt = 0, maxTime = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(C, 0));
        infected.add(C);
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
   
            if(edge[node.computer]== null)
                continue;
            for(int[] next: edge[node.computer]){
                int nextComputer = next[0];
                int nextTime = next[1] + node.time;
                if(visited[nextComputer] <= nextTime)
                    continue;
                visited[nextComputer] = nextTime;
                infected.add(nextComputer);
                pq.add(new Node(nextComputer, nextTime));
            }
        }
        for(int i=0; i<N + 1; i++){
            if(visited[i] != Integer.MAX_VALUE)
                maxTime = Math.max(maxTime, visited[i]);
        }
        sb.append(infected.size() + " " + maxTime + "\n");
        
    }

    static class Node implements Comparable<Node>{
        int computer;
        int time;
        
        Node(int computer, int time){
            this.computer = computer;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node node){
            return this.time - node.time;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    T = Integer.parseInt(in.readLine());
	    for(int t=0; t<T; t++){
	        input();
	        bfs();
	    }
		System.out.println(sb);
	}
}

