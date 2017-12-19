package mySets;

public class test{
    public static void main(String[] agrs){
        MyMutableSet<String> a = new MyMutableSet<>();
        a.add("3");
        a.add("2");
        a.add("1");
        a.add("0");

        MyMutableSet<String> b = new MyMutableSet<>();
        b.add("3");
        b.add("2");
        b.add("1");
        b.add("123");

//        for(String str : b){
//            System.out.println(str);
//        }

        a.removeAll(b);
        for(String str : a){
            System.out.println(str);
        }

    }
}
