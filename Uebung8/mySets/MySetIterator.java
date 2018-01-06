package mySets;

import java.util.Iterator;

class MySetIterator <T> implements Iterator <T>{
    private MySetElement<T> current;
    private MySetElement<T> successor;

    public MySetIterator(){
        this.current = null;
        this.successor = null;
    }

    MySetIterator(MySetElement<T> initialSetElement){
        this.current = initialSetElement;
        this.successor = null;
    }

    public boolean hasNext(){
        return this.current != null;
    }

    public T next() throws UnsupportedOperationException{
        if(this.hasNext()){
            T temp = this.current.getValue();
            this.successor = this.current;
            this.current = this.current.getNext();
            return temp;
        }else{
            throw new UnsupportedOperationException();
        }
    }

    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public MySetElement<T> getCurrent(){
        return this.current;
    }

    public MySetElement<T> getSuccessor() {
        return this.successor;
    }

    public MySetElement<T> getPrevious(Object value){
        MySetElement<T> previous = null;
        while(this.hasNext()){
            MySetElement<T> next = this.current.getNext();
            if(next != null && next.getValue().equals(value)){
                previous = this.current;
                break;
            }
            this.current = next;
        }
        return previous;

        // another implementation
        /**
        * while(this.hasNext()){
        *   T next = this.next();
        *   if(next != null && next.equals(value)){
        *       return this.getSuccessor();
        *   }
        * }
        * return null; // previous MySetElement of Object value not found
        */
    }

    public static void main(String[] args){

        }

}
