import java.util.*;

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

class Node
{
	int data;
	Node next;
}

public class SingleLinkedList implements ILinkedList 
{
    static Node  head;
	
    public  void show() 
	{
        Node n = head;
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
        Node node = new Node();
        node.data = (int)element;
        node.next = null;
        
        if(head==null) head = node;
        else
		{
           Node N = head;
           while(N.next != null) N = N.next;
           N.next=node;
        }
    }
      
	public void add(int index, Object element)
	{
		if(index<0)
		throw new NullPointerException();

		Node node = new Node();
		node.data =(int)element;
		node.next = null;

		if(index==0)
		{
			Node n = head;
			node.next=head;
			head=node;
		}
		else
		{
			Node N = head;
			for(int i=0;i<index-1;i++)
				N = N.next;      
			node.next = N.next;
			N.next = node; 
		} 

	}
  
	public int size()
	{
		Node n = head;
		int i=0;
		while(n!=null) 
		{
			n=n.next;
			i++;
		}
		return i;
	}

	public void set(int index, Object element)
	{
		if(index<0)
		throw new NullPointerException();
		Node N = head;
		for(int i=0;i<index;i++)
			N = N.next;      
		N.data=(int)element;
	}
    
	public void clear()
	{
		if(size()==0) return;  
		Node N = head;
		while(N.next!=null)
		{
			Node n=N;
			N=N.next;
			n.next=null; 
		}
		head=null;
	}
    
    public boolean isEmpty()
	{
        if(size()==0) return true;
        else return false;            
    }
    
    public Object get(int index) 
	{
		if(index<0)
			throw new NullPointerException();
		
		Node n = head;
		while(index>0) 
		{
			n=n.next;
			index--;
		}

		return n.data ;
	}
    
     public void remove(int index)
	{
		if(index<0)
			throw new NullPointerException ();
	
		Node N = head;
		if(index==0)
		{
			Node p = head;
			N=N.next;
			head=N;
			p.next=null;
		}
		else
		{
			for(int i=0;i<index-1;i++)
				N = N.next;      
			
			Node M,n;
			M=N.next;
			n=M.next;
			N.next = n;
			M.next=null;
		}  
	}
	 
	public boolean contains(Object o) 
	{
		Node n= head;
		for(int i=0 ; i<size(); i++) 
		{
			if(n==null) 
				return false;
			else if(n.data==(int)o)
				return true;
			else
				n=n.next;     
		}
		return false;
	}
    
    public ILinkedList sublist(int fromIndex, int toIndex) 
	{
        if(fromIndex > toIndex || (fromIndex<0 || fromIndex>=size() || toIndex<0 || toIndex>=size()))
            throw new NullPointerException();
      
        Node N = head;
        int i = 0;
		
        for(i = 0; i < fromIndex; i++)
            N = N.next;

		SingleLinkedList sub = new SingleLinkedList();
        head=N;
         
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
		SingleLinkedList values = new SingleLinkedList();
		int x;
		Object y;
		
		Scanner input = new Scanner(System.in);
		String sin = input.nextLine().replaceAll("\\[|\\]", "");
		String[] s = sin.split(", ");
		String option =input.nextLine();
	
		if (s.length != 1 || !(s[0].isEmpty())) 
		{
			for(int i = 0; i < s.length; ++i)
			values.add ( Integer.parseInt(s[i]));
		}
		try 
		{ 
			switch(option) 
			{
				case "add" :
				{
					x = input.nextInt();
					values.add(x); 
					values.show();
					break;
				}
				
				case "addToIndex" :
				{
					x = input.nextInt();
					y = input.nextInt();
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
					x = input.nextInt();
					y = input.nextInt();      
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
					boolean e = values.isEmpty();
					if(e == true) System.out.print("True"); 
					else System.out.print("False");    
					break;
				}
				
				case "get" : 
				{
					x = input.nextInt();
					Object v = values.get(x);
					System.out.print(v);
					break;
				}
				
				case "remove" :
				{
					x = input.nextInt();
					values.remove(x);
					values.show(); 
					break;
				}
				
				case "contains" :
				{
					y = input.nextInt();
					boolean z = values.contains(y);
					if(z==true) System.out.print("True"); 
					else System.out.print("False");  
					break;
				}
				
				case "sublist" :
				{
					int w = input.nextInt();
					int q = input.nextInt();
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