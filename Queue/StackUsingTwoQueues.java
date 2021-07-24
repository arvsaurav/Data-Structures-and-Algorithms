import java.util.Queue;
import java.util.LinkedList;
public class Stack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }


    public int getSize() { 
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public void push(int element) {
        while(!q1.isEmpty())
        {
            q2.add(q1.remove());
        }
        q1.add(element);
        while(!q2.isEmpty())
        {
            q1.add(q2.remove());
        }
    }

    public int pop() {
        if(q1.isEmpty())
        {
            return -1;
        }
        int temp = q1.element();
        q1.remove();
        return temp;
    }

    public int top() {
        if(q1.isEmpty())
        {
            return -1;
        }
        return q1.peek();
    }
}


//Driver Code :
import java.util.Scanner;

public class StackUse {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Stack stack = new Stack();

		int q = s.nextInt();

		while (q > 0) {
			int choice, input;
			choice = s.nextInt();

			switch(choice) {
				case 1:
					input = s.nextInt();
					stack.push(input);
					break;

				case 2:
					System.out.println(stack.pop());
					break;

				case 3:
					System.out.println(stack.top());
					break;

				case 4:
					System.out.println(stack.getSize());
					break; 

				default: 
					System.out.println((stack.isEmpty()) ? "true" : "false");
			}

			q -= 1;
		}

	}

}