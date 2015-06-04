import java.util.*;
import java.io.*;
class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Usage of BufferedOutputStream and BufferedReader
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=0; i<n; i++){
            if(Integer.parseInt(br.readLine())%k==0){
                count++;
            }
        }
        bos.write((count+"\n").toString().getBytes());
        bos.flush();
    }
}
