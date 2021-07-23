import java.util.Queue;
import java.util.LinkedList;
public class QueueInCollection {
	public static void main(String args[])
	{
		Queue<Integer> queue = new LinkedList<>();
		queue.add(2);
		System.out.println(queue.size());
		System.out.println(queue.peek());
	}
}
