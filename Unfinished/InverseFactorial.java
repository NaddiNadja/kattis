package Unfinished;

import java.math.BigInteger;

public class InverseFactorial {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String s = io.getWord();
        double x = Double.parseDouble(s);
        System.out.println(x/GammaFunction.st_gamma(x));

        // BigInteger in = new BigInteger(s);
        // BigInteger i = new BigInteger(Integer.toString(((int)x/2)));

        

        // while (i.compareTo(in)==-1) {
        //     in = in.divide(i);
        //     i = i.add(new BigInteger("1"));
        // }
        // System.out.println(i);

        // long zeros = 0;
        // for (int i = s.length()-1; i>0; i--) {
        //     if (s.charAt(i) == '0') zeros++;
        //     else break;
        // }
        // long minfact = reverseSum(zeros);


        // BigInteger in = new BigInteger(s);
        

        // BigInteger i = new BigInteger("2");


        // while (i.compareTo(in)==-1) {
        //     in = in.divide(i);
        //     i = i.add(new BigInteger("1"));
        // }
        // System.out.println(i);
    }

    static class GammaFunction {
 
        static double st_gamma(double x){
            return Math.sqrt(2*Math.PI/x)*Math.pow((x/Math.E), x);
        }
     
        static double la_gamma(double x){
            double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
                           771.32342877765313, -176.61502916214059, 12.507343278686905,
                           -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
            int g = 7;
            if(x < 0.5) return Math.PI / (Math.sin(Math.PI * x)*la_gamma(1-x));
     
            x -= 1;
            double a = p[0];
            double t = x+g+0.5;
            for(int i = 1; i < p.length; i++){
                a += p[i]/(x+i);
            }
     
            return Math.sqrt(2*Math.PI)*Math.pow(t, x+0.5)*Math.exp(-t)*a;
        }
    }
}

/*
double x   =    n * Math.log10(n / Math.E)  + Math.log10(n); 
s.length() - 2 - Math.log10(2*Math.PI)/2 = x;

10^s.length() =     (n^n/e)^n * sqrt(2*pi*n)


*/