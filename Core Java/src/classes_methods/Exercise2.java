package classes_methods;

import java.util.logging.Level;
import java.util.logging.Logger;

class Stack{
    static final Logger logger=Logger.getLogger(Stack.class.getName());
    private int[] arr;
    private int capacity;
    private int top;

    Stack(int size){
        arr = new int[size];
        capacity = size;
        top=-1;
    }

    public void push(int x){
        if(top==capacity-1){
            logger.info("Stack Overflow");
        }
        logger.log(Level.INFO,"Inserting {0}",x);
        arr[++top]=x;
    }

    public int pop(){
        if(top==-1){
            logger.info("Stack Underflow");
        }
        logger.log(Level.INFO,"One element popped is {0}",arr[top]);
        return arr[top--];
    }

    public void display(){

        for(int i=0;i<top+1;i++){
            logger.log(Level.INFO,"{0}",arr[i]);
        }

    }

}
public class Exercise2 {
    public static void main(String[] args){
        Stack s = new Stack(4);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(10);
        s.pop();
        s.display();
    }
}
