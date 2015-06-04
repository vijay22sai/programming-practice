import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int k=0; k<t; k++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int []points = new int[N+1];
            int []time = new int[N+1];
            for(int j=1; j<=N; j++){
                st = new StringTokenizer(br.readLine());
                points[j] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
                time[j] = Integer.parseInt(st.nextToken());
            }
            //dp
            int dp[][] = new int[N+1][W+1];
            for(int i=0; i<W+1; i++){
                dp[0][i] = 0;
            }
            for(int i=0; i<N+1; i++){
                dp[i][0] = 0;
            }
            for(int i=1; i<N+1; i++){
                for(int j=1; j<W+1; j++){
                    if(time[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], points[i]+dp[i-1][j-time[i]]);
                    }
                }
            }
            System.out.println(dp[N][W]);
        }
    }
}
