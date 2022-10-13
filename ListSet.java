public class ListSet {

  ListNode[] table;
  int numelements;
  int size;
  ListNode head = null;
  ListNode cur = null;
  ListNode next = null;

  public ListSet() {
    numelements = 0;
    size = 100;
    table = new ListNode[size];
  }

  public void insert_head(String key) {
    /*
     * if (numelements == size) {
     * // need to expand the table and rehash the contents
     * 
     * ListNode[] oldTable = table;
     * int oldSize = size;
     * ListNode cur = null;
     * 
     * numelements = 0;
     * size = 2 * size;
     * table = new ListNode[size];
     * 
     * for (int i = 0; i < oldSize; i++) {
     * for (ListNode curr = oldTable[i]; curr != null; curr = curr.getNext())
     * insert_head(curr.getKey());
     * }
     * }
     * // int k = hash(key);
     * // table[k] = new ListNode(key, table[k]);
     * // numelements++;
     * // Inserting at the head of the Linked-List
     */
    ListNode cur = new ListNode(key, next);
    cur.letters = key;
    // System.out.println("Inside HEAD " + cur.letters);
    cur.next = head;
    head = cur;
  }

  public void insert_tail(String key) {
    // int k = hash(key);
    // table[k] = new ListNode(key, table[k]);
    // numelements++;
    // Inserting at the tail of the Linked-List
    ListNode newTail = new ListNode(key, next);
    newTail.letters = key;
    // System.out.println("Inside TAIL " + newTail.letters);
    if (head == null) {
      head = newTail;
    } else {
      ListNode temp;
      temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      ListNode tail = temp.next;
      temp.next = newTail;
    }
  }

  public boolean find(String key) {
    int i = hash(key);
    for (ListNode curr = table[i]; curr != null; curr = curr.next)
      if (key.equals(curr.getKey()))
        return true;
    return false;
  }

  public void print() {
    // for (int i = 0; i < size; i++)
    // for (ListNode curr = table[i]; curr != null; curr = curr.getNext())
    // System.out.print(curr.getKey());
    // ListNode cur;
    // for (int i = 0; i < size; ++i) {
    for (ListNode cur = head; cur != null; cur = cur.next)
      System.out.print(cur.getKey());
    // }
  }

  private int hash(String k) {
    int h = 0;
    for (int i = 0; i < k.length(); i++)
      h = (h * 2917 + (int) k.charAt(i)) % size;
    return h;
  }
}
