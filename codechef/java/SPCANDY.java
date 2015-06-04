import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos= new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        long candies = 0L;
        long students = 0L;
        long dist = 0L;
        long remain = 0L;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            candies = Long.parseLong(st.nextToken());
            students = Long.parseLong(st.nextToken());
            if(students==0){
                dist = 0;
                remain = candies;
            }
            else if(candies==0){
                dist = 0;
                remain = 0;
            }
            else{
                dist = candies/students;
                remain = candies % students;
            }
            
            bos.write((dist + " " + remain + "\n").getBytes());
        }
        bos.flush();
    }
}
