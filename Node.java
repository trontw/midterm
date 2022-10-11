public class ListNode {
	public String letters;
    public ListNode cur;
    public ListNode head;
	public ListNode next;

	public Node (String l, ListNode n) {
		letters = l;
		next = n;
	}
    public Node (ListNode h, ListNode n) {
        head = h;
        next = n;
    }
    public String getKey () {
        return letters;
    }
    public 
}  