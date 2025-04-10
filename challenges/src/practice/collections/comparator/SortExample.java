package practice.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class SortExample {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(35);
        intList.add(10);
        System.out.println(intList);

        Collections.sort(intList);
        System.out.println(intList);

        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp("Suresh","83319",3));
        emps.add(new Emp("Susan","832349",1));
        emps.add(new Emp("Harka","7483",2));

        System.out.println(emps);   // Print hashcode if ToString() is not override in Emp class

        // Collections.sort(emps);  -- gives error as the object type cannot use comparable

        //comparator  -- multiple sorting logics
        Collections.sort(emps, new IdComparator());
        System.out.println(emps);


        ArrayList<Emp> emps1 = new ArrayList<>(emps);

        Collections.sort(emps1,new NameComparator());

        System.out.println(emps1);
    }
}
