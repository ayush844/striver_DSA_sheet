import java.util.ArrayList;
import java.util.Iterator;

public class learningArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // an empty array will be formed in memory

        list.add(3);
        // as we add an element an array of 10 elements will be formed


        //if we require more size it will increase its size from n -> n + (n/2) + 1

        list.add(12);
        list.add(51);
        list.add(67);
        list.add(11);

        System.out.println(list);
        // [3, 12, 51, 67, 11]

        list.add(3, 99);

        System.out.println(list);
        // [3, 12, 51, 99, 67, 11]

        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(123);
        newList.add(234);
        newList.add(345);
        newList.add(456);

        // adding whole list to another list

        list.addAll(newList);

        System.out.println(list);
        // [3, 12, 51, 99, 67, 11, 123, 234, 345, 456]


        //to get an element of a specific index
        System.out.println(list.get(1)); //12


        // to remove a value

        // [3, 12, 51, 99, 67, 11, 123, 234, 345, 456]

        list.remove(1); //remove value at given index
        System.out.println(list);
        // [3, 51, 99, 67, 11, 123, 234, 345, 456]

        list.remove(Integer.valueOf(123)); // remove value 123
        System.out.println(list);
        // [3, 51, 99, 67, 11, 234, 345, 456]

//        list.clear(); // this will delete everything inside the list
//        System.out.println(list); // []



        // to update a value at a particular index
        list.set(1, 52);
        System.out.println(list);
        // [3, 52, 99, 67, 11, 234, 345, 456]



        // to know if a particular value is present inside the list
        System.out.println(list.contains(52)); // true



        //************************** for iterating in a list **************************

        //[3, 52, 99, 67, 11, 234, 345, 456]

        for (int i = 0; i < list.size(); i++){   //list.size() tells the number of element in array list
            System.out.println("the element is " + list.get(i));
        }

        //the element is 3
        //the element is 52
        //the element is 99
        //the element is 67
        //the element is 11
        //the element is 234
        //the element is 345
        //the element is 456



        for (int element : list){
            System.out.println("the element is " + element);
        }

        //the element is 3
        //the element is 52
        //the element is 99
        //the element is 67
        //the element is 11
        //the element is 234
        //the element is 345
        //the element is 456

//*******************************************************************************************************

        ArrayList<Integer> extraList = new ArrayList<>();

        extraList.add(10);
        extraList.add(20);
        extraList.add(30);
        extraList.add(40);
        extraList.add(50);
        extraList.add(60);
        extraList.add(70);

        //using Iterator

        Iterator<Integer> it = extraList.iterator();

        while (it.hasNext()){
            System.out.println("iterator " + it.next());
        }

        //iterator 10
        //iterator 20
        //iterator 30
        //iterator 40
        //iterator 50
        //iterator 60
        //iterator 70




    }

}
