package mySets;

import java.util.*;

abstract class MyAbstractSet <T> implements Iterable <T> {
    private MySetElement<T> head;

    public MyAbstractSet(){
        this.head = null;
    }

    MyAbstractSet(MySetElement<T> initialValue) {
        this.head = initialValue;
    }


    public MySetIterator<T> iterator(){
        return new MySetIterator(this.head);
        //{
        //     public boolean hasNext(){
        //         if(this.getFirst().getNext() != null){
        //             return true;
        //         }
        //         return false;
        //     }
        //
        //     public T next() throws UnsupportedOperationException{
        //         if(this.hasNext()){
        //             T temp = this.head.getValue();
        //             this.head = this.head.getNext();
        //             return temp;
        //         }else{
        //             throw new UnsupportedOperationException();
        //         }
        //     }
        //
        //     public void remove() throws UnsupportedOperationException{
        //         throw new UnsupportedOperationException();
        //     }
        // };
    }

    // implements all abstract methods except optional abstract methods
    public boolean contains(Object o){
        MySetIterator<T> it = this.iterator();
        boolean res = false;
        while(it.hasNext()){
            res |= it.next().equals(o);
        }
        return res;
    }

    public boolean containsAll(Collection<?> c) {
        boolean res = true;
        for(Object x : c){
            res = res && this.contains(x);
        }
        return res;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        // if(this.isEmpty()){
        //     return 0;
        // }else{
        //     this.head = this.head.getNext();
        //     return 1 + this.size();
        // }
        int res = 0;
        for(Iterator<T> it = this.iterator();it.hasNext();it.next()){
            res++;
        }
        return res;
    }

    public String toString(){
        String str = "";
        for(Object obj : this){
            str += obj.toString();
        }
        return str;
    }

    public Object[] toArray() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] a) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    MySetElement<T> getHead() {
        return this.head;
    }

    void setHead(MySetElement<T> head) {
        this.head = head;
    }
}
