import java.util.Scanner;

public class Main {
    static int dividers;
    static int divider = 1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите два числа");
        int a = input.nextInt();
        //int b = input.nextInt();
        if (isPrimeNumber(a)) {
            System.out.println(a + " prime");
        }
        else {
            System.out.println(a + " isnt prime");
        }
    }
    static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        return divider(number,divider);
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
        }
        else {
            return false;
        }
    }
}