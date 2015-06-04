import java.util.*;
import java.io.*;

class Test{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int []ar = null;
        int []count;
        int n;
        StringTokenizer st = null;
        int maxCount;
        int ind;
        for(int i=0; i<t; i++){
            count = new int[10001];
            maxCount = 0;
            ind = 0;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            ar = new int[n];
            for(int j=0; j<n; j++){
                ar[j] = Integer.parseInt(st.nextToken());
                count[ar[j]]++;
            }
            for(int j=1; j<10001; j++){
                if(maxCount < count[j]){
                    maxCount = count[j];
                    ind = j;
                }
            }
            System.out.println(ind + " "+maxCount);
        }
    }
}
