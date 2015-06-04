import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double area = solve(br.readLine());
        double min = area;
        double max = area;
        int minInd = 1;
        int maxInd = 1;
        for(int i=2; i<=n; i++){
             area = solve(br.readLine());
            if(area<=min){
                min = area;
                minInd = i;
            }
            if(area>=max){
                max = area;
                maxInd = i;
            }
        }
        System.out.println(minInd + " " +maxInd);
    }
    public static double solve(String input){
        StringTokenizer st = new StringTokenizer(input);
        int x[] = new int[3];
        int y[] = new int[3];
        for(int i=0; i<3; i++){
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        double a,b,c;
        a = Math.sqrt((x[1]-x[0])*(x[1]-x[0])+(y[1]-y[0])*(y[1]-y[0]));
        b = Math.sqrt((x[2]-x[1])*(x[2]-x[1])+(y[2]-y[1])*(y[2]-y[1]));
        c = Math.sqrt((x[0]-x[2])*(x[0]-x[2])+(y[0]-y[2])*(y[0]-y[2]));
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
