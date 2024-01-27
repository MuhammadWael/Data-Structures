import java.util.Scanner;

interface IQueue {
    /*** Inserts an item at the queue rear.*/
    void enqueue(int item);

    /*** Removes the object at the queue front and returns it.*/
    int dequeue();

    /*** Tests if this queue is empty.*/
    boolean isEmpty();

    /*** Returns the number of elements in the queue*/
    int size();
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue implements IQueue {
    private Node front, rear;
    private int size;

    public LinkedListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

      @Override
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }
    
    @Override
    public int dequeue() {
        int dequeuedItem = rear.data;
        Node current = front;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        if (previous != null) {
            previous.next = null;
        } else {
            front = rear = null;
        }

        size--;
        return dequeuedItem;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        
        if(s.length == 1 && s[0].isEmpty()){/*do nothing*/}  
        else{
            for (int i = s.length - 1; i >= 0; i--) {
                String element = s[i];
                linkedListQueue.enqueue(Integer.parseInt(element));
            }
        }

        // Performing operations
        String operation = sc.nextLine();
        switch (operation) {
            case "enqueue":
                int valueToEnqueue = sc.nextInt();
                linkedListQueue.enqueue(valueToEnqueue);
                printQueue(linkedListQueue.front);
                break;
            case "dequeue":
                if(sc.hasNextLine()) System.out.println("Error");
                else{
                    if (linkedListQueue.isEmpty()) {
                        System.out.println("Error");
                    } else {
                        linkedListQueue.dequeue();
                        printQueue(linkedListQueue.front);
                    }
                }
                break;
            case "isEmpty":
                if(sc.hasNextLine()) System.out.println("Error");
                else{
                    if(linkedListQueue.isEmpty() == false)  System.out.println("False");
                    else System.out.println("True");
                }
                break;
            case "size":
                if(sc.hasNextLine()) System.out.println("Error");
                else{
                    System.out.println(linkedListQueue.size());
                }
                break;
            default:
                System.out.println("Error");
        }

        
    }

    private static void printQueue(Node front) {
        Node current = front;
        StringBuilder result = new StringBuilder("[");
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        System.out.println(result);
    }
}
