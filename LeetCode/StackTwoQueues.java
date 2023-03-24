package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class StackTwoQueues {

    Queue<Integer> pushQueue = new LinkedList<Integer>();;
    Queue<Integer> topPopQueue =  new LinkedList<Integer>();
    public StackTwoQueues() {
    }

    public void push(int x) {
        pushQueue.add(x);
    }

    public int pop() {
        int queueSize = pushQueue.size();
        while(queueSize - 1 > 0){
            topPopQueue.add(pushQueue.poll());
        }
        int pollElement = pushQueue.poll();

        while(topPopQueue.size() > 0){
            pushQueue.add(topPopQueue.poll());
        }
        return pollElement;
    }

    public int top() {
        int queueSize = pushQueue.size();

        while(queueSize - 1 > 0){
            topPopQueue.add(pushQueue.poll());
        }
        int peekElement = pushQueue.poll();
        topPopQueue.add(peekElement);

        while(topPopQueue.size() > 0){
            pushQueue.add(topPopQueue.poll());
        }
        return peekElement;
    }

    public boolean empty() {
        return pushQueue.size() == 0;
    }

    public static void main(String[] args) {

        StackTwoQueues obj = new StackTwoQueues();
          obj.push(1);
        obj.push(2);
         System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());

    }

}
