import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, K, k, cnt;
    static LinkedList<Box> topBelt = new LinkedList<>(), belowBelt = new LinkedList<>();
    
    static void input() throws IOException{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++){
            Box box = new Box(Integer.parseInt(st.nextToken()), false);
            topBelt.addLast(box);
        }
        for(int i=0; i<N; i++){
            Box box = new Box(Integer.parseInt(st.nextToken()), false);
            belowBelt.addFirst(box);
        }
    }
    
    static void stepOne(){
        topBelt.addFirst(belowBelt.pollFirst());
        belowBelt.addLast(topBelt.pollLast());
        topBelt.peekLast().hasRobot = false;
    }
    
    static void stepTwo(){
        for(int i=0; i<N; i++){
            Box box = topBelt.pollLast();
            if(box.hasRobot){
                Box nextBox = topBelt.peekFirst();
                if(nextBox.strength > 0 && nextBox.hasRobot == false){
                    nextBox.strength--;
                    nextBox.hasRobot = true;
                    box.hasRobot = false;
                    if(nextBox.strength == 0)
                        k++;
                }
            }
            topBelt.addFirst(box);
        }
        topBelt.peekLast().hasRobot = false;
    }
    
    static void stepThree(){
        Box box = topBelt.peekFirst();
        if(box.strength > 0){
            box.strength--;
            box.hasRobot = true;
            if(box.strength == 0)
                        k++;
        }
    }
    
    static void runSteps(){
        while(k < K){
            stepOne();
            stepTwo();
            stepThree();
            cnt++;
        }
    }
    
    static class Box{
        int strength;
        boolean hasRobot;
        
        Box(int strength, boolean hasRobot){
            this.strength = strength;
            this.hasRobot = hasRobot;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		input();
		runSteps();
		System.out.println(cnt);
	}
}

