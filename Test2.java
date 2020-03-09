/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lcur=headA;
        ListNode scur=headB;
        int long_len=getLen(headA);
        int short_len=getLen(headB);
        int len=long_len-short_len;
        if(len<0){
            len=-len;
            lcur=headB;
            scur=headA;
        }
        while(len!=0){
            lcur=lcur.next;
            len--;
        }
        while(lcur!=scur){
            lcur=lcur.next;
            scur=scur.next;
        }
        return lcur==null?null:lcur;
    }
    private int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while(pre.next!=null){
            if(pre.next.val==val){
                break;
            }
            pre=pre.next;
        }
        if(pre.next==null){
            return head;
        }
        ListNode cur=pre.next;
        pre.next=cur.next;
        cur.next=null;
        return dummy.next;
    }
}

class MinStack {
    private static class Node{
        private int val;
        private int min;
        public Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    Stack<Node> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int x) {
        Node node=null;
        if(stack.isEmpty()){
            node=new Node(x,x);
        }else{
            int tmp=stack.peek().min;
            node=new Node(x,x<tmp?x:tmp);
        }
        stack.push(node);
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().val;
    }
    
    public int min() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
 
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格
 class Solution {
    public char firstUniqChar(String s) {
        if("".equals(s)) return ' ';
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}


