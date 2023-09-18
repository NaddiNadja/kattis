import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Grades {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        GradesPerson[] arr = new GradesPerson[n];
        String name;
        String grade;

        for (int i = 0; i<n; i++) {
            name = StdIn.readString();
            grade = StdIn.readString();
            arr[i] = new GradesPerson(name, grade);
        }
        
        Insertion.sort(arr);

        for (int i = 0; i<n; i++){
            GradesPerson x = arr[i];
            StdOut.println(x.name);
        }
    }
}

/*
INPUT
The input starts with the the number n of students, an integer in the range 1≤n≤1000. 
The following n lines each contain the name of a student followed by a grade, separated 
by a single space. The name of a student is a nonempty sequence of lower-case English 
letters from a to z of length at most 20. A grade starts with one of the upper-case letters 
A, B, C, D, E, F. The letter F may be followed by an upper-case X. Then follows a 
(possibly empty) sequence of either + or − of length at most 10.

OUTPUT
The students, one per line, ordered by grade, best students first. Students with the same 
grade must be ordered alphabetically.

-------------------------------------------------------------------------------------------
SAMPLE INPUT
-------------------------------------------------------------------------------------------
10
abelone A
andersine A
bo A
bosse A
anton F
antonina F
anders A
konstantin F
william F
andreas A

10
abelone A--------
andersine A+
bo A
bosse A++
anton FX-
antonina FX+
anders A+
konstantin FX
william F
andreas A+
*/