package Unfinished;

import java.util.*;
import java.lang.Math;

public class InquiryI {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] input = new int[n];
        for (int i = 0; i<n; i++) input[i] = io.getInt();
        long maxresult = 0;
        for (int i = 1; i<n; i++) {
            long firstsum = 0;
            long secondsum = 0;
            for (int j = 0; j<i; j++) firstsum += Math.pow(input[j],2);
            for (int j = i; j<n; j++) secondsum += input[j];
            if (firstsum*secondsum > maxresult) maxresult = firstsum*secondsum;
        }
        System.out.println(maxresult);
    }

    static class LongComp implements Comparator<Long> {
        public int compare(Long a, Long b) {
            if (a.longValue() > b.longValue()) return -1;
            else if (a.longValue() < b.longValue()) return 1;
            else return 0;
        }
    }
}