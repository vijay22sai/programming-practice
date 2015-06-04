import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        StringTokenizer st = null;
        int testcases = Integer.parseInt(br.readLine());
        int n = 0;
        int m = 0;
        int []p = null;
        //int [][]arr = null;
        int temp  = 0;
        int r = 0;
        MaxHeap mh = null;
        long sum;
        String output = "";
        for(int i=0; i<testcases; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            p = new int[n];
            mh = new MaxHeap(n , 101);
            sum = 0L;
            if(m<1 || m>10000){System.exit(1);}
            for(int j=0; j<m; j++){
                temp = Integer.parseInt(st.nextToken());
                p[temp] += 1;
            }
            //arr = new int[n][100];
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                if(p[j]!=0){
                    r = Integer.parseInt(st.nextToken());
                    if(r<1 || r>100){System.exit(1);}//
                    for(int k=0; k<r; k++){
                        int item = Integer.parseInt(st.nextToken());
                        if(item<1 || item>100000){System.exit(1);}//
                        mh.insert(j,item);
                    }
                }
            }
            
            for(int j=0; j<n; j++){
                int iter = p[j];
                for(int k=0; k<iter; k++){
                    sum += mh.ExtractMax(j);
                }
            }
            System.out.println(sum);
        }
        //bos.write(output.getBytes());
        //bos.flush();
    }
    static class MaxHeap{
        public  int arr[][] = null;
        public int sizes[] = null;
        static int n;
        static int k;
        int curr;
        public MaxHeap(int n, int k){
            this.n = n;
            this.k = k+1;
            arr = new int[n][k+1];
            sizes = new int[n];
        }
        public int ExtractMax(int ind){
            this.curr = ind;
            int length = sizes[ind];
            if(length==0){return 0;}
            if(length==1){
                int item = arr[ind][1];
                arr[ind][1] = 0;
                sizes[ind]--;
                return item;
            } 
            swap(1,length);
            int item = arr[ind][length];
            arr[ind][length] = 0;
            sizes[ind]--;
            bubbledown(1);
            return item;
        }
        public void insert(int ind,int item){
            this.curr = ind;
            if(sizes[ind]==0){
                arr[ind][1] = item;
                sizes[ind] = 1;
                return ;
            }
            int length = sizes[ind];
            arr[ind][length+1] =  item;
            sizes[ind]++;
            bubbleup(length+1);
            return;
        }
        private void bubbleup(int index){
            int length = sizes[curr];
            if((length/2) == 0){return;}
            int parent = length/2;
            if(arr[curr][index] > arr[curr][parent]){
                swap(index,parent);
                bubbleup(parent);
            }
            return;
        }
        private void bubbledown(int index){
            int length = sizes[curr];
            if(length<=1){return ;}
            int child1 = 2*index;
            int child2 = 2*index + 1;
            if(child2<=length){
                int maxchild = max(child1,child2);
                if(arr[curr][index] < arr[curr][maxchild]){
                    swap(index,maxchild);
                    bubbledown(maxchild);
                }
                return ;
            }
            else if(child1<=length){
                if(arr[curr][index] < arr[curr][child1]){
                    swap(index,child1);
                    bubbledown(child1);
                }
                return ;
            }
            else{
                return ;
            }
        }
        private void swap(int ind1, int ind2){
            int item1 = arr[curr][ind1];
            arr[curr][ind1] = arr[curr][ind2];
            arr[curr][ind2] = item1;
            return;
        }
        private int max(int ind1, int ind2){
            return (arr[curr][ind1] > arr[curr][ind2])?ind1:ind2;
        }
    }
}

