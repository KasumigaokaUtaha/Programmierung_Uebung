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
        MySetElement<T> tmp = null;
        while(this.hasNext()){
            MySetElement<T> next = this.current.getNext();
            if(next != null && next.getValue().equals(value)){
                tmp = this.current;
                break;
            }
            this.current = next;
        }
        return tmp;
    }

    public static void main(String[] args){

        }

}
