package Naumov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task36();
        task61();
        task86();
        task111();
        task136();
    }

    /**
     * 36.Дано натуральное число n. Вычислить P = (1-1/2^2) (1-1/3^2)... (1-1/n^2), где n>2 .
     */
    private static void task36() {
        Scanner input = new Scanner(System.in);
        double n = Double.parseDouble(input.nextLine());

        double current = 0, P = 1;

        for (int i = 2; i <= n; i++) {
            current = 1 - 1 / (n * n);
            P *= current;
        }

        System.out.println(P);
    }

    /**
     * 61. Составить программу возведения натурального числа в квадрат, учитывая следующую закономерность:
     * a. 1^2 = 1
     * b. 2^2 = 1 + 3
     * c. 3^2 = 1 + 3 + 5
     * d. 4^2 = 1 + 3 + 5 + 7
     * e. …
     * f. n^2 = l + 3 + 5 + 7 + 9 + ... + 2n – 1
     */

    private static void task61() {

        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        int square = 0;

        for (int i = 1; i <= 2 * num - 1; i += 2) {
            square += i;
        }

        System.out.println(square);

    }


    /**
     * 86.Известно сопротивление каждого из элементов электрической цепи. Определить общее сопротивление цепи, если:
     * а) все элементы соединены последовательно;
     * б) все элементы соединены параллельно.
     */

    private static void task86() {
        Scanner input = new Scanner(System.in);

        int connectionType = 0;
        do {
            System.out.println("Введите тип соединения в цепи (0 -- последовательно, 1 -- параллельно): ");
            connectionType = input.nextInt();
            if (connectionType != 0 && connectionType != 1)
                System.out.println("Введено некорректное значение");
        } while (connectionType != 0 && connectionType != 1);
        // использование break внутри циклов while считается плохой практикой, корректнее использовать do while

        double RTotal = 0;
        input = new Scanner(System.in);
        System.out.println("Введите значения сопротивлений с новой строки (пустой ввод -- завершение): ");
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals(""))
                break;
            double R = Double.parseDouble(str);
            if (connectionType == 0) {
                RTotal += R;
            } else {
                RTotal += 1 / R;
            }
        }

        if (connectionType == 1) {
            RTotal = 1 / RTotal;
        }

        System.out.println("Суммарное сопротивление: " + RTotal);

    }


    /**
     * 111. Составить программу-генератор простых чисел, в основу положить формулу 2х2 + 29 при 0 ≤ х ≤ 28.
     */

    private static void task111() {
        System.out.println("Простые числа по формуле 2x² + 29 при 0 <= x <= 28: ");
        for (int x = 0; x <= 36; x++) {
            System.out.println(2 * x * x + 29);
        }
    }

    /**
     * 136. Какими цифрами следует заменить а и b, чтобы выполнялось уравнение (а + а) + 3(b + b) = а^a + b^b?
     */

    private static void task136() {
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if ((a + a) + 3 * (b + b) == (int) Math.pow(a, a) + (int) Math.pow(b, b)) {
                    System.out.println("a: " + a);
                    System.out.println("b: " + b);
                    break;
                }
            }
        }
    }
}












