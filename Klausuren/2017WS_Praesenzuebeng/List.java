import java.util.*;
public class List {
    Element head;

    // Teilaufgabe a
    public boolean contains(int n){
        if(this.head != null){
            return this.head.contains(n);
        }else{
            return false;
        }
    }

    // Teilaufgabe c
    public LinkedList<Integer> copyElements() throws DuplicateFoundException {
        LinkedList<Integer> linkedlist = new LinkedList();
        Element current = this.head;

        while(current != null){
            if(!linkedlist.contains(current.value)){
                linkedlist.add(current.value);
            }else{
                throw new DuplicateFoundException(current.value);
            }
            current = current.next;
        }
        return linkedlist;
    }

    // Teilaufgabe d
    public LinkedList<Integer> copyAndPrint(List l){
        LinkedList<Integer> linkedlist;
        try{
             linkedlist = this.copyElements();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        String res = "";
        for(Integer i : linkedlist){
            res += i + " ";
        }
        System.out.println(res);
        return linkedlist;
    }

    // Teilaufgabe g
    public void apply(Filter<T> filter){
        if(this.head != null){
            this.head = this.head.apply(filter);
        }
    }
}
