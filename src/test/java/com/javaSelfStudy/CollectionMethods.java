package com.javaSelfStudy;

import java.util.*;

public class CollectionMethods {

    public static void main(String[] args) {


    Collection<Integer> coll = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,7));
        System.out.println(coll);

        Iterator<Integer> myIter = coll.iterator();
    //hasNext()
        System.out.println(myIter.hasNext()); //true

        //next()
        System.out.println(myIter.next());


        //remove;

        while(myIter.hasNext()){
            if (myIter.next()>6){
                myIter.remove();

            }
        }

        System.out.println(coll);

        List<Integer> ls =new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,77,9));

        System.out.println(ls);
        System.out.println(ls.size());
        System.out.println(ls.get(1));
        System.out.println(ls.add(10));
        System.out.println(ls.addAll(Arrays.asList(90,78,56)));
        System.out.println(ls);

    }
}
