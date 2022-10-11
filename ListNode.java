public class ListNode {
	public String letters;
    public ListNode cur;
    public ListNode head;
    public ListNode tail;
	public ListNode next;

	public ListNode () {
		letters = null;
		next = null;
        head = null;
        tail = null;
        cur = null;
	}
    public ListNode (String l){
        letters = l;
        next = null;
    }
    public ListNode (ListNode h, ListNode n) {
        head = h;
        next = n;
    }
    public String getKey () {
        return letters;
    }
    public ListNode getNext (){
        return next;
    }
}  