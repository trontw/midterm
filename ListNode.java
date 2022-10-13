public class ListNode {

    public String key;
    public String letters;
    public ListNode next;

    public ListNode(String _key, ListNode _next) {
        key = _key;
        next = _next;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String _key) {
        key = _key;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode _next) {
        next = _next;
    }
}