import java.util.*;


public class Queue5MinimumStack {
    

    Stack<Integer> allData;
    Stack<Integer> minData;

    void minStack() {
        allData = new Stack<>();
        minData = new Stack<>();
    }

    int size() {
        return allData.size();
    }
    
    void push(int val  ) {
        allData.push(val);
        if (minData.isEmpty() || val <= minData.peek()) {
            minData.push(val);
        } 
    }

    int min() {
        if (size() == 0) {
            System.out.println("Stack Underflow !");
            return -1;
        } else {
            return minData.peek();
        }
    }
    
    int top() {
        if (size() == 0) {
            System.out.println("Stack Underflow !");
            return -1;
        } else {
            return allData.peek();  
        }
    }

    int pop() {
        if (size() == 0) {
            System.out.println("Stack Underflow !");
            return -1;
        } else {
            int val = allData.pop();
            if (val == minData.peek()) {
                minData.pop();
            }
            return val;
        }
    }






}
