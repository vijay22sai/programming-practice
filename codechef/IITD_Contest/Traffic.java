import java.util.*;
import java.io.*;

class Main{
    
    public static int[]stoppageTimes = new int[15];
    public static int[][] dist = new int[15][15];
    
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        init();
        for(int j=0; j<t; j++){
            init();
            for(int i=0; i<15; i++){
                stoppageTimes[i] = Integer.parseInt(br.readLine());
            }
            for(int i=0; i<26; i++){
                st = new StringTokenizer(br.readLine());
                int fNode = st.nextToken().charAt(0) - 'A';
                int lNode = st.nextToken().charAt(0) - 'A';
                int distance = Integer.parseInt(st.nextToken());
                dist[fNode][lNode] = distance;
                dist[lNode][fNode] = distance;
            }
            int source      = br.readLine().charAt(0) - 'A';
            int destination = br.readLine().charAt(0) - 'A';
            
            System.out.println(minDist(source,destination));
        }
    }
    public static void init(){
        for(int i=0; i<15; i++){
            visited[i]=false;
            stoppageTimes[i] = 1000000;
            distuptohere[i] = 0;
            for(int j=0; j<15; j++){
                dist[i][j] = 1000000;
            }
        }
    }
    public static boolean[] visited = new boolean[15];
    public static int[] distuptohere = new int[15];
    
    public static int minDist(int source, int destination){
        int totalMinDistance = stoppageTimes[source];
        visited[source] = true;
        int min = Integer.MAX_VALUE;
        int node = 0;
        while(!visited[destination]){
            min = Integer.MAX_VALUE;
            for(int i=0; i<15; i++){
                if(visited[i]){
                    for(int j = 0; j<15; j++){
                        if(!visited[j] && (stoppageTimes[j]+dist[i][j]+distuptohere[i]) < min){
                            min = stoppageTimes[j]+dist[i][j]+distuptohere[i];
                            node = j;
                        }
                    }
                }
            }
            distuptohere[node] = min;
            visited[node] = true;
        }
        return stoppageTimes[source] + distuptohere[node] - stoppageTimes[node];
    }
}

