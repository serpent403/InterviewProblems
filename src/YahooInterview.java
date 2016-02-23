//
//public class YahooInterview {
//
//}
//
//hello
//
//Merge two sorted linked lists
//e.g.
//1->3->5->NULL
//2->4->6->NULL
//result:
//1->2->3->4->5->6->NULL
//
//public class Node {
//    int value;
//    Node next;
//    Node(int x) {
//        value = x;
//    }
//}
//
//Node mergeLinkedList(Node a, Node b) {
//
//  Node final = null;
//  
//  if(a == null) {
//    return b;
//  }
//  
//  if (b == null) {
//    return a;
//  }
//  
//  if(a.value <= b.value) {
//    final = a;
//    final.next = mergeLinkedList(a.next, b);
//  } else{
//    final = b;
//    final.next = mergeLinkedList(a, b.next);
//  }
//  
//  return final;
//  
//}
//
//2. Merge M sorted linked lists, each at most has N nodes
//
//public class Node {
//    int value;
//    Node next;
//    Node(int x) {
//        value = x;
//    }
//}
//
//
//Node mergeLinkedList(Node[] arr) {
//
//  MinHeap mHeap = new MinHeap(M);
//  
//  for(int i=0; i < M; i++) {
//    Node n = arr[i];
//    
//    if(n != null) {
//      mHeap.insert(n);
//    }
//  }  
//  
//  Node final = null;
//  
//  while(mHeap.size > 0) {
//    Node min = mHeap.extractMin();
//    
//    if (final == null) {
//      final = min;
//    } else {
//      final.next = min;
//    }
//    
//    if (min.next != null) {
//      mHeap.insert(min.next);
//    }
//    
//    final = final.next;
//  
//  }
//  
//  return final;
//  
//}
//
//each comparison: M
//how many comparisons? N
//O(logM*M*N)
//
//Tounament Tree or Loser Tree. Its the same thing.
//
//
//2, 4, 5, 11, 0, 20
//
//2, 5, 0
//
//2,0
//
//0
//O(logM*M*N)
//insert
//extractMin
//size
