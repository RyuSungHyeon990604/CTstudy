public class CustomStack {
    int[] stack;
    int top;
    public CustomStack(int maxSize) {//Initializes the object with maxSize which is the maximum number of elements in the stack.
        top = -1;
        stack = new int[maxSize];
    }

    public void push(int x) {//Adds x to the top of the stack if the stack has not reached the maxSize.
        if(top == stack.length-1)
            return;
        stack[++top] = x;
    }

    public int pop() {// Pops and returns the top of the stack or -1 if the stack is empty.
        if(top == -1)
            return -1;
        return stack[top--];
    }

    public void increment(int k, int val) {// Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
        if(top == -1)
            return;
        for(int i=0; i <= top; i++) {
            if(k>0){
                k--;
                stack[i] += val;
            }
        }
    }
}
