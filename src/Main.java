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
        System.out.println("простые числа в промежутке от а до b " + Arrays.toString(fillArrayWithPrimeNums(a, b)));
        System.out.println("простые индексы массива " + Arrays.toString(fillArrayWithPrimeIndexes(a, b)));
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

    static boolean isPrimeIndex(int index) {
        if (index <= 1) {
            return false;
        }
        return indexDivider(index, divider);
    }

    static boolean indexDivider(int index, int divider) {
        if (divider <= index) {
            if (index % divider == 0) {
                dividers++;
            }
            return indexDivider(index, ++divider);
        }
        if (dividers == 2) {
            return true;
        } else {
            return false;
        }
    }

    static int[] fillArrayWithPrimeIndexes(int start, int finish) {
        int size = 0;
        int index = 2;
        int[] array1 = fillArrayWithPrimeNums(start, finish);
        int length = array1.length;
        System.out.println(length);
        for (int i = start; i <= length; i++) {
            dividers = 0;
            if (isPrimeIndex(i)) {
                size++;
            }
        }
        int[] array = new int[size];
        int indexZero = 0;
        // облатсь в которой метод должен пройтись по первому массиву и найти его простые индексы.
        for (int i = index; i <= length; i++) {
            dividers = 0;
            if (isPrimeIndex(i)) {
                array[indexZero] = i;
                indexZero++;
            }
        }
        return array;
    }
    /*static int sumNums(int start, int finish) {
        int index = 2;
        int sum = 0;
        int size = 0;
        for (int i = start; i <= finish; i++) {
            dividers = 0;
            if(isPrimeNumber(i)) {
                size++;
            }
        }
        int[] arr = new int[size];
        System.out.println(Arrays.toString(arr));
        for (int i = start; i <= size; i++) {
            dividers = 0;
            if (isPrimeIndex(i)) {
                arr[index] = i;
                index++;
            }
        }
        for (int i = start; i <= size; i++) {
            dividers = 0;
            if (isPrimeIndex(i)) {
                if (start <= size) {
                    sum = sum + arr[i];
                    sumNums(start,finish);
                }
            }
        }
        return sum;
    } */
}