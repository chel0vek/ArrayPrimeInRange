import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int dividers;
    static int divider = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите два числа");
        int a = input.nextInt();
        int b = input.nextInt();
        fillArrayWithPrimeNums(a, b);
    }

    static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        return divider(number, divider);
    }

    static boolean divider(int number, int divider) {
        if (divider <= number) {
            if (number % divider == 0) {
                dividers++;
                //System.out.println(dividers + " колво делителей чилса " + number + " делитель числа " + divider);
            }
            return divider(number, ++divider);
        }
        if (dividers == 2) {
            return true;
        } else {
            return false;
        }
    }

    static int[] fillArrayWithPrimeNums(int start, int finish) {
        int size = 0;
        for(int i = start; i <= finish; i++) {
            dividers = 0;
            if (isPrimeNumber(i)) {
                size++;
            }
        }
        int[] array = new int[size];
        int index = 0;
        for (int i = start; i <= finish; i++) {
            dividers = 0;
            if (isPrimeNumber(i)) {
                array[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}