public class Element {
    int value;
    Element next;

    public boolean contains(int n){
        if(this.value == n){
            return true;
        }else if(this.next == null){
            return false;
        }else{
            return this.next.contains(n);
        }
    }

    public Element apply(Filter<T> filter){
        if(filter.check(this.value)){
            if(this.next != null){
                return this.next.apply(filter);
            }else{
                return null;
            }
        }else{
            if(this.next != null){
                this.next = this.next.apply(filter);
            }
            return this;
        }
    }
}
