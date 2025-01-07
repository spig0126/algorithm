import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, K, W, time,duration;
    static Building[] buildings;
    static boolean[] visited;
    
    static void input() throws Exception{
        
    }
    static class Building implements Comparable<Building>{
        ArrayList<Building> nextBuildings = new ArrayList<>();
        int depth;
        int num;
        int startTime;
        int duration;
        
        Building(int num, int duration){
            this.num = num;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Building b){
            return this.depth - b.depth;
        }
        
        @Override
        public String toString(){
            return "[" + num + ": depth = " + depth + " , startTime = " + startTime + ", duration=" + duration + "]";
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0){
		    st = new StringTokenizer(in.readLine());
		    N = Integer.parseInt(st.nextToken());
		    K = Integer.parseInt(st.nextToken());
		    
		    visited = new boolean[N + 1];
		    buildings = new Building[N + 1];
		    
		    st = new StringTokenizer(in.readLine());
		    for(int i=1; i<=N; i++){
		        buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
		    }
		    
		    for(int k=0; k<K; k++){
		        st = new StringTokenizer(in.readLine());
		        int x = Integer.parseInt(st.nextToken());
		        int y = Integer.parseInt(st.nextToken());
		        buildings[x].nextBuildings.add(buildings[y]);
		        buildings[y].depth++;
		        
		    }

		    W = Integer.parseInt(in.readLine());
		    
		    PriorityQueue<Building> pq = new PriorityQueue<>();
		    		    
		    for(Building building: buildings){
		        if(building != null && building.depth == 0){
		            pq.add(building);
		            visited[building.num] = true;
		        }
		            
		    }
		    
		    whileLoop: while(!pq.isEmpty()){
		        Building building = pq.poll();
		        
		        if(building.depth != 0){
		            pq.add(building);
		            continue;
		        }
		        
		        for(Building nextBuilding: building.nextBuildings){
		            nextBuilding.depth--;
		            nextBuilding.startTime = Math.max(building.startTime + building.duration, nextBuilding.startTime);
		            if(nextBuilding.depth == 0){
		                if(nextBuilding.num == W){
		                    break whileLoop;
		                }
		                    
		                pq.add(nextBuilding);
		            }
		        }
		    }
		    
		    System.out.println(buildings[W].startTime + buildings[W].duration);
		}

	}
}
