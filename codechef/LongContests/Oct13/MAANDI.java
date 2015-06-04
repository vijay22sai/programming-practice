import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            System.out.println(count(Integer.parseInt(br.readLine())));
        }
    }
    public static int count(int n){
        int c = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                Integer in = i;
                if(in.toString().contains("4") || in.toString().contains("7")){
                    c++;
                }
                in = n/i;
                if(in.toString().contains("4") || in.toString().contains("7")){
                    c++;
                }
            }
        }
        return c;
    }
}
