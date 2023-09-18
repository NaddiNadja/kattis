import java.util.Scanner;
import java.lang.Math;

public class Base2Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.close();
        
        double sum = 0; //the sum of all palindromes with "count" or less digits.
        int count = 0; //the number of digits in binary number
        boolean found = false;
        while (!found) {
            count++;
            if (count % 2 == 0) sum += Math.pow(2, (count-1)/2);
            else sum += Math.pow(2, count/2);
            if (sum>=M) found = true;
        }

        double combinations = (count % 2 == 0)? Math.pow(2, (count-1)/2) : Math.pow(2, count/2);

        //i will build the number as a string (only one half, since it's a palindrome and can be mirrored)
        StringBuilder sb = new StringBuilder(); 
        sb.append(1);

        //binary search imitation with hi = sum, lo = start and mid = guess
        //the search will look for M and add 0 or 1 to the string for each step depending on whether it has to look in top or bottom half
        //since the number of combination always is a power of 2, we can adjust the classic algorithm a bit to fit better

        int start = (int) sum - (int) combinations;
        int guess = 0;
        if (M>2) while (start<sum) {
            guess = start + (int) (sum-start)/2;
            if (guess < M) {
                sb.append(1);
                start = guess+1;
            } else if (guess > M) {
                sb.append(0);
                sum = guess;
            } else {
                sb.append(0);
                sum = guess-1;
            }
        }

        //i had a problem that sometimes the last digit weren't added, and I didn't know how to fix it, so i added this
        if (count % 2 == 0 && sb.length() < count/2) {
            if (M % 2 == 0) sb.append(1);
            else sb.append(0);
        }
        else if (count % 2 == 1 && sb.length() < count/2+1) {
            if (M % 2 == 0) sb.append(1);
            else sb.append(0);
        }

        //at this point i only have one half of the number, so the finish-methods just take and mirror the string and add it at the end
        String number = "";
        if (count % 2 == 0) number = finishEven(sb.toString());
        else number = finishOdd(sb.toString());
        
        //System.out.println(number);
        System.out.println(Integer.parseInt(number, 2));
    }

    static String finishOdd(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = sb.length()-2; i>=0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }

    static String finishEven(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = sb.length()-1; i>=0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}