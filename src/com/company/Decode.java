/*
JAMES NGUYEN
820268781
Monday/Wednesday 5:30pm
*/
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

public class Decode {

    public Queue decode(ArrayList<ArrayList<Integer>> pattern, Queue value) {

        int noise = 0;
        int set = 6;

        ArrayList<Integer> weaponCode = getWeaponCode(pattern);
        Queue output = new Queue();

        while(!value.isEmpty()) {
            value.normalize();
            int[] target = value.peek(set);
            Integer[] array = new Integer[set];

            for(int i = 0; i <= set - 1; i++){
                array[i] = target[i];
            }

            for(int i = 0; i <= pattern.size() - 1; i++){
                if(Arrays.asList(array).containsAll(pattern.get(i))){
                    dequeueOneNoise(value);
                    System.out.println("PATTERN FOUND");
                    output.loadValue(weaponCode.get(i));
                }
                else{
                    System.out.println("NO PATTERN");
                }
            }
        }
        return output;
    }

    private void dequeueMultiNoise(Queue values){
        for(int i = 1 ; i <= 7 ; i++){
            values.nextValue();
        }
    }

    private void dequeueOneNoise(Queue values){
        for(int i = 1; i <= 6; i++){
            values.nextValue();
        }
    }

    private void dequeue(Queue values){
        values.nextValue();
    }

    private ArrayList<Integer> getWeaponCode(ArrayList<ArrayList<Integer>> pattern){
        ArrayList<Integer> weaponCode = new ArrayList<>();

        for(int i = 0; i <= pattern.size() - 1; i++){
            weaponCode.add(pattern.get(i).get(pattern.get(i).size() - 1));
            pattern.get(i).remove(pattern.get(i).size() - 1);
        }
        return weaponCode;
    }

}


