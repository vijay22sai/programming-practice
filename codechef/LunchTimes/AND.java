import java.util.*;
import java.io.*;
import java.math.*;

class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long []a = new long[31];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            String binStr = Integer.toBinaryString(num);
            char[] ar = binStr.toCharArray();
            int len = ar.length;
            for(int j=0; j<len; j++){
                if(ar[j]-'0' > 0){
                    a[len-j-1] += 1;
                }      
            }
        }

        BigInteger total = BigInteger.ZERO;
        BigInteger power = new BigInteger("2");
        BigInteger sum = BigInteger.ZERO;
        for(int i=0; i<31; i++){
            long k = a[i];
            sum = power.pow(i);
            sum = sum.multiply(BigInteger.valueOf((k*(k-1))/2));
            total = total.add(sum);
        }
        System.out.println(total.toString());
    }
}
