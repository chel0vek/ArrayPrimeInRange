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
        int[] array = fillArrayWithPrimeNums(a, b);
        System.out.println("простые числа в промежутке от а до b " + Arrays.toString(fillArrayWithPrimeNums(a, b)));
        System.out.println("простые индексы массива " + Arrays.toString(fillArrayWithPrimeNums(0, array.length)));
        System.out.println("sum = " + sumNums(a, b));
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
        for (int i = start; i <= finish; i++) {
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
        return array;
    }

    static int sumNums(int start, int finish) {
        int sum = 0;
        int[] array1 = fillArrayWithPrimeNums(start, finish);
        int[] array2 = fillArrayWithPrimeNums(0, array1.length);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array2.length; i++) {
            int val = array2[i];
            sum += array1[val];
        }
        return sum;
    }
}