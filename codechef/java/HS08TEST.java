import java.util.Scanner;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        //System.out.println(ss.length);
        double amountToWithdraw = Double.parseDouble(ss[0]);
        double accountBalance = Double.parseDouble(ss[1]);
        if (accountBalance < amountToWithdraw){
            System.out.println(accountBalance);
            System.exit(0);
        }
        int x = (int)amountToWithdraw % 5;
        if (x != 0){
            System.out.println(accountBalance);
            System.exit(0);
        }
        int y = (int)amountToWithdraw / 5;
        double charges = 0.5;
        double finalBalance = accountBalance - amountToWithdraw - charges;
        if(finalBalance<0){
            System.out.println(accountBalance);
            System.exit(0);
        }
        System.out.println(finalBalance);
    }
}
