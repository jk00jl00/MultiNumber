import java.util.Scanner;

public class MultiNumbers {
    public static void main(String[] args){
        int base = 0;
        int num = 0;
        Scanner sc = new Scanner(System.in);
        base = sc.nextInt();
        num = sc.nextInt();
        int x = getX(base, num);
        System.out.println(x);
    }

    static int getX(int b, int n){
        if(b != 10){

        }
        else{
            getNumInBase(b, n);
        }
        return 0;
    }
    static int getNumInBase(int b, int n){
        return 0;
    }
}
