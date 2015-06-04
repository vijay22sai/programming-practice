import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<t ; i++){
            int n = Integer.parseInt(sc.nextLine());
            int noOfFives = n/5;
            int fives = noOfFives;
            while(fives > 1){
                noOfFives += fives/5;
                fives=fives/5;
            }
            System.out.println(noOfFives);
        }
    }
}
