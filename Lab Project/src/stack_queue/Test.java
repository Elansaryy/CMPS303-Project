package stack_queue;

public class Test {

  	public static <E> boolean searchStack(Stack<E> s, E e)
	{
		Stack<E> tmp=new LinkedStack<>();
		boolean found=false;
		while (!s.isEmpty())
		{
			if (s.top().equals(e))
			{
				found=true;
				break;
			}
			tmp.push(s.pop());
		}
		while(!tmp.isEmpty())
			s.push(tmp.pop());
		return found;
	}
  	public static <E> boolean remove(Stack<E> s, E e)
  	{
  		Stack<E> tmp=new LinkedStack<>();
		boolean found=false;
		while (!s.isEmpty())
		{
			if (s.top().equals(e))
			{
				found=true;
				s.pop();
				break;
			}
			tmp.push(s.pop());
		}
		while(!tmp.isEmpty())
			s.push(tmp.pop());
		return found;
  	}
  	
	public static <E>void reverseQueue(Queue<E> q)
	{
		Stack<E> tmp=new LinkedStack<>();
		while (!q.isEmpty())
			tmp.push(q.dequeue());
		
		while (!tmp.isEmpty())
			q.enqueue(tmp.pop());
	}
	public static void removeEven(Stack<Integer> s)
	{
		Stack<Integer> t=new LinkedStack<>();
		while (!s.isEmpty())
			if (s.top()%2==1)
				t.push(s.pop());
			else
				s.pop();
		
	while (!t.isEmpty())
			s.push(t.pop());
	}

public static <E> boolean searchQueue(Queue<E> q, E e)
{
	int s=q.size();
	boolean found=false;
	for (int i=1;i<=s;i++)
	{
		if (q.first()==e)
			found=true;
		q.enqueue(q.dequeue());
	}
	return found;
}
	
	public static <E>boolean recursiveSearchStack(Stack<E> s, E e)
	{
		if (s.isEmpty())
			return false;
		if (s.top()==e)
				return true;
		 E  t=s.pop();
		 boolean found=recursiveSearchStack(s,e);
		 s.push(t);
		 return found;
	
	}
public static double postfix(String s)
{
	Stack<Double> st=new LinkedStack<>();
	for (int i=0;i<s.length();i++)
	{
		char c=s.charAt(i); 
        
        // If the scanned character is an operand (number here), 
        // push it to the stack. 
        if(Character.isDigit(c)) 
        {
        	 double x = c-'0';
        	 st.push(x); 
        }
          
        //  If the scanned character is an operator, pop two 
        // elements from stack apply the operator 
        else
        { 
          double val1 = st.pop(); 
           double val2 = st.pop(); 
              
            switch(c) 
            { 
                case '+': 
                st.push(val2+val1); 
                break; 
                  
                case '-': 
                st.push(val2- val1); 
                break; 
                  
                case '/': 
                st.push(val2/val1); 
                break; 
                  
                case '*': 
                st.push(val2*val1); 
                break; 
          } 
        } 
    } 
    return st.pop();     
} 
public static <E>void reverseStack(Stack<E> s)
{
	Stack<E> t1=new LinkedStack<>();
	Stack<E> t2=new LinkedStack<>();
	while (!s.isEmpty())
		t1.push(s.pop());
	while (!t1.isEmpty())
		t2.push(t1.pop());
	while (!t2.isEmpty())
		s.push(t2.pop());
}
public static void main(String[] args) {
		
		Stack<Integer> st=new LinkedStack<>();
		
		st.push(4);
		st.push(5);
		st.push(7);
		st.push(9);
		//System.out.println(searchStack(st,9));
		//System.out.println(recursiveSearchStack(st, 49));
		//System.out.println(remove(st,7));
		//-- to print the stack, put size in a tmp variable because 
		// --each time we pop it gets changed
		
		removeEven(st);
		
		
		int s=st.size();
		for(int i=0;i<s;i++)
			System.out.println(st.pop());
		
		Queue<Integer> q1=new LinkedQueue<>();
		q1.enqueue(4);
		q1.enqueue(2);
		q1.enqueue(9);
		q1.enqueue(5);
		System.out.println(searchQueue(q1,9));
		
		
		
		System.out.println(postfix("462/+"));
		
		

	}

}
