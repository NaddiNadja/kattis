public class Apaxiaaans {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        String s = io.getWord();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i)!=s.charAt(i-1)) {
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}

/*
Test cases:
roooooooooooooobert
rrrrrrrrrrrrrrobert
robertttttttttttttt
rroobbeerrtt
*/ 