import java.util.*;

class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        double[] a = {0, 1, 2, 5, 2, 3};
        System.out.println(findMax(a, 0, a.length));
    }

    public static int factorial(int n) {
        if(n <= 0) {
            return 1;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            return factorial(n-1)*n;
        }
    }

    public static double findMax(double[] array, int startIndex, int endIndex) {
        if(array.length == 0) {
            return 0;
        }
        else if(endIndex - startIndex <= 1) {
            return array[startIndex];
        }
        else {
            int length = endIndex - startIndex;
            return Math.max(findMax(array, startIndex, startIndex + length/2),
                       findMax(array, startIndex + length/2, endIndex));
        }
    }
}
