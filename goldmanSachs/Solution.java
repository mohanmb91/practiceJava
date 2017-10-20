package goldmanSachs;
import java.util.*;


class ListNode {
int val;
ListNode next;
ListNode(int x) { val = x; }
}
class Solution {
    public static ListNode tempNode = null;
    public static ListNode tempNodeNext = null;
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head != null){
            removeNthFromEndHelper(head, n);   
            if(tempNode == null){
            	
                head = tempNodeNext;                
            }else{
                tempNode.next = tempNodeNext;
            }
        }
        return head;
    }
    public static int removeNthFromEndHelper(ListNode head, int n){
        if(head == null){
            return 1;
        }else{
            int position = -1;
            position = removeNthFromEndHelper(head.next, n);    
            if(position == n){
                tempNodeNext = head.next;
            }else if(position == n+1){
                tempNode = head;
            }
            position += 1;
            return position;
        }
        
    }
    public static void main(String args[]){
    	ListNode linkedList = new ListNode(1);
		linkedList.next = new ListNode(2);
//    	linkedList.next.next = new ListNode(3);
//    	linkedList.next.next.next = new ListNode(4);
    	removeNthFromEnd(linkedList, 2);
    }
}