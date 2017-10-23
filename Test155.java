import java.util.ArrayList;

public class Test155 {

    public static void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(-2);
        System.out.println(ms.getMin());
        MinStack_best ms_best = new MinStack_best();
        ms_best.push(-2);
        System.out.println(ms_best.getMin());
    }

}

class MinStack_best{
    private Node_best head;

    public MinStack_best(){
        head=null;
    }

    public void push(int x){
        Node_best node=new Node_best(x,head==null?x:Math.min(head.min,x),head);
        head=node;
    }

    public void pop(){
        if(head==null)
            return;

        head=head.next;
    }

    public int top(){
        if(head==null)
            throw new RuntimeException("out of boundary");

        return head.val;
    }

    public int getMin(){
        if(head==null)
            throw new RuntimeException("out of boundary");

        return head.min;
    }
}

class Node_best{
    int val;
    int min;
    Node_best next;

    Node_best(int v, int m){
        this(v,m, null);
    }

    Node_best(int v, int m, Node_best n){
        this.val = v;
        this.min = m;
        this.next = n;
    }
}

class MinStack{
    ArrayList<Node> stack;
    int topPointer;

    public MinStack() {
        stack = new ArrayList<>();
        topPointer = -1;
    }

    public void push(int x){

        if(topPointer == stack.size()-1)
            stack.add(new Node(x, Math.min(x, topPointer < 0 ? x : stack.get(topPointer).min)));
        else
            stack.set(topPointer + 1, new Node(x,topPointer < 0 ? x : stack.get(topPointer).min));

        topPointer++;
    }

    public void pop() {
        if(topPointer < 0)
            throw new RuntimeException("Out of Boundary");
        else{
            topPointer--;
        }
    }

    public int top() {
        return stack.get(topPointer).val;
    }

    public int getMin() {
        if(topPointer < 0)
            throw new RuntimeException("Out of Boundary");

        return stack.get(topPointer).min;
    }

}

class Node{
    int val;
    int min;

    Node(int v, int m){
        this.val = v;
        this.min = m;
    }
}
