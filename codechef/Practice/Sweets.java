import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int total = 0;
        int mod = 0;
        int flag = 0;
        int []notes;
        for(int i=0; i<k; i++){
            total = 0;
            mod = 0;
            flag = 0;
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            //int c =0;
            notes = new int[n];
            int c = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                notes[j] = Integer.parseInt(st.nextToken());
                total += notes[j];
            }
            mod = total%c;
            for(int j=0; j<n; j++){
                if(notes[j] <= mod){
                    System.out.println("-1");
                    flag = 1;
                    break;
                }
            }
            if(flag==0)System.out.println(total/c);
        }
    }
}
