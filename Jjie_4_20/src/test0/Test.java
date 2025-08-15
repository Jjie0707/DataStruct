package test0;

public class Test {
    public ListNode partition(ListNode head, int x) {
        ListNode cur=head;
        if (head == null || cur.next==null) {
            return head;
        }
        ListNode left=new ListNode(0);
        ListNode leftC=left;
        ListNode right=new ListNode(0);
        ListNode rightC=right;


        // ListNode left=new ListNode(0);
        // ListNode leftC=left;
        // ListNode right=new ListNode(0);
        // ListNode rightC=right;
        

//        while(cur!=null){
//            if(cur.val<=x){
//                leftC.next=cur;
//                leftC=cur;
//            }else{
//                rightC.next=cur;
//                rightC=cur;
//            }
//        }

        while(cur!=null){
            if(cur.val<=x){
                leftC.next=cur;
                leftC=cur;
            }else{
                rightC.next=cur;
                rightC=cur;
            }
        }
        leftC.next=null;
        rightC.next=null;

        if(left.next==null){
            return right.next;
        }else if(right.next==null){
            return left.next;
        }else{
            leftC.next=right.next;
            return left.next;
        }
    }

    public static void main0(String[] args) {
        ListNode head=new ListNode();
        head.val=1;
        ListNode s1=new ListNode();
        s1.val=2;
        ListNode s2=new ListNode();
        s2.val=3;
        ListNode s3=new ListNode();
        s3.val=2;
        ListNode s4=new ListNode();
        s4.val=1;
        head.next=s1;
        s1.next=s2;
        s2.next=s3;
        s3.next=s4;
        System.out.println(isPalindrome(head));
    }
    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur = head.next;
        while (cur != null) {
            ListNode curN = cur.next;
            cur.next = head;
            head=cur;
            cur = curN;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (fast.next.next == null) {
                slow = slow.next;
                fast = fast.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        reverseList(mid);
        //执行到这里的时候右边的链表已经被反转

        ListNode left = head;
        ListNode right = fast;

        while (left != right) {
            if (left.next == right && left.val == right.val) {
                return true;
            }
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
