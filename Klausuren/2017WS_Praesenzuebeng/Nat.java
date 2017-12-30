public class Nat implements Filter<Integer> {
    public boolean check(Integer value){
        return value >= 0;
    }
}
