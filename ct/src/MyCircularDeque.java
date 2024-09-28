import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCircularDeque {
    int limit;
    int end;
    int[] list;
    public MyCircularDeque(int k) {//Initializes the deque with a maximum size of k.
       list = new int[k];
       limit = k;
       end = -1;
    }

    public boolean insertFront(int value) {//Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
       if(end + 1 >= limit)
           return false;

       for (int i = end; i >= 0 ;i--)
           list[i+1] = list[i];
       list[0] = value;
       end++;
       return true;
    }

    public boolean insertLast(int value) {//Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
        if(end + 1 >= limit)
            return false;
        list[++end] = value;
        return true;
    }

    public boolean deleteFront() {//Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise
       if(end == -1)
           return false;
       for (int i = 0 ;i < end;i++){
           list[i] = list[i+1];
       }
       end--;
       return true;
    }

    public boolean deleteLast() {//Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
        if(end == -1)
            return false;
        end--;
        return true;
    }

    public int getFront() {//Returns the front item from the Deque. Returns -1 if the deque is empty.
        if(isEmpty())
            return -1;
        return list[0];
    }

    public int getRear() {//Returns the last item from Deque. Returns -1 if the deque is empty.
        if(isEmpty())
            return -1;
        return list[end];
    }

    public boolean isEmpty() {//Returns true if the deque is empty, or false otherwise.
      return end == -1;
    }

    public boolean isFull() {//Returns true if the deque is full, or false otherwise.
      return end+1 == limit;
    }

    public static void main(String[] args) {
        MyCircularDeque c = new MyCircularDeque(5);
        c.insertFront(7);
        c.insertFront(0);
        c.getFront();
        c.insertLast(3);
        c.getFront();
        c.insertFront(9);
        c.getRear();
        c.getFront();
        c.getFront();
        c.deleteFront();
        c.getRear();
    }
}
