public class List<T> {
    Element<T> head;

    // Teilaufgabe a
    public Element<T> last(){
        if(this.head == null){
            return null;
        }else{
            Element<T> current = this.head;
            while(current.next != this.head){
                current = current.next;
            }
            return current;
        }
    }

    // Teilaufgabe b
    public void add(T i){
        Element<T> toAdd = new Element();
        toAdd.value = i;
        if(this.head == null){
            this.head = toAdd;
        }else{
            Element<T> last = this.last();
            toAdd.next = last.next;
            last.next = toAdd;
        }
    }

    // Teilaugabe e
    public void apply(Updater<T> updater){
        this.head.apply(updater, this.head);
    }

    // Teilaufgabe f
    public T josephus(int x){
        Element<T> current = this.head;
        while(current != current.next){
            for(int i = 0;i < x - 2;i++){
                current = current.next;
            }
            // current is the x-1.Element
            current.next = current.next.next; // delete the x.Element
            current = current.next; // initializing current
        }
        return current.value;
    }
}
