package MySolution;
import java.util.Stack;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月11日上午10:16:28 
 * @todo:TODO
 */
public class _232ImplementQueueUsingStacks {
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();
	
	 // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
    	if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return input.empty() && output.empty();
    }
}
