import java.util.HashSet;
import java.util.Set;

public class learnSet {

    public static void main(String[] args) {

    //****************************** HASH SET ******************************

//        Set<Integer> set = new HashSet<>();

//        set.add(32);
//        set.add(12);
//        set.add(21);
//        set.add(41);
//        set.add(62);
//        set.add(7);
//
//        System.out.println(set); // [32, 21, 7, 41, 12, 62]
        // it prints in random order and avoid duplicates in the set, if we try to add duplicate value then it will not take it and wil only print all element only once

//        set.remove(41);
//
//        System.out.println(set); // [32, 21, 7, 12, 62]
//
//        System.out.println(set.contains(62)); // true
//
//        System.out.println(set.isEmpty()); // false
//
//        System.out.println(set.size()); // 5
//
//        set.clear();
//
//        System.out.println(set); // []

        //******************************LINKED HASH SET ******************************


//        Set<Integer> lset = new LinkedHashSet<>();
//
//        lset.add(32);
//        lset.add(12);
//        lset.add(21);
//        lset.add(41);
//        lset.add(62);
//        lset.add(7);
//
//        System.out.println(lset); // [32, 12, 21, 41, 62, 7]
        // here everything will be same as above(hash set) except that here our order will be mantained

        //******************************TREE SET ******************************


//        Set<Integer> tset = new TreeSet<>();
//
//        tset.add(32);
//        tset.add(12);
//        tset.add(21);
//        tset.add(41);
//        tset.add(62);
//        tset.add(7);
//
//        System.out.println(tset); // [7, 12, 21, 32, 41, 62]
        // here everything will be same as above(hash set) except that here our elements will be sorted


        //******************************************************************************************************************************************************************************************************************************

        Set<Student> studentSet = new HashSet<>();

        studentSet.add(new Student("Ayush", 48));
        studentSet.add(new Student("Anuj", 21));
        studentSet.add(new Student("Ramesh", 45));
        studentSet.add(new Student("Anuj", 21));


        System.out.println(studentSet);
        // [Student{name='Ramesh', rollNo=45}, Student{name='Ayush', rollNo=48}, Student{name='Anuj', rollNo=21}, Student{name='Anuj', rollNo=21}]

// here both anuj have same name and roll number but still our hash set is showing both of them(i.e. showing duplicate values), the reason for this is that since we are using new Student() to make the object everytime both anuj are stored in different object that's why our hash set is treating them differently

        //after using @override for both equals and hascode for roll number now stdents with same roll number can not be present

        System.out.println(studentSet);
        // [Student{name='Anuj', rollNo=21}, Student{name='Ramesh', rollNo=45}, Student{name='Ayush', rollNo=48}]


        //.equals() [in student class] is telling us whether two objects are equal or not, based on the property we gave it to check on(in our case it is rollNo)

        Student s1 = new Student("ramesh", 2);
        Student s2 = new Student("kamlesh", 2);

        System.out.println(s1.equals(s2)); // true












    }

}
