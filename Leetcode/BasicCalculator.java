import java.util.Stack;

public class BasicCalculator {
    public static int calculator(String expression){
        if(expression == null){
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        int num = 0;
        int nach = 0;
        int vor = 0;
        int sign = 1;
        int length = expression.length();

        //initializing
        stk.push(res);
        stk.push(sign);

        for(int i = 0;i < length;i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');

            }else if(c == '+'){
                if(num != 0){
                    stk.push(num);
                    num = 0;
                }

                nach = stk.pop();
                sign = stk.pop();
                vor = stk.pop();

                res = evaluate(vor, sign, nach);
                stk.push(res);

                sign = 1;
                stk.push(sign);

                res = 0;
                sign = 1;
            }else if(c == '-'){
                if(num != 0){
                    stk.push(num);
                    num = 0;
                }

                nach = stk.pop();
                sign = stk.pop();
                vor = stk.pop();

                res = evaluate(vor, sign, nach);
                stk.push(res);

                sign = -1;
                stk.push(sign);

                res = 0;
                sign = 1;
            }else if(c == '('){
                stk.push(res);
                stk.push(sign);
            }else if(c == ')'){
                if(num != 0){
                    stk.push(num);
                    num = 0;
                }

                nach = stk.pop();
                sign = stk.pop();
                vor = stk.pop();
                if (sign == 1){
                    res = vor + nach;
                    stk.push(res);
                }else if (sign == -1){
                    res = vor - nach;
                    stk.push(res);
                }
                res = 0;
                sign = 1;
            }
        }

        if(num != 0){
            stk.push(num);
        }
        if(!stk.isEmpty()){
            nach = stk.pop();
            sign = stk.pop();
            vor = stk.pop();
            if (sign == 1){
                res = vor + nach;
            }else{
                res = vor - nach;
            }
        }
        return res;
    }

    private static int evaluate(int vor, int operator, int nach){
        switch(operator){
            case 1:
                return vor + nach;
            case -1:
                return vor - nach;
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(BasicCalculator.calculator("(((1+(2+3)+4+6)-(10)+100)-6)+7"));
    }
}
