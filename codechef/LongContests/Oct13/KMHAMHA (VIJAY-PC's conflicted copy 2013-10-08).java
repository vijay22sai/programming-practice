import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            long ans = 0;
            HashMap<Integer,TreeSet> hor = new HashMap<Integer,TreeSet>();
            HashMap<Integer,TreeSet> ver = new HashMap<Integer,TreeSet>();
            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                TreeSet<Integer> temp;
                if(hor.containsKey(x)){
                    temp = hor.get(x);
                    temp.add(y);
                }
                else{
                    temp = new TreeSet<Integer>();
                    temp.add(y);
                    hor.put(x,temp);
                }
                if(ver.containsKey(y)){
                    temp = ver.get(y);
                    temp.add(x);
                }
                else{
                    temp = new TreeSet<Integer>();
                    temp.add(x);
                    ver.put(y,temp);
                }
            }

            long max = 0;
            char pl = 'x';
            Integer keyDel = 0;
            while(true){
                max = 0;
                Set<Integer> horKeys = new TreeSet<Integer>();
                horKeys.addAll(hor.keySet());
                for(Integer key: horKeys){
                    if(max<hor.get(key).size()){
                        max = hor.get(key).size();
                        pl = 'x';
                        keyDel = key;
                    }
                }
                Set<Integer> verKeys = new TreeSet<Integer>();
                verKeys.addAll(ver.keySet());
                for(Integer key: verKeys){
                    if(max<ver.get(key).size()){
                        max = ver.get(key).size();
                        pl = 'y';
                        keyDel = key;
                    }
                }
                if(max==0){
                    break;
                }
                if(pl=='x'){
                    //System.out.println(0);
                    TreeSet<Integer> keys = hor.get(keyDel);
                    for(Integer key: keys){
                        ver.get(key).remove(keyDel);
                    }
                    hor.remove(keyDel);
                }
                else{
                    TreeSet<Integer> keys = ver.get(keyDel);
                    for(Integer key: keys){
                        hor.get(key).remove(keyDel);
                    }
                    ver.remove(keyDel);
                }
                
                ans++;
            }
            System.out.println(ans);
        }
    }
}
