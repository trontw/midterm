public class HashNode {

    public String name;
    public HashNode next;

    public HashNode(String _name, HashNode _next) {
        name = _name;
        next = _next;
    }

    public String getKey() {
        return name;
    }

    public void setKey(String _name) {
        name = _name;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode _next) {
        next = _next;
    }
}
