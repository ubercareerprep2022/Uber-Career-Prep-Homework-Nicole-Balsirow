public class Part4{

    public static void main(String args[]){
        LinkedList test = new LinkedList();
        test.printList();
        test.push(new Node(Integer.valueOf(3)));
        test.printList();
        System.out.println(test.size());

        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(new Node(Integer.valueOf(4)));
        test.push(new Node(Integer.valueOf(3)));
        test.push(new Node(Integer.valueOf(2)));
        System.out.println("New list:");
        test.printList();

        test.remove(1);
        System.out.println("Removed index 1: ");
        test.printList();
        test.remove(3);
        System.out.println("Current Size: " + test.size());

        System.out.println("Element at 1: " + test.elementAt(1));
        
        test.insert(1, new Node(Integer.valueOf(6)));
        test.insert(2, new Node(Integer.valueOf(10)));

        System.out.println("Inserted 6 at index 1 and 10 at index 2");
        test.printList();

        Node loop = new Node(Integer.valueOf(11));
        loop.next = test.head;
        test.head.next = loop;
        System.out.println(loop.next);

        test.insert(3, loop);
        test.printList();
        System.out.println(test.hasCycle());

    }



    static class LinkedList{
        Node head;
        int size;

        LinkedList(){
            head = new Node(null);
            size = 0;
        }

        void push(Node n){
            n.next = head;
            head = n;
            size++;
        }

        Node pop(){
            if(size<=0){
                return null;
            }
            Node temp = head;
            head = head.next;
            size--;
            return temp;
        }

        void insert(int index, Node node){
            if(index>size){
            }else{
                if(index == 0){
                    node.next = head;
                    head = node;
                    return;
                }
                Node cur = head;
                for(int i = 0; i<index-1; i++){
                    cur = cur.next;
                }
                node.next = cur.next;
                cur.next = node;
                size++;
            }
        }

        void remove(int index){
            if(index>size){
            }else{
                if(index == 0){
                    head = head.next;
                }

                Node temp = head;
                for(int i = 0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        Node elementAt(int index){
            if(index>size){
                return null;
            }
            Node cur = head;
            for(int i = 0; i<index; i++){
                cur = cur.next;
            }
            return cur;
        }

        int size(){
            return size;
        }
        
        void printList(){
            System.out.print("[");
            Node cur = head;
            for(int i = 0; i<size-1; i++){
                System.out.print(cur + ", ");
                cur = cur.next;
            }
            System.out.print(cur + "]");
            System.out.println();
        }

        boolean hasCycle(){
            Node slow = head; 
            Node fast = head;
            boolean found = false;

            while (slow!=null && fast!=null && fast.next!=null && !found){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
    }

    private static class Node{
        Integer data;
        Node next;

        Node(Integer d){
            data = d;
        
        }

        Node(Integer d, Node n){
            data = d;
            next = n;
        
        }

        public String toString(){
            return String.valueOf(data);
        }
    
    }


}
