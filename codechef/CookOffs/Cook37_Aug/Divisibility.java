import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ar = new int[n+1];
        ht = new Hashtable[n+1];

        for(int i=1; i<n+1; i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }
        init();
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int l,r,k;
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            bos.write(calc(l,r,k).getBytes());
        }
        bos.flush();
        //~ for(int i=1; i<n+1; i++){
            //~ Hashtable<Integer,Integer> htk = ht[i];
            //~ Enumeration<Integer> enumKey = htk.keys();
            //~ while(enumKey.hasMoreElements()){
                //~ Integer ky = enumKey.nextElement();
                //~ System.out.println(ky + " - " + htk.get(ky));
            //~ }
        //~ }
    }
    public static Hashtable<Integer,Integer>[] ht;
    public static int n;
    public static int[] ar;
    public static String calc(int l,int r, int k){
        if(k==1){
            return (r-l+1)+"\n";
        }
        int count = 0;
        Hashtable<Integer,Integer> htk = primeFactors(k);
        Hashtable<Integer,Integer> hti;
        Integer key;
        Enumeration<Integer> enumKey;
        int flag = 0;
        for(int i=l; i<r+1; i++){
            flag = 0;
            if(ar[i] < k) continue;
            hti = ht[i];
            enumKey = htk.keys();
            while(enumKey.hasMoreElements()) {
                key = enumKey.nextElement();
                if(htk.get(key)==null && hti.get(key)!=null){
                    flag = 0;
                    break;
                }
                else if(hti.get(key)==null && htk.get(key)!=null){
                    flag = 0;
                    break;
                }
                else if(htk.get(key) <= hti.get(key)){
                    flag = 1;
                    
                }
                else{
                    flag = 0;
                    break;
                }
            }
            if(flag==1){count++;}
        }
        return count+"\n";
    }
    public static void init(){
        for(int i=1; i<n+1; i++){
            ht[i] = primeFactors(ar[i]);
        }
    }
    
    public static Hashtable<Integer,Integer> primeFactors(int n) {
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        Integer ii;
        for (int i = 2; i <= n/i; i++) {
          while (n % i == 0) {
            ii = ht.get(i); 
            if(ii==null){
                ht.put(i,1);
            }
            else{
                ht.put(i,ii+1);
            }
            n /= i;
          }
        }
        if (n > 1) {
            ii = ht.get(n); 
            if(ii==null){
                ht.put(n,1);
            }
            else{
                ht.put(n,ii+1);
            }
        }
        return ht;
    }
}
