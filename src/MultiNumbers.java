import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MultiNumbers {
    public static ArrayList<Long> numList = new ArrayList<>();
    public static ArrayList<Integer> intList = new ArrayList<>();
    public static int goneThrough = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        long num = sc.nextLong();
        long x = getX(num, base);
        if(x == 0){
            System.out.println("impossible");
            return;
        }
        System.out.print(x);
    }

    public static long getX(long number, int b){
        goneThrough++;
        int[] xArray = getFactors(number, b);
        if(xArray[0] == 0 && goneThrough > 3){
            return 0;
        }
        long xIs = putTogetherNumber(xArray, b);
        if(xIs != 0 || goneThrough < 4){
            xIs = getX(number, b);
        }
        if(xIs == 0) {
            xIs = getSmallest(numList);
            return xIs;
        }
        return xIs;
    }
    public static int[] getFactors(long n, int b){
        ArrayList<Integer> factors= new ArrayList<>();
        mainLoop:
        while(n > 1){
            for(int i = b-1; i > 1; i--){
                if(n%i == 0 && (!intList.contains(i) || !factors.isEmpty())){
                    factors.add(i);
                    intList.add(i);
                    n /= i;
                    break;
                }
                else if(i == 2){
                    factors.clear();
                    break mainLoop;
                }
            }
        }
        if(factors.size() == 0){
            int[] newArray = {0};
            return newArray;
        }
        int u = 0;
        int[] returnArray = new int[factors.size()];
        for(int i : factors){
            returnArray[u] = i;
            u++;
        }
        return returnArray;
    }
    public static long putTogetherNumber(int[] array, int b){
        long returnLong = 0;
        long pos = array.length - 1;
        Arrays.sort(array);
        for(int i : array){
            if((long)Math.pow(b,pos) * i < 0)
                return 0;
            returnLong += i * (long)Math.pow(b ,pos);
            pos--;
        }
        numList.add(returnLong);
        return returnLong;
    }
    public static long getSmallest(ArrayList<Long> list){
        long smallest = 0;
        boolean firstTime = true;
        for(long i : list) {
            if (firstTime && i > 0) {
                smallest = i;
                firstTime = false;
            }
            if (i < smallest && i > 0){
                smallest = i;
            }
        }
        return smallest;
    }
}