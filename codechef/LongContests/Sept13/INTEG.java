import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long []a = new long[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        long x = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        
        int index = 0;
        for(int i=0; i<n; i++){
            if(a[i]>=0){
                index = i;
                break;
            }
            else{
                index = i+1;
            }
        }
        if(index==0 || x==0){
            System.out.println(0);
            return;
        }
        //~ System.out.println(index);
        long cost = 0;
        long sum = 0;
        while(index>x && index>1){
            cost += x*(0-(sum+a[index-1]));
            sum = (0-a[index-1]);
            index--;
        }
        for(int i=0; i<index; i++){
            cost += (0-(sum+a[i]));
        }
        
        System.out.println(cost);
    }
}
