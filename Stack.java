import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public void pop() throws Exception;
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public int peek() throws Exception;
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(int element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack implements IStack {
    private int top = -1;
    private int max_size;
    private int[] stack_array;
    public MyStack(int size)
    {
        max_size = size+2;
        stack_array = new int[max_size];
    }
    public void pop() {
        if (top >= 0) {
             for (int i = 0; i < top; i++) {
            stack_array[i] = stack_array[i + 1];
        }
            top--;
        } else {
            throw new IllegalStateException("Error");
        }
    }
    public void push(int element) {
        
        if (top < max_size - 1) {
            top++;
            for (int i = top; i >= 0; i--) {
                stack_array[i + 1] = stack_array[i];
            }
            stack_array[0] = element;
        } else {
            throw new IllegalStateException("Error");
        }
    }
    public boolean isEmpty()
    {
        if(top >= 0)
        {
            return false;
        }else 
        {
            return true;
        }
    }
    public int size()
    {
        return top+1;
    }
    public int peek()
    {
       if(top >= 0)
        {
            return stack_array[0];
        }else 
        {
            throw new IllegalStateException("Error");
        }   
    }
    public void printStack() 
    {
        if (top >= 0) 
        {
            System.out.print("[");
            for (int i = 0; i <= top; i++) 
            {
                System.out.print(stack_array[i]);
                if (i < top) 
                {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }else 
        {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        MyStack stack = null;
        String sin = scanner.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int[] arr = new int[s.length];
        if(s.length == 1 && s[0].isEmpty())
        {
            arr = new int[]{};
        }else
        {
        stack = new MyStack(s.length);
            for(int i = s.length - 1;i >= 0 ;i--)
            {
                stack.push(Integer.parseInt(s[i]));
            }
        }
        
        String operation = scanner.nextLine().trim();

        switch(operation)
        {
            case "push":
            {
                stack.push(scanner.nextInt());
                stack.printStack();
                break;            
            }
            case "pop":
            {   
                stack.pop();
                stack.printStack();
                break;            
            }case "isEmpty":
            {
                if(stack.isEmpty())
                {
                    System.out.println("True");
                }else{
                    System.out.println("False");
                }
                break;            
            }case "size":
            {
                System.out.println(stack.size());
                break;            
            }case "peek":
            {   
                int peek_value = stack.peek();
                System.out.println(peek_value);
                break;            
            }default:
                System.out.println("Error");
                break;    
        }
    }
}