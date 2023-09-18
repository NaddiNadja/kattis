public class Person implements Comparable<Person> {
    String name;
    String sub;

    public int compareTo(Person that) {
        return this.sub.compareTo(that.sub);
    }

    public Person (String name){
        this.name = name;
        this.sub = name.substring(0,2);
        
    }
}