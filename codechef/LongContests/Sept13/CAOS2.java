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
        genPrimes();
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
                    if(in[j][k]){
                        int minimum = min(new int[]{l[j][k],r[j][k],t[j][k],d[j][k]});
                        int noOfPrimes = primeCount[minimum]  ;//countPrimes(minimum);
                        count += noOfPrimes;
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
    public static boolean[]isprime = new boolean[500];
    public static int[]primeCount = new int[500];
    public static void genPrimes(){
       isprime[0]=false; 
       isprime[1]=false; 
       isprime[2]=true;
       isprime[3]=true;
       isprime[4]=false;
       isprime[5]=true;
       int flag = 0;
       for(int i=6; i<500; i++){
           flag = 0;
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    isprime[i] = false;
                    flag = 0;
                    break;
                }
                else{
                    flag = 1;
                }
            }
            if(flag==1){
                isprime[i] = true;
            }       
       }
       for(int i=1; i<500; i++){
            if(isprime[i]){
                primeCount[i] = primeCount[i-1] + 1;
            }
            else{
                primeCount[i] = primeCount[i-1];
            }
       }
        
    }
}
