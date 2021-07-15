package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDeque <Glorp>{
    private Glorp[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (Glorp[])new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = items.length - 1;
    }
    private void resize(int cap){
        Glorp[] list = (Glorp[] )new Object[cap];
        System.arraycopy(item, 0 , list, 0, size);
        item = list;
    }
    public void addFirst(Glorp item){

    }
    public void addLast(Glorp item){
        if(size == items.length){
            resize(size * 2);
        }
        item[nextLast] = item;
        nextLast = ;
        size++;
    }
    public int size(){
        return size;
    }
    public T removeFirst(){}
    public T removeLast(){}
    public T get(int index){}
}