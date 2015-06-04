import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        while(true){
            n = sc.nextInt();
            if(n==42) break;
            else{System.out.println(n);}
        }
    } 
}
