import java.util.*;
import java.math.*;


interface ILinkedList 
{
	public void add(int index, Object element);
	public void add(Object element);
	public Object get(int index);
	public void set(int index, Object element);
	public void clear();
	public boolean isEmpty();
	public void remove(int index);
	public int size();
	public ILinkedList sublist(int fromIndex, int toIndex);
	public boolean contains(Object o);
}

class DoubleNode
{
	Object data;
	DoubleNode prev;
	DoubleNode next;
}

public class DoubleLinkedList implements ILinkedList 
{
   DoubleNode head;
   DoubleNode tail;
   
    public  void show() 
	{
        DoubleNode n = head;
        int i=0, j = size();
        
        System.out.print("[");
        
        while(n != null) 
		{
            System.out.print(n.data);
            if(i != j-1)
			{
                System.out.print(", ");
                i++;
            }
            n=n.next;
        }
        System.out.print("]");
    }
      
  
	public void add(Object element) 
	{
		DoubleNode node = new DoubleNode();
		node.data = element;
		if(size()==0) 
		{
			head=tail=node;
			node.next=node.prev=null;
		}
		else 
		{
			node.next=null;
			node.prev=tail;
			tail.next=node;
			tail=node;
		}
	}
  
    public void add(int index, Object element)
    {
		if(index<0)
			throw new NullPointerException();
		
		DoubleNode node = new DoubleNode();
		node.data = element;
		node.next = node.prev = null;
	
	   if(index==size()) add(element);
		   
	   
	    else if(index==0)
		{
		    DoubleNode n = head;
		    node.next = head;
		    node.prev = null;
		    n.prev = node;
		    head = node;
	    }
		else 
		{
		   
		   DoubleNode N = head;
		   for(int i=0;i<index-1;i++) N = N.next; 
		   node.next = N.next;
		   node.prev = N;
		   N.next = node; 
	    }
	}  
  
    public Object get(int index) 
	{
        if(index<0)
            throw new NullPointerException();
		
        DoubleNode n =head;
        while(index>0) 
		{
            n=n.next;
            index--;
        }
		
        return n.data ;    
    }
	
    public void set(int index, Object element)
	{
        if(index<0)
            throw new NullPointerException();
		
        DoubleNode N = head;
        for(int i=0;i<index;i++) N = N.next;    
        N.data=element;
    }
     
    public int size()
	{
        DoubleNode n= head;
        int i=0;
        while(n!=null) 
		{
            n=n.next;
            i++;
        }
        return i;
    }
  
    public void clear()
	{
        if(size()==0) return;  
        DoubleNode N = head;
        while(N.next!=null)
		{
           DoubleNode n=N;
           N=N.next;
           n.next=null;
           n.prev=null;
        }
        head=null;
    }
    
    public boolean isEmpty()
	{
        if(size()==0)  return true;
        else  return false;
    }
    
    public void remove(int index)
	{
       if(index<0)
		throw new NullPointerException ();
	
        DoubleNode N = head;
        if(index==0)
		{
            DoubleNode p = head;
            N = N.next;
            head = N;
            N.prev = null;
            p.next = null;
        }
		else if(index==size()-1)
		{
            DoubleNode t = tail;
            DoubleNode s = t.prev;
            tail = s;
            s.next = null;
            t.prev = null;
     
        }
		else
		{
			for(int i=0;i<index-1;i++) N = N.next;              
			
			DoubleNode M,n;
			M=N.next;
			n=M.next;
			
			N.next = n;
			n.prev = N;    
			
			M.next=null;
			M.prev=null;
        }  
        
    }
    
    public boolean contains(Object o) 
	{
		DoubleNode n= head;
		for(int i=0 ; i<size(); i++) 
		{
			if(n==null) return false;
			else if(n.data==o) return true;
			else n=n.next;    
		}
		return false;
    }
    
	public ILinkedList sublist(int fromIndex, int toIndex) 
	{
		if(fromIndex > toIndex || (fromIndex<0 || fromIndex>=size() || toIndex<0 || toIndex>=size()))
			throw new NullPointerException();
		
		DoubleNode N = head;
		int i = 0;
		for (i = 0; i < fromIndex; i++) N = N.next;
		
		DoubleLinkedList sub = new DoubleLinkedList();
		N.prev = null;
		head = N;
		
		for (int j = i; j < toIndex; j++)
		{
			sub.add(N.data);
			N = N.next;
		}
		
		N.next = null;
		return sub;
	}
    
	public static void main(String[] args) 
	{
		DoubleLinkedList values = new DoubleLinkedList();
		int x;
		Object y;
		Scanner input =new Scanner(System.in);
		String sin =input.nextLine().replaceAll("\\[|\\]", "");
		String[] s = sin.split(", ");
		String option =input.nextLine();
	
		if (s.length != 1 || !(s[0].isEmpty())) 
		{
			for(int i = 0; i < s.length; ++i)
			{
				values.add ( Integer.parseInt(s[i]));
			}
		}
		try 
		{ 
			switch(option) 
			{
				case "add" :
				{
					x=input.nextInt();
					values.add(x); 
					values.show();
					break;
				}
				
				case "addToIndex":
				{
					x=input.nextInt();
					y=input.nextInt();
					values.add(x,y);
					values.show();
					break;
				}
				
				case "size" :
				{
					
					int v = values.size();
					System.out.print(v);
					break;
				}
				
				case "set" :
				{
					x=input.nextInt();
					y=input.nextInt();      
					values.set(x,y);
					values.show();
					break;
				}
				
				case "clear" :
				{
					values.clear();
					values.show();
					break;
				}
				
				case "isEmpty" :
				{
					boolean e= values.isEmpty();
					if(e==true) System.out.print("True"); 
					else System.out.print("False");     
					break;
				}
				
				case "get" :
				{
					x=input.nextInt();
					Object  v = values.get(x);
					System.out.print(v);
					break;
					
				}
				
				case "remove" :
				{
					x=input.nextInt();
					values.remove(x);
					values.show(); 
					break;
				}
				
				case "contains" :
				{
					y=input.nextInt();
					boolean z = values.contains(y);
					if(z==true) System.out.print("True"); 
					else System.out.print("False");    
					break;
				}
				
				case "sublist" :
				{
					int w=input.nextInt();
					int q=input.nextInt();
					values.sublist(w, q);
					values.show(); 
					break;
				}
			}         
		} 
		catch( NullPointerException ex) 
		{
			System.out.print("Error");  
		}
	}
}