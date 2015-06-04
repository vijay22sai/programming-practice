import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        int n;
        long sum;
        long n2;
        int j;
        for(int i =0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            sum = 0;
            for(j=1; j*j<=n; j++){
                sum += n/j;
            }
            j--;
            sum *= 2;
            sum -= j*j;
            
            n2 = (long)n*(long)n;
            bos.write((fraction(sum,n2)+"\n").getBytes());
        }
        bos.flush();
    }
    public static String fraction(long sum, long n2){
        long gcd = Gcd(n2,sum);
        long numerator = sum/gcd;
        long denominator = n2/gcd;
        return numerator+"/"+denominator;
    }
    public static long Gcd(long num1, long num2){
        if(num2==0){
            return num1;
        }
        return Gcd(num2,num1%num2);
    }
    
}
