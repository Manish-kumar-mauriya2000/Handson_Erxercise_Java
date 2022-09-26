package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise3 {
    static Logger logger=Logger.getLogger(Exercise3.class.getName());
    public static void main(String[] args){

        String infix="((2+3)*8+5+3)*6";
        logger.log(Level.INFO,"postfix Expression : {0}",toPostfix(infix));

    }
    private static String toPostfix(String infix){
        Deque<Character> operatorStack= new ArrayDeque<>();
        char symbol;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i <infix.length(); i++) {
            symbol=infix.charAt(i);
            if(Character.isLetterOrDigit(symbol)){
                postfix.append(symbol);
            }
            else if(symbol=='(') {
                operatorStack.push(symbol);
            }
            else if(symbol==')'){
                while(operatorStack.peek()!='('){
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();
            }
            else{
                while(!operatorStack.isEmpty() && (operatorStack.peek()!='(')&& precedence(symbol)<=precedence(operatorStack.peek()))
                    postfix.append(operatorStack.pop());
                operatorStack.push(symbol);
            }
        }
        while (!operatorStack.isEmpty())
            postfix.append(operatorStack.pop());

        return postfix.toString();
    }

    static int precedence(char x){
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
}
