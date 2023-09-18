import java.lang.Math;

public class AnthonyAndDiablo {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        double a = Double.parseDouble(sc.getWord());
        double n = Double.parseDouble(sc.getWord());
        System.out.println((Math.PI * Math.pow(n/(2*Math.PI),2) >= a)? "Diablo is happy!" : "Need more materials!");
    }   
}