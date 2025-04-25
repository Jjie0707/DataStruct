package test0;

import java.util.LinkedList;

public class MinStack {
    public LinkedList<Integer> lis=new LinkedList<>();
    public LinkedList<Integer> min=new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        if(lis==null){
            lis.addFirst(val);
            min.addFirst(val);
        }else{
            lis.addFirst(val);
            if(val<=min.peek()){
                min.addFirst(val);
            }
        }
    }

    public void pop() {
        if(lis.size()==1){
            lis.pop();
            min.pop();
        }else{
            if(lis.peek().equals(min.peek())){
                lis.pop();
                min.pop();
            }
        }
    }

    public int top() {
        return lis.peek();
    }

    public int getMin() {
        return min.peek();
    }



//    public Node min;
//    public Node top;
//    public static LinkedList<Integer> list=new LinkedList<>();
//
//
//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//        if(this.top==null){
//            top=new Node(val);
//            list.addFirst(val);
//        }else{
//            Node p=new Node(val);
//            p.next=top;
//            top=p;
//        }
//    }
//
//    public void pop() {
//        top=top.next;
//    }
//
//    public int top() {
//        return top.val;
//    }

//    public int getMin() {
//
//    }
}
