import java.util.*;
import java.io.*;
import java.math.*;

class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int a[] = null;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            a = new int[n];
            for(int j=0; j<n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            bos.write((minimum(a,n)+"\n").getBytes());
        }
        bos.flush();
    }
    public static long minimum(int []a, int size){
        if(size==1){
            return a[0];
        }
        long min = a[0];
        long max = a[0];
        long ar[] = null;
        for(int i=1; i<size; i++){
            ar = new long[]{min*a[i],max*a[i],min-a[i],max-a[i],min+a[i],max+a[i]};
            Arrays.sort(ar);
            min = ar[0];
            max = ar[5];
        }
        return min;
    }
}
