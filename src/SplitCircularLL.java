// This is a comment
class SplitCircularLL {
    Node head, head1, head2;

    public SplitCircularLL(Node h) {
        head = h;
    }
    
    void split() {
        Node slow_ptr = head;
        Node fast_ptr = head;
       
        while(fast_ptr.next != head && fast_ptr.next.next != head) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        
        if(fast_ptr.next.next == head)
            fast_ptr = fast_ptr.next;


        head1 = head;
        head2 = slow_ptr.next; 
        
        slow_ptr.next = head1;    
        fast_ptr.next = head2;
        
    }

    public static void main(String args[]) {
        
        
        
    }
}