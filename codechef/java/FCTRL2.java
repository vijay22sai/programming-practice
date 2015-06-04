import java.util.*;
import java.io.*;
import java.math.*;

//class Main{
    //public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedOutputStream bos = new BufferedOutputStream(System.out);
        //int t = Integer.parseInt(br.readLine());
        //int n;
        //for(int i=0; i<t; i++){
            //n = Integer.parseInt(br.readLine());
            //if(n<=1){
                //bos.write("1\n".getBytes());
            //}
            //else{
                //BigInteger bi = new BigInteger(new Integer(n).toString());
                //bos.write(((fact(bi,n).toString())+"\n").getBytes());
            //}
        //}
        //bos.flush();
    //}
    //public static BigInteger fact(BigInteger bi,int n){
        //if(n<=1) return bi;
        //return fact(bi.multiply(new BigInteger(new Integer(n-1).toString())),n-1);
    //}
//}

//Better solution

import java.math.BigInteger;
 
class Main {
  public static void main(String[] args) throws java.lang.Exception {
    java.io.BufferedReader br=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    
    for(int j=0;j<n;j++) {
      int t=Integer.parseInt(br.readLine());
      BigInteger fact = BigInteger.ONE;
      for (int i=1; i<=t; i++) {
        fact = fact.multiply(BigInteger.valueOf(i));
      }
      System.out.println(fact);
    }
  }
}  
