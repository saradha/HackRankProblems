package com.saradha.hackrank.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PickingNumbers {

    public static void main(String[] args) {
        int a[] = {4, 6, 5, 3, 3, 1};
        List<Integer> input = Arrays.stream(a).boxed().collect(Collectors.toList()); // convert int array into list of Integer
        System.out.println(pickingNumbers(input));
    }

    public static int pickingNumbers(List<Integer> a) {
        int resultSize = 0;
        Collections.sort(a);                        //1,3,3,4,5,6
        List<Integer> result = new ArrayList<>();                //when i =0 result = 1 , 1-3 =  2 so not added in the list iterate through until 6 //resultsize=1  ,
        for (int i = 0; i < a.size(); i++) {                     // when i=1,j=2 result=3 , 3-3=0 . so a.j added in the result =3,3  iterate unti 6
            //when i=1,j=3 3-4 =1 , so a.j added in the result=3,3,4
            // when i = 1, j=4, 5-3 =2 false resultSize = 3 clear result
            // when i= 2 , j = 3  result 3,4 iterate until 5 but 3-5 = 2 so break result lengh 2 max(3,2) = 3
            result.add(a.get(i));
            for (int j = i + 1; j < a.size(); j++) {
                if (Math.abs(a.get(i) - a.get(j)) <= 1)
                    result.add(a.get(j));
            }
            resultSize = Math.max(resultSize, result.size());
            result.clear();
        }

        return resultSize;
    }
}
