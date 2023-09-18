public class ToTusindOtteogFyrre {
    static int[] input = new int[16];
    static int[] output = new int [16];
        public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        for (int i = 0; i<16; i++) {
            input[i] = io.getInt();
        }

        int op = io.getInt();

        if (op==0) { //left
            left();
        } else if (op==1) { //up
            up();
        } else if (op==2) { //right
            right();
        } else { //down
            down();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(output[0]); sb.append(" "); sb.append(output[1]); sb.append(" "); sb.append(output[2]); sb.append(" "); sb.append(output[3]); sb.append("\n");
        sb.append(output[4]); sb.append(" "); sb.append(output[5]); sb.append(" "); sb.append(output[6]); sb.append(" "); sb.append(output[7]); sb.append("\n");
        sb.append(output[8]); sb.append(" "); sb.append(output[9]); sb.append(" "); sb.append(output[10]); sb.append(" "); sb.append(output[11]); sb.append("\n");
        sb.append(output[12]); sb.append(" "); sb.append(output[13]); sb.append(" "); sb.append(output[14]); sb.append(" "); sb.append(output[15]);
        
        io.print(sb);
        io.close();
    }

    static void left(){
        for (int i = 0; i<16; i=i+4) {
            int a1 = i;
            int a2 = i+1;
            int a3 = i+2;
            int a4 = i+3;
            int a = input[a1];
            int b = input[a2];
            int c = input[a3];
            int d = input[a4];
            playgame(a1, a2, a3, a4, a, b, c, d);
        }
    }

    static void up(){
        for (int i = 0; i<4; i++) {
            int a1 = i;
            int a2 = i+4;
            int a3 = i+8;
            int a4 = i+12;
            int a = input[a1];
            int b = input[a2];
            int c = input[a3];
            int d = input[a4];
            playgame(a1, a2, a3, a4, a, b, c, d);
        }
    }

    static void right(){
        for (int i = 0; i<16; i=i+4) {
            int a1 = i+3;
            int a2 = i+2;
            int a3 = i+1;
            int a4 = i;
            int a = input[a1];
            int b = input[a2];
            int c = input[a3];
            int d = input[a4];
            playgame(a1, a2, a3, a4, a, b, c, d);
        }
    }

    static void down(){
        for (int i = 0; i<4; i++) {
            int a1 = i+12;
            int a2 = i+8;
            int a3 = i+4;
            int a4 = i;
            int a = input[a1];
            int b = input[a2];
            int c = input[a3];
            int d = input[a4];
            playgame(a1, a2, a3, a4, a, b, c, d);
        }
    }

    static void playgame(int a1, int a2, int a3, int a4, int a, int b, int c, int d) {
        if (a==0) {
            if (b==0) {
                if (c==0) {
                    if (d==0) {
                        output[a1] = 0;
                    } else {
                        output[a1] = d;
                    }
                    output[a2] = 0;
                    output[a3] = 0;
                    output[a4] = 0;
                } else {
                    if (d==0) {
                        output[a1] = c;
                        output[a2] = 0;
                    } else {
                        if (c==d) {
                            output[a1] = c+d;
                            output[a2] = 0;
                        }
                        else {
                            output[a1] = c;
                            output[a2] = d;
                        }
                    }
                    output[a3] = 0;
                    output[a4] = 0;
                }
            } else {
                if (c==0) {
                    if (d==0) {
                        output[a1] = b;
                        output[a2] = 0;
                    } else {
                        if (b==d) {
                            output[a1] = b+d;
                            output[a2] = 0;
                        } else {
                            output[a1] = b;
                            output[a2] = d;
                        }
                    }
                    output[a3] = 0;
                    output[a4] = 0;
                } else {
                    if (d==0) {
                        if (b==c) {
                            output[a1] = b+c;
                            output[a2] = 0;
                        } else {
                            output[a1] = b;
                            output[a2] = c;
                        }
                        output[a3] = 0;
                    } else {
                        if (b==c) {
                            output[a1] = b+c;
                            output[a2] = d;
                        } else if (c==d) {
                            output[a1] = b;
                            output[a2] = c+d;
                        } else {
                            output[a1] = b;
                            output[a2] = c;
                            output[a3] = d;  
                        } 
                    }
                    output[a4] = 0;
                }
            }
        } else {
            if (b==0) {
                if (c==0) {
                    if (d==0) {
                        output[a1] = a;
                        output[a2] = 0;
                    } else {
                        if (a==d) {
                            output[a1] = a+d;
                            output[a2] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = d;
                        }
                    }
                    output[a3] = 0;
                    output[a4] = 0;
                } else {
                    if (d==0) {
                        if (a==c) {
                            output[a1] = a+c;
                            output[a2] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = c;
                        }
                        output[a3] = 0;
                    } else {
                        if (a==c) {
                            output[a1] = a+c;
                            output[a2] = d;
                            output[a3] = 0;
                        } else if (c==d) {
                            output[a1] = a;
                            output[a2] = c+d;
                            output[a3] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = c;
                            output[a3] = d;  
                        } 
                    }
                    output[a4] = 0;
                }
            } else {
                if (c==0) {
                    if (d==0) {
                        if (a==b) {
                            output[a1] = a+b;
                            output[a2] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = b;
                        }
                        output[a3] = 0;
                    } else {
                        if (a==b) {
                            output[a1] = a+b;
                            output[a2] = d;
                            output[a3] = 0;
                        } else if (b==d) {
                            output[a1] = a;
                            output[a2] = b+d;
                            output[a3] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = b;
                            output[a3] = d;
                        }
                    }
                    output[a4] = 0;
                } else {
                    if (d==0) {
                        if (a==b) {
                            output[a1] = a+b;
                            output[a2] = c;
                            output[a3] = 0;
                        } else if (b==c) {
                            output[a1] = a;
                            output[a2] = b+c;
                            output[a3] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = b;
                            output[a3] = c;  
                        } 
                        output[a4] = 0;
                    } else {
                        if (a==b) {
                            output[a1] = a+b;
                            if (c==d) {
                                output[a2] = c+d;
                                output[a3] = 0;
                            } else {
                                output[a2] = c;
                                output[a3] = d;
                            }
                            output[a4] = 0;
                        } else if (b==c) {
                            output[a1] = a;
                            output[a2] = b+c;
                            output[a3] = d;
                            output[a4] = 0;
                        } else if (c==d) {
                            output[a1] = a;
                            output[a2] = b;
                            output[a3] = c+d;
                            output[a4] = 0;
                        } else {
                            output[a1] = a;
                            output[a2] = b;
                            output[a3] = c;
                            output[a4] = d;
                        } 
                    }
                }
            }
        }
    }
}