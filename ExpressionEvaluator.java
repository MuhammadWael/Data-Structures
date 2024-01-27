import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
/**
 * A class that makes a Single Linked List and provides its valid operations
 * @author Mkario Michel
 * @version 1.1
 */
class SingleLinkedList {
		
		/**
		* A class that makes a node
		* @author Mkario Michel
		* @version 1.0
		*/
        class Node{
            Object data;
            Node next;
            
            public Node(Object data){
                this.data = data;
            }
        }
        public Node head = null;
        public Node tail = null;
        public int size = 0;
        
        /**
        * A class that prints the Single Linked List
        */
	    public void print(){
	        Node current = head;
	        while(current != null){
	            System.out.print(current.data);
	            current = current.next; 
	        }
	    }
	    
	    //method 1
	    /*
	     * Inserts a specified element at the specified position in the list.
	     * @param index
	     * @param element
	     */     
	    public void add(int index , Object data){
	        Node New = new Node(data);
	        if(head == null && index == 0){
	            head = New;
	            tail = New;
	        }
	        else if( index < 0 || index > size || (head == null && index != 0)){
	                System.out.println("Error");
	                System.exit(0);
	            }
	        else if (index == 0 && head != null ){
	            New.next = head;
	            head = New;
	        }
	        else{
	            Node current = head;
	            for(int i = 0 ; i < index-1 ; i ++ ){
	                current = current.next;
	            }
	            New.next = current.next;
	            current.next = New;
	        }
	        size++;
	    }
        
	    // method 2
	    /*
	    * @param index
	    * @return the element at the specified position in this list.
	    */
     	public Object get(int index){
            if(index < size && index >= 0 && head != null){
                Node current = head;
                for(int i = 0 ; i < index ; i ++ )
                {
                    current = current.next;
                }
                return current.data;
            }
            else {
                System.out.println("Error");
                System.exit(0);
            }
            return 0;
        }
     	
     	//method 3
     	/*
     	* Removes all of the elements from this list.
     	*/
        public void clear(){
            head = null;
            tail = null;
            size = 0;
        }
        
        //method 4
        /*
        * @return true if this list contains no elements.
        */
        public boolean isEmpty(){
            return head==null;
        }
        
        //method 5
        /*
        * Removes the element at the specified position in this list.
        * @param index
        */
        public void remove(int index){
            Node current = head;
            if(index == 0 && head != null){
                head = current.next;
            }
            else if (index < size && head != null && index > 0){
                Node temp = null;
                for(int i = 0; i < index; i++){
                    temp = current;
                    current = current.next;
                }
                temp.next = current.next;
            }
            else{
                System.out.print("Error");
                System.exit(0);
            }
            size--;
        }
        
        //method 6
        /*
        * @return the number of elements in this list.
        */
        public int size(){
            return size;
        }
}
interface IStack 
{
/**
* Removes the element at the top of stack and returns that element.
* @return top of stack element, or through exception if empty
*/
public Object pop();
/**
* Get the element at the top of stack without removing it from stack.
* @return top of stack element, or through exception if empty
*/
public Object peek();
/**
* Pushes an item onto the top of this stack.
* @param object to insert
*/
public void push(Object element);
/**
* Tests if this stack is empty
* @return true if stack empty
*/
public boolean isEmpty();
/**
 * @return the size of the stack
 */
public int size();
}

/**
 * A class that makes a Stack and provides its valid operations
 * @author Mkario Michel
 * @version 1.0
 */
class Stack implements IStack {

	//method 1
	/**
	* Removes the element at the top of stack and returns that element.
	* @return top of stack element, or through exception if empty
	*/
    public static SingleLinkedList Stack = new SingleLinkedList();
    public Object pop() 
    {
        Object temp = Stack.get(0);
        int index = 0;
        Stack.remove(index);
        
        return temp;
    }

    //method 2
    /**
    * Get the element at the top of stack without removing it from stack.
    * @return top of stack element, or through exception if empty
    */
    public Object peek() 
    {
        if (Stack.isEmpty())
        {
            System.out.println("Error");
            System.exit(0);
        }
        return Stack.get(0);
    }
    
    //method 3
    /**
    * Pushes an item onto the top of this stack.
    * @param object to insert
    */
    public void push(Object element) 
    {
        int index = 0;
        Stack.add(index,element);
    }
    
    // method 4
    /**
    * Tests if this stack is empty
    * @return true if stack empty
    */
    public boolean isEmpty() 
    {
        return Stack.isEmpty();
    }
    
    //method 5
    /**
     * @return the size of the stack
     */
    public int size() 
    {
        return Stack.size();
    }
    
}
interface IExpressionEvaluator {
  
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param infix infix expression
* @return postfix expression
*/
  
public String infixToPostfix(String infix);
  
  
/**
* Evaluate a postfix numeric expression, with a single space separator
* @param postfix postfix expression
* @return the expression evaluated value
*/
  
public int evaluate(String postfix);

}

/**
 * class that takes a symbolic infix expression as input and converts it to postfix notation, enter the values of each symbol,
 * evaluates the postfix expression and outputs the resulting expression and its value. 
 * @author Mkario Michel
 * @version 1.0
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
    
    public static Stack St = new Stack();
    public static int a;
    public static int b;
    public static int c;
    
    // method 1
    /**
    * Takes a symbolic/numeric infix expression as input and converts it to
    * postfix notation. There is no assumption on spaces between terms or the
    * length of the term (e.g., two digits symbolic or numeric term)
    *
    * @param infix infix expression
    * @return postfix expression
    */
    public String infixToPostfix(String infix) {
        
        char value ;
        String postfix = "";
        for(int i=0; i<infix.length(); i++)              //while there is input to be read      
        {  
            value = infix.charAt(i);
            if (value == 'a' || value == 'b' || value == 'c')  
            {
                postfix = postfix + value;
            }
            else if (value == '(')                    // push '('
            {      
                St.push(value);
            }
            else if (value == ')')                      //push everything back to      
            {  
                while (!(St.isEmpty()) && (char)St.peek() != '(')  
                { 
                    postfix = postfix + St.pop();                    // pop hna m4 4rt n7wlha 
                } 
                St.pop();                                // remove '('
            }
            else                                      //print operators occurring before it that have greater precedence  
            {                 
                while ((!(St.isEmpty())) && ((char)St.peek()!='(') && (prec(value) <= prec((char)St.peek())))
                {
                    postfix = postfix + St.pop();          
                }
                St.push(value);
            }
        }
        while (!(St.isEmpty()))  
        {
            postfix = postfix + St.pop();            
        }
        return postfix;
    }

    //method 2
    /**
    * Evaluate a postfix numeric expression, with a single space separator
    * @param postfix postfix expression
    * @return the expression evaluated value
    */
    public int evaluate(String postfix) {
        

        Stack val = new Stack();
        char value ;
        for(int i =0; i<postfix.length(); i++)
        {
            value = postfix.charAt(i);
            if(value == 'a' || value == 'b' || value == 'c' )
            {
                switch(value)
                {
                    case 'a':
                    val.push(a);
                    break;
                    
                    case 'b':
                    val.push(b);
                    break;
                    
                    case 'c':
                    val.push(c);
                    break;
                }
            }
            else 
            {
                boolean temp = false;
                if(val.size()==1)
                {
                    temp = true;
                }
                int val1 = (int) val.pop();
                int val2 = 0;
                if(temp == false)
                    val2 = (int) val.pop();
                 
                switch(value)
                {
                    case '+':
                    val.push(val2+val1);
                    break;
                     
                    case '-':
                    if(temp)
                        val.push((-1*val1));
                    else  
                        val.push(val2- val1);
                    break;
                     
                    case '/':
                    val.push(val2/val1);
                    break;
                     
                    case '*':
                    val.push(val2*val1);
                    break;
                    
                    case '^':                               // important
                    double x = Math.pow(val2,val1);
                    val.push((int)x);
                    break;
              }
            }
        }
        return (int) val.pop();           
        }
        
        
    
    // precedence method 
    /**
     * A method to check the precedence of the operator
     * @param x : the operator to be checked
     * @return a value indicates the precedence
     */
    static int prec(char x)  
    {  
        if (x == '+' || x == '-')  
        return 1;  
        if (x == '*' || x == '/')  
        return 2; 
        if(x == '^')
        return 3;
        return 0;  
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ExpressionEvaluator express = new ExpressionEvaluator();
        
        Stack brackets = new Stack(); 
        
        // taking the inputs 
        String expression = input.next();                        ///////// next bs
        
        String aaa = "input.nextLine()";
        aaa = input.next();
        String bbb = "input.nextLine()";
        bbb = input.next();
        String ccc = "input.nextLine()";
        ccc = input.next();
        
        String aa = aaa.substring(2);
        String bb = bbb.substring(2);
        String cc = ccc.substring(2);
        
        a = Integer.parseInt(aa);
        b = Integer.parseInt(bb);
        c = Integer.parseInt(cc);
        
        
        // handling the operators in the first
        if (expression.charAt(0) == '*' || expression.charAt(0) == '/' || expression.charAt(0) == '^')
        {
            System.out.println("Error");
            System.exit(0);
        }
        
        // handling the -- 
        for (int i =0; i< expression.length()-1 ; i++)
        {
            if (expression.charAt(i) == '-' && expression.charAt(i+1) == '-')                    
            {                
                 expression = expression.substring(0,i) + "+" + expression.substring(i+2);
            }
                
        }
        
        // handling the ^+ case
        for (int i =0; i< expression.length()-1 ; i++)
        {
            if (expression.charAt(i) == '^' && expression.charAt(i+1) == '+')
            {
                expression = expression.substring(0,i+1) + expression.substring(i+2);
            }  
        }
        
        // checking if there are 2 consecutive operators 
        for (int i =0; i< expression.length()-1 ; i++)
        { 
            if (expression.charAt(i) != 'a' && expression.charAt(i) != 'b' && expression.charAt(i) != 'c'  && expression.charAt(i) != '(' && expression.charAt(i) != ')' && expression.charAt(i+1) != 'a' && expression.charAt(i+1) != 'b' && expression.charAt(i+1) != 'c' && expression.charAt(i+1) != '(' && expression.charAt(i+1) != ')' )
            {
                System.out.println("Error");
                System.exit(0);                
            }
        }
       
        // checking if the value is out of range
        for (int i =0; i< expression.length() ; i++)
        {
            if (expression.charAt(i) != 'a' && expression.charAt(i) != 'b' && expression.charAt(i) != 'c' && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) != '^' && expression.charAt(i) != '(' && expression.charAt(i) != ')')
            {
                System.out.println("Error");
                System.exit(0);
            }
        }
       
        // checking pairs of brackets
        char bracket = '(';                                        
        for (int i =0; i< expression.length() ; i++)
        {
            if(expression.charAt(i) == '(')
            {
                brackets.push(bracket);
            }
            else if (expression.charAt(i) == ')')
            {
                brackets.pop();
            }
        }
        if( !(brackets.isEmpty()))
        {
            System.out.println("Error");
            System.exit(0);
        }
       
        // removing any + in the first
        if (expression.charAt(0) == '+')
        {
            expression = expression.substring(1,expression.length());
        }
       
        // checking if there is a operator in the end
        if(expression.charAt(expression.length()-1) != 'a' && expression.charAt(expression.length()-1) != 'b' && expression.charAt(expression.length()-1) != 'c'  &&  expression.charAt(expression.length()-1) != ')' )
        {
            System.out.println("Error");
            System.exit(0);
        }
        
        // driver code
        String postfix = express.infixToPostfix(expression);
        int result = express.evaluate(postfix);
        System.out.println(postfix);
        System.out.println(result);
        
        
    }
}


