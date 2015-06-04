import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        
        init();
        int t = Integer.parseInt(br.readLine());
        int L;
        int U;
        
        nums[0] = false;
        nums[1] = false;
        for(int i=0; i<t; i++){
            L = Integer.parseInt(br.readLine());
            U = Integer.parseInt(br.readLine());
            bos.write((calc(L,U)+"\n").getBytes());
        }
        bos.flush();
    }
    
    public static boolean[] isprime = new boolean[40];
    public static boolean [] nums = new boolean[10001];
    
    public static int calc(int L, int U){
        int count =0;
        for(int i=L; i<=U; i++){
            if(nums[i]){
                count++;
            }
        }
        return count;
    }
    
    public static void init(){
        int temp = 0;
        isprime[0] = false;
        isprime[1] = false;
        isprime[2] = true;
        isprime[3] = true;
        for(int i=4; i<40; i++){
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    isprime[i] = false;
                    temp = 0;
                    break; 
                }
                temp = 1;
            }
            if(temp!=0){isprime[i] = true;}
        }
        for(int i=0; i<=10000; i++){
            if(isprime[sum(i)]){
                nums[i] = true;
            }
            else nums[i] = false;
        }
    }
    public static int sum(int n){
        int total = 0;
        while(n!=0){
            total += n%10;
            n = n/10;
        }
        return total;
    }    
}
