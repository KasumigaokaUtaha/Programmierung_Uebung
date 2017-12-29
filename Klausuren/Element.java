public class Element<T> {
    // Teilaufgabe c
    T value;
    Element<T> next;

    public void apply(Updater<T> updater, Element<T> head){
        this.value = updater.update(this.value);
        if(this.next != head){
            this.next.apply(updater, head);
        }
    }
}
