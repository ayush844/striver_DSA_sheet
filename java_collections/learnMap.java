import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class learnMap {

    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();

        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);

        System.out.println(numbers); // {One=1, Four=4, Two=2, Three=3}

        // we can not insert values with similar key, if we do so the value of that wil be overwritten
        numbers.put("Two", 22);

        System.out.println(numbers); // {One=1, Four=4, Two=22, Three=3}

        // here we can also check before inserting if the key already exist

        if(!numbers.containsKey("Two")){
            numbers.put("Two", 222);
        }

        // OR

        numbers.putIfAbsent("Five", 55);

        System.out.println(numbers); // {Five=55, One=1, Four=4, Two=22, Three=3}


        // to check if a value is present or not

        System.out.println(numbers.containsValue(22)); // true

        // for looping in the map

        for (Map.Entry<String, Integer> e: numbers.entrySet()){
            System.out.print(e + " ");

            System.out.print(e.getKey() + " ");
            System.out.print(e.getValue() + " ");

            System.out.println();
        }

        //Five=55 Five 55
        //One=1 One 1
        //Four=4 Four 4
        //Two=22 Two 22
        //Three=3 Three 3


        //if we only want to iterate in keys

        for (String key: numbers.keySet()) {
            System.out.print(key + " ");
        }
        // Five One Four Two Three


        System.out.println();


        //if we only want to iterate in values

        for (Integer value : numbers.values()) {
            System.out.print(value + " ");
        }
        // 55 1 4 22 3


        System.out.println();

        // to check if map is empty or not

        System.out.println(numbers.isEmpty()); // false


        //******************************TREE MAP ******************************

        Map<String, Integer> treeNumbers = new TreeMap<>();

        treeNumbers.put("One", 1);
        treeNumbers.put("Two", 2);
        treeNumbers.put("Three", 3);
        treeNumbers.put("Four", 4);

        System.out.println(treeNumbers); // {Four=4, One=1, Three=3, Two=2}
        //it get sorted in alphabatical order of keys

        treeNumbers.remove("Three");

        System.out.println(treeNumbers);
        // {Four=4, One=1, Two=2}

        // here everything will be same as above(hash map) except that here our elements will be sorted


    }

}
