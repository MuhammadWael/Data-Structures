import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returnsit.*/
  public void dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
  
  public void printQueue();
}

public class ArrayQueue implements IQueue {

    int arraySize = 50;
    public int[] array = new int[arraySize];
    int f = arraySize-1;
    int r = arraySize-1;
    int count =0;
    static ArrayQueue obj = new ArrayQueue();
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] line1 = line.replaceAll("\\[|\\]", "").split(", ");
        String line2 = reader.nextLine();
        String line3 = null;
        int line3int = 0;
        if (line2.equals("enqueue")) {
            line3 = reader.nextLine();
             line3int = Integer.parseInt(line3);
        }
        
        
        if (line1.length == 0){
            System.out.println("Error");
            System.exit(0);
        }
        if (!line.equals("[]")){
        for(int i=line1.length;i>0;i--){
        obj.enqueue(Integer.parseInt(line1[i-1]));
        }}
        
        
        
        switch (line2){
            case "enqueue":
                if (obj.f <0){
                System.out.println("Error");
                System.exit(0);
                }
                obj.enqueue(line3int);
                obj.printQueue();
                break;
            case "dequeue":
                if (obj.count <= 0){
                System.out.println("Error");
                System.exit(0);
                }
                obj.dequeue();
                obj.printQueue();
                break;
            case "isEmpty":
                if (obj.isEmpty()){
                System.out.println("True");
                }else{
                System.out.println("False");
                }
                break;
            case "size":
                System.out.println(obj.size());
                break;
        }
    }

    @Override
    public void enqueue(Object item) {
        this.array[f]=(int) item;
        f -=1;
        this.count +=1;
    }

    @Override
    public void dequeue() {
        
        r -=1;
        this.count -=1;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public int size() {
        return this.count ;
        /* return this.r - this.f + 1; */
    }
    @Override
    public void printQueue(){
        System.out.print("[");
        if (this.count >0){
        for (int i = f+1;i < (f + 1 + this.count);i++) {
            System.out.print(this.array[i]);
            if (i != f+1+ this.count-1) {
                System.out.print(", ");
            }
            }}
        System.out.print("]");
    }
}
