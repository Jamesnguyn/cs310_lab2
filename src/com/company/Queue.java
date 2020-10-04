/*
JAMES NGUYEN
820268781
Monday/Wednesday 5:30pm
*/
package com.company;

import java.lang.Integer;
import java.util.LinkedList;

public class Queue {

    private LinkedList<Integer> data = new LinkedList<>();

    public boolean isEmpty(){//Returns true when the queue holds zero items.
        if( data.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void loadValue(int val){//Inserts a value into the queue. Analogous to enqueue
        data.add(val);
    }

    public int nextValue(){//Removes the first item from the queue. Analogous to dequeue. Returns -1 if the queue is empty when called.
        if(data.isEmpty()){
            return -1;
        }
        return data.remove();
    }

    public void normalize(){//Subtracts the value of the first item in the queue from everything remaining.
        for(int i = 0; i <= data.size()-1; i++){
            int result = data.get(i) - data.getFirst();
            data.set(i,result);
        }
    }

    public int[] peek(int num){//Supplies the caller with an array of the next num values.
        int[] array = new int[num];
        for(int i = 0; i < num; i++){
            array[i] = data.get(i);
        }
        return array;
    }

    public int size(){//Reports the number of items currently held in the queue.
        return data.size();
    }
}

