package mySets;

class MySetElement <T> {
    private MySetElement<T> next;
    private T value;

    public MySetElement(T value){
        this.next = null;
        this.value = value;
    }

    MySetElement(T value, MySetElement<T> next){
        this.next = next;
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public MySetElement<T> getNext() {
        return this.next;
    }

    public void setNext(MySetElement<T> next){
        this.next = next;
    }

//    public boolean equals(Object o){
//        boolean res = false;
//        if(this == o){
//            res = true;
//        }
//
//        if(o == null){
//            res = false;
//        }
//
//        if(this.getClass() != o.getClass()){
//            res = false;
//        }
//
//        MySetElement<T> tmp = (MySetElement<T>) o;
//
//        res = this.getValue().equals(tmp.getValue()) && this.getNext().equals(tmp.getNext());
//
//        return res;
//    }

    public String toString(){
        return value.toString();
    }

    public static void main(String[] args){
        MySetElement test = new MySetElement("1234.2312", null);
        System.out.println(test.getValue());
    }
}
