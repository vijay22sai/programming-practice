import java.util.*;
import java.io.*;

class Main{
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int row,col;
        int[][] t,l,r,d;
        boolean in[][];
        for(int i=0; i<tests; i++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            t = new int[row][col];
            l = new int[row][col];
            r = new int[row][col];
            d = new int[row][col];
            in = new boolean[row][col];
            for(int j=0; j<row; j++){
                String s = br.readLine();
                for(int k=0; k<col; k++){
                    if(s.charAt(k)=='#'){
                        in[j][k] = false;
                    }
                    else{
                        in[j][k] = true;
                    }
                }
            }
            for(int j=0; j<row; j++){
                l[j][0] = 0;
                r[j][col-1] = 0;
            }
            for(int j=0; j<col; j++){
                t[0][j] = 0;
                d[row-1][j] = 0;
            }
            
            for(int j=1; j<row; j++){
                for(int k=0; k<col; k++){
                    if(in[j-1][k]){
                        t[j][k] = t[j-1][k] + 1;
                    }
                    if(in[row-j][k]){
                        d[row-1-j][k] = d[row-j][k] + 1;
                    }
                }
            }
            for(int j=0; j<row; j++){
                for(int k=1; k<col; k++){
                    if(in[j][k-1]){
                        l[j][k] = l[j][k-1] + 1;
                    }
                    if(in[j][col-k]){
                        r[j][col-k-1] = r[j][col-k] + 1;
                    }
                }
            }
            int count = 0;            
            for(int j=0; j<row; j++){
                for(int k=0; k<col; k++){
                    if(in[j][k] && min(new int[]{l[j][k],r[j][k],t[j][k],d[j][k]}) >= 2){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static int min(int[] a){
        Arrays.sort(a);
        return a[0];
    }
}
