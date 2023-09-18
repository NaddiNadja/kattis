public class HelloWorld {
    public static void main(String[] args) {
        char[] alphabet = new char[26];
        char[] ALPHABET = new char[26];
        int currentLetter = (int) 'a';
        int currentLETTER = (int) 'A';
        for (int i = 0; i<26; i++) {
            alphabet[i] = (char) currentLetter;
            ALPHABET[i] = (char) currentLETTER;
            currentLetter++;
            currentLETTER++;
        }

        String hw = "Hello World!";
        char[] output = new char[hw.length()];
        for (int i = 0; i<hw.length(); i++) {
            for (int j = 0; j<26; j++) {
                if (alphabet[j] == hw.charAt(i)) {
                    output[i] = alphabet[j];
                    break;
                }
                else if (ALPHABET[j] == hw.charAt(i)) {
                    output[i] = ALPHABET[j];
                    break;
                } 
            }
            if (hw.charAt(i) == '!') output[i] = hw.charAt(i);
            if (hw.charAt(i) == ' ') output[i] = hw.charAt(i);
        }

        for (int i = 0; i<output.length; i++) {
            char c = output[i];
            System.out.print(c);
        }
        
        System.out.println();
    }
}



