import java.lang.Math;
class Rekur {
    public static void main(String[] args) {
        //System.out.println(plus(10));
        //System.out.println(fibo(50));
        //System.out.println(fac(10));
        int[] intarray = {0, 1, 3, 1, 5};
        System.out.println(maxarray(intarray, 0, intarray.length));
    }

    public static int plus(int N) {
        System.out.println(N);
        if(N == 1) {
            return 1;
        }
        return N + plus(N-1);
    }

    public static int fibo(int N) {
        //System.out.println(N);
        if(N == 1) {
            return 1;
        } else if(N == 0) {
            return 0;
        }
        return fibo(N-1) + fibo(N-2);
    }

    public static int fac(int n) {
        if(n==0) {
            return 1;
        }
        return n*fac(n-1);
    }

    public static int maxarray(int[] array, int first, int last) {
        if(last - first <= 1) {
            return array[first];
        }
        int mid = (last - first)/2;
        return Math.max(maxarray(array, first, first + mid), 
                        maxarray(array, first + mid, last));
    }
}
