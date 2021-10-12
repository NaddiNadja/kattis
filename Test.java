import java.lang.Math;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        test();
    }

    private static double log2(int n) { 
        return (Math.log(n) / Math.log(2));
    }

    private static int factorial(int i) {
        int fact = i;
        while (i>1) {
            i--;
            fact = fact*i;
        }
        return fact;
    }

    private static long combinations(long amount, long take) {
        if (take == 0) return 1;
        long perm = amount;
        long removed = amount-take+1;
        while (amount > removed) {
            amount--;
            perm*=amount;
        }
        long fact = take;
        while (take > 1) {
            take--;
            fact*=take;
        }
        return perm/fact;
    }
    
    private static long findDigits(int n) {
        // Mængden af digits i n!
        if (n < 0) return 0;
        if (n <= 1) return 1; 
        
        // Use Kamenetsky formula to calculate the number of digits 
        double x = n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2.0; 
        return (long) (Math.floor(x) + 1); 
    }

    private static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int lcm(int p, int q) {
        // by the way, this is scuffed, it checks every number from the largest of the two numbers up until lcm. For big integers, this is not effective.
        // should be fixed by primefactoring p and g
        int lcm = (p<q)? q : p;
        while(true) {
            if( lcm % p == 0 && lcm % q == 0 ) break;
            ++lcm;
        }
        return lcm;
    }

    private static class Stack {
        private char[] stack;
        private int size;

        public Stack() {
            stack = new char[1000];
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public void push(char c) {
            stack[size] = c;
            size++;
        }

        public char pop() {
            if (size == 0) return '0';
            size--;
            return stack[size];
        }
    }

    private static int[] getDivisors(int x) {
        int[] temp = new int[x];
        int sum = 0;
        for (int i = 0; i<Math.sqrt(x); i++) {
            if (x % i == 0) {
                temp[sum] = i;
                if (i*i != x) {
                    temp[sum+1] = x/i;
                    sum += 2;
                } else {
                    sum++;
                }
            }
        }
        int[] divisors = new int[sum];
        for (int i = 0; i<sum; i++) divisors[i] = temp[i];
        return divisors;
    }

    private static int digitSum(int i) {
        int sum = 0;
        while(i>0) {
            sum = sum + i%10;
            i = (i - (i%10))/10;
        }
        return sum;
    }

    private static void test() {
        factorial(1);
        combinations(1,1);
        binarySearch(new int[] {1,2,3}, 2);
        findDigits(1);
        log2(1);
        lcm(1,2);
        getDivisors(1);
        new Stack();
        digitSum(1);
    }
}