
public class Part3{
    public static void main(String[] args){
        Integer i = Integer.valueOf(2);
        Stack<Integer> myStack = new Stack<Integer>();
        Queue<Integer> myQueue = new Queue<Integer>();
        System.out.println("Is Stack Empty?: " + myStack.isEmpty());
        System.out.println("Is Queue Empty?: " + myQueue.isEmpty());
        myStack.push(i);
        myQueue.enqueue(i);
        myStack.push(Integer.valueOf(5));
        myQueue.enqueue(Integer.valueOf(10));
        myStack.push(Integer.valueOf(4));
        myQueue.enqueue(Integer.valueOf(20));
        Integer p = myStack.peek();
        System.out.println(p);
        System.out.println("Size of Stack: " + myStack.size());
        System.out.println("Empty?" + myStack.isEmpty());
        System.out.println("Popping contents: ");
        while(!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
        
        System.out.println("Size of Queue: " + myQueue.size());
        System.out.println("Empty? " + myQueue.isEmpty());
        System.out.println("Dequeuing: ");
        while(!myQueue.isEmpty()){
            System.out.println(myQueue.dequeue());
        }


    }
    static class Stack<T>{
        private T[] stack;
        int theSize;
        public Stack(){
            theSize = 0;
            moreCapacity();
        }
        private void moreCapacity(){
            T[] old = stack;
            stack = (T[]) new Object[theSize+10];
            for (int i = 0; i<theSize; i++){
                stack[i]=old[i];
            }
        }
    
        public void push(T x){
            if (stack.length == theSize){
                moreCapacity();
            }
            stack[theSize] = x;        
            theSize++;
        }
    
	    public T pop(){
            if(isEmpty()){
                return null;
            }else{
                theSize--;
                return stack[theSize];
            }
        }
        public T peek(){
            return stack[theSize-1];
        }
	
        public boolean isEmpty(){
            return (theSize == 0);
        }

        public int size(){
            return theSize;
        }
    }

    static class Queue<T>{
        private Stack<T> s1;
        private Stack<T> s2;
        private int size;
    
        public Queue() {
            s1 = new Stack<T>();
            s2 = new Stack<T>();
            size = 0;
        }
    
        public void enqueue(T x){
            s1.push(x);
            size++;
        }
    
	    public T dequeue(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            size--;
            return s2.pop();
        }
    
	    public int size(){
            return size;
        }
    
	    public boolean isEmpty(){
            return size==0;
        }
    }
}

