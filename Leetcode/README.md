#BasicCalculator
支持非负整数以及空格，括号。
##思路：
    Initializing：
        stk.push(0);
        stk.push(1);
        如果算数表达式只有一个数字，那么同样需要进行运算，但是没有运算符和运算符前面的操作数，所以需要人工补充。

    遇到运算符时，数字读取结束。进行运算，把res压入Stack。
    遇到"("的时候，stk.push(0），stk.push(1)。同样是为了满足括号内只有一个数字的情况。
    遇到")"的时候，stk.pop() X 3。然后计算，把res压入Stack。

    循环结束：
        stk.pop() X 3，计算，返回res。
