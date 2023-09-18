public class GradesPerson implements Comparable<GradesPerson> {
    String grade;
    String name;

    public GradesPerson(String name, String grade){
        this.name = name;
        this.grade = grade;
    }  
    
    public int compareTo(GradesPerson b) {
       
        if (this.grade.compareTo(b.grade) == 0) return this.name.compareTo(b.name);

        String aMain;
        String bMain;
        String aSub;
        String bSub;

        if (this.grade.contains("FX")) aMain = this.grade.substring(0,2);
        else aMain = this.grade.substring (0,1);
        if (b.grade.contains("FX")) bMain = b.grade.substring(0,2);
        else bMain = b.grade.substring (0,1);
        
        if (aMain.compareTo("FX")==0) aSub = this.grade.substring(2);
        else aSub = this.grade.substring(1);
        if (bMain.compareTo("FX")==0) bSub = b.grade.substring(2);
        else bSub = b.grade.substring(1);

        if      (aMain.compareTo("FX")==0 && bMain.compareTo("F")==0) return -1;
        else if (aMain.compareTo("FX")==0 && bMain.compareTo("FX")!=0) return 1;
        else if (aMain.compareTo("F")==0 && bMain.compareTo("FX")==0) return 1;
        else if (aMain.compareTo(bMain)<0) return -1;
        else if (aMain.compareTo(bMain)>0) return 1;
        else return checkSubString(aSub, bSub);

    }

    private int checkSubString(String a1, String b1) {

        if (a1.isEmpty()) {
            if (b1.charAt(0)=='-') return -1;
            else return 1;
        }
        else if (b1.isEmpty()) {
            if (a1.charAt(0)=='+') return -1;
            else return 1;
        }
        else if (a1.charAt(0)!=b1.charAt(0)) {
            if (a1.charAt(0)=='+') return -1;
            else return 1;
        }
        else {
            if (a1.charAt(0)=='+' && a1.length()>b1.length()) return -1;
            else if (a1.charAt(0)=='+') return 1;
            else if (a1.charAt(0)=='-' && a1.length()<b1.length()) return -1;
            else return 1;
        }
    }
}