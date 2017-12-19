package mySets;

import java.util.*;
public class MyMutableSet<T> extends MyAbstractSet<T> implements Set<T> {

    public MyMutableSet(){
        super(null);
    }

    @Override
    public boolean add(T t){
        if(!super.contains(t)){
            super.setHead(new MySetElement(t, super.getHead()));
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c){
        boolean res = false;
        for(T x : c){
            if(!super.contains(x)){
                this.add(x);
                res = true;
            }
        }
        return res;
    }

    public void clear(){
        super.setHead(null);
    }

    public boolean remove(Object o){

        if(super.contains(o)){

//            ArrayList<T> arraylist = new ArrayList<>();
//            Stack<T> stk = new Stack<>();
//            Iterator<T> it = super.iterator();
//            while(it.hasNext()){
//                arraylist.add(it.next());
//            }
//            arraylist.remove(o);
//
//            for(T t : arraylist){
//                stk.push(t);
//            }
//
//            arraylist.clear();
//
//            super.setHead(null);
//
//            while(!stk.isEmpty()){
//                this.add(stk.pop());
//            }
//
//            return true;
            MySetIterator<T> it = super.iterator();
            // wenn it.getCurrent().equals(o) is true, then the previous element is null
            if(it.getCurrent().equals(o)){
                super.setHead(it.getCurrent().getNext());
            }else{
//                MySetElement<T> tmp = it.getPrevious(o);
//                tmp.setNext(tmp.getNext().getNext());
                while(it.hasNext()){
                    MySetElement<T> temp = it.getCurrent();
                    MySetElement<T> successor = it.getSuccessor();
                    if(temp.getValue().equals(o)){
                        successor.setNext(temp.getNext());
                    }
                    it.next();
                }
            }


        }
        if(o == null){
            throw new NullPointerException();
        }
        return false;
    }

    public boolean removeAll(Collection<?> c){
        if(c == null){
            throw new NullPointerException();
        }
        boolean res = false;
        for(Object obj : c){
            res |= this.remove(obj);
        }
        return res;
    }

    public boolean retainAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
}
