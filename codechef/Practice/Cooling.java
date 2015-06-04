import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int []pies = null;
        int []racks = null;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer pieWeights = new StringTokenizer(br.readLine());
            StringTokenizer rackWeights = new StringTokenizer(br.readLine());
            pies = new int[n];
            racks = new int[n];
            for(int j=0; j<n; j++){
                pies[j] = Integer.parseInt(pieWeights.nextToken());
                racks[j] = Integer.parseInt(rackWeights.nextToken());
            }
            Arrays.sort(pies);
            Arrays.sort(racks);
            int max = racks[n-1];
            int pie = n-1;
            int rack = n-1;
            int count=0;
            for(int j=0; j<n; j++){
                if(pies[pie] <= racks[rack]){
                    count++;
                    rack--;
                    pie--;
                }
                else{
                    pie--;
                }
            }
            System.out.println(count);
        }
    }
}
