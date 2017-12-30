public class Nat implements Filter<Integer> {
    public boolean check(Integer value){
        String num = Integer.toString(value);
        boolean res = true;

        for(int i = 0;i < num.length();i++){
            char c = num.charAt(i);
            if(c == '0' || c == '1' || c == '2' || c == '3' ||
            c == '4' || c == '5' || c == '6' || c == '7' ||
            c == '8' || c == '9'){
                res &= true;
            }else{
                res = false;
            }
        }
        return res;
    }
}
