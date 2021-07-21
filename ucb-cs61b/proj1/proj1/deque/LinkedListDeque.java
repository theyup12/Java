package deque;

import org.junit.Test;
import static org.junit.Assert.*;
public class LinkedListDeque<T> implements Deque<T>{
    public class Node{
        public T item;
        public Node next;
        public Ndoe prev;

        public Node(Node prev, T item,Node next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    //circular Sentinel;
    //only use one sentinel and point back
    //sentinel should be always empty
    private Node sentinel;
    private int size;

    //using two sentinel;
//    private Node last;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        //two sentinel case
//        sentinel = new Node(null, null, last);
//        last = new Node(sentinel, null, null);


        size = 0;
    }
    public void addFirst(T item){
        //create a new node to store item
        //prev point to the sentinel
        //next point to the sentinel next
        //newNode should be between it
        Node newNode = new Node(sentinel, item, sentinel.next);
        //set prev
        sentinel.next.prev = newNode;
        //set as newNode;
        sentinel.next = newNode;
        size++;

        //two sentinel case
//        Node newNode = new Node(sentinel, item, sentinel.next);
//        if(sentinel.next == last) {
//            sentinel.next = newNode;
//            last.prev = newNode;
//        }else{
//            sentinel.next = newNode;
//            last.prev.prev = newNode;
//        }
//        size++;
    }
    public void addLast(T item){
        Node newNode = new Node(sentinel.prev , item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void PrintDeque(){
        Stystem.out.println("LinkList: ");
        Node<T> cur = sentinel.next;
        while (cur != sentinel){
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
    }
    public T removeFirst(){
        if(sentinel.next != sentinel){
            T val = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return val;
        }
        return null;
    }
    public T removeLast(){
        if(sentinel.next != sentinel){
            T val = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size==;
            return val;
        }
        return null;
    }
    public T get(int index){
        int count = 0;
        Node<T> cur = sentinel.next;
        while(count <= index && cur != sentinel){
            if(count == index){
                return cur.item;
            }
            cur = cur.next;
            count++;
        }
        return null;
    }

    public T getRecursive(int index){
        Node<T> cur = sentinel.next;
        return gethelper(cur, index);
    }
    public T gethelper(Node<T> cur, int index){
        if(index == 0){
            return cur.item;
        }
        gethelper(cur.next, index - 1);
    }
    public static void main(String[] args){
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();

    }
}