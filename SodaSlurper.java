public class SodaSlurper {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int bottles = io.getInt() + io.getInt();
        int c = io.getInt();
        int drinks = 0;
        while (bottles >= c) {
            int drinksThisRound = bottles / c;
            drinks += drinksThisRound;
            bottles = bottles - drinksThisRound*c + drinksThisRound;
        }
        System.out.println(drinks);
    }
}
