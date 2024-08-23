import java.util.Stack;

public class DeliveryBox {
    class Container{
        int top;
        int[] container;

        Container(int size){
            container = new int[size];
            top = 0;
        }

        public void push(int i){
            container[top++] = i;
        }
        public int pop(){
            int r = container[top-1];
            container[top-1] = 0;
            top -= 1;
            return r;
        }
        public int peek(){
            return container[top-1];
        }
        public int size(){
            return top;
        }
    }
    public int solution(int[] order) {
        int answer = 0;
        Container container = new Container(order.length);
        Container sub = new Container(order.length);
        for (int i = order.length; i > 0; i--) {
            container.push(i);
        }
        int index = 0;
        while(true){
            if(container.size()>0){
                if(container.peek() == order[index]){
                    container.pop();
                    index++;
                }else{
                    sub.push(container.pop());
                }
            }
            if(sub.size() != 0 && sub.peek() == order[index]){
                sub.pop();
                index++;
            }
            if(container.size() == 0 && sub.size() != 0 && sub.peek() != order[index])
                break;
            if(index == order.length){
                break;
            }
        }
        answer = index;


        return answer;
    }


}
