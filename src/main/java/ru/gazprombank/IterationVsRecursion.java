package ru.gazprombank;

public class IterationVsRecursion {

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n-1);
    }

    static long factorialIterative(long n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println("Recursive factorial of 10 is " + factorialTailRecursive(10));
        System.out.println("Recursive factorial of 10 is " + factorialRecursive(10));
        System.out.println("Iterative factorial of 10 is " + factorialIterative(10));
    }

}
