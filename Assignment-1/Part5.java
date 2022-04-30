public class Part5{

    public static void main(String args[]){
        LinkedList test = new LinkedList();
        test.push(new Node(Integer.valueOf(3)));
        test.push(new Node(Integer.valueOf(4)));
        test.push(new Node(Integer.valueOf(3)));
        test.push(new Node(Integer.valueOf(2)));        
        test.insert(1, new Node(Integer.valueOf(6)));
        test.insert(2, new Node(Integer.valueOf(10)));

        System.out.println("Current List: ");
        test.printList();

        LinkedList test1 = reverseLinkedListIterative(test);
        test1.printList();

        LinkedList test2 = reverseLinkedListStack(test1);
        test2.printList();

        LinkedList test3 = reverseLinkedListRecursive(test2);
        test3.printList();

    }

    public static LinkedList reverseLinkedListRecursive(LinkedList list){
        if(list.size()<=1){
            return list;
        }
        list.head = recursiveList(list.head);
        return list;    
    }

    private static Node recursiveList(Node n){
        if(n.data==null){
            return n;
        }
        if(n.next.data == null){
            return n;
        }
        Node temp = recursiveList(n.next);
        n.next.next = n;
        n.next = new Node(null);
        return temp;
    }

    public static LinkedList reverseLinkedListStack(LinkedList list){
        if(list.size()<=1){
            return list;
        }

        LinkedList r = new LinkedList();

        while(list.size()!=0){
            r.push(list.pop());

        }

        return r;    
    }

    public static LinkedList reverseLinkedListIterative(LinkedList list){
        if(list.size()<=1){
            return list;
        }

        Node next = list.head;
        Node prev = list.head;
        Node cur = list.head;

        while(next.data!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        list.head = prev;
        return list;
        
    
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
