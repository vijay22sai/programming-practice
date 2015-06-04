import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            if(n<=1){
                bos.write("0\n".getBytes());
            }
            else if(n%2==1){
                bos.write((n-1+"\n").getBytes());
            }
            else{
                bos.write((n+"\n").getBytes());
            }
        }
        bos.flush();
    }
}
