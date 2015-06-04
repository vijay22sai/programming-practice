import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int x1,y1,x2,y2,x3,y3;
        int count = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());
            y3 = Integer.parseInt(st.nextToken());
            if(calc(x1,y1,x2,y2,x3,y3)){
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean calc(int x1,int y1,int x2,int y2,int x3,int y3){
        int a = (y2-y1)*(y2-y1) + (x2-x1)*(x2-x1);
        int b = (y3-y1)*(y3-y1) + (x3-x1)*(x3-x1);
        int c = (y2-y3)*(y2-y3) + (x2-x3)*(x2-x3);
        if(a==0 || b==0 || c==0){return false;}
        int []edges = {a,b,c};
        Arrays.sort(edges);
        int max = edges[2];
        if(max == (edges[0] + edges[1]))
            return true;
        return false;
    } 
}
