public class Greetings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String s = io.getWord();
        StringBuilder sb = new StringBuilder();
        sb.append('h');
        for (int i = 0; i<s.length()-2; i++) sb.append("ee");
        sb.append('y');
        System.out.println(sb);
    }
}