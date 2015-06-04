import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int k = Integer.parseInt(br.readLine());
        int []arr = new int[1000001];
        int n;
        String s = "";
        for(int i=0; i<k; i++){
            n = Integer.parseInt(br.readLine());
            arr[n] += 1;
        }
        for(int i=0; i<=1000000; i++){
            int num = arr[i];
            if(num>0){
                for(int j=0; j<num; j++){
                    s = s +  i + "\n";
                }
            }
        }
        bos.write(s.getBytes());
        bos.flush();
    }
}
