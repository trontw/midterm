public class HashSet {

    HashNode[] table;
    int numelements;
    int size;

    public HashSet() {
        numelements = 0;
        size = 100;
        table = new HashNode[size];
    }

    public void insert(String key) {
        // hash the key and put it at the head of a linked-list
        int k = hash(key);
        table[k] = new HashNode(key, table[k]);
        numelements++;
        // System.out.println("Inserted "+numelements+" elements into the table.");
    }

    /*
     * finds if a String name is present in the data structure.
     * Returns true if found, else false.
     */
    public boolean find(String key) {
        // First, hash the key to get the value we are looking for in the table
        int i = hash(key);
        for (HashNode cur = table[i]; cur != null; cur = cur.getNext()) {
            if (cur.getKey().equals(key)) {
                // System.out.println("Found your word");
                return true;
            }
        }
        return false;
    }

    /*
     * Removes String name is present in the data structure.
     * Returns true if found, else false.
     */
    public void remove(String key) {
        // First, hash the key to get the value we are looking for in the table
        // System.out.println("Inside remove");
        int i = hash(key);
        for (HashNode cur = table[i]; cur != null; cur = cur.getNext()) {
            if (cur.getKey().equals(key)) {
                // System.out.println("Found your person");
                table[i] = null;
            }
        }
    }

    /*
     * Prints the contents of the hash table.
     */
    public void print() {
        // System.out.println("Inside print");
        for (int i = 0; i < size; ++i) {
            for (HashNode cur = table[i]; cur != null; cur = cur.getNext())
                System.out.println(cur.getKey());
        }
    }

    /*
     * The hash function that returns the index into the hash table for a string k.
     */
    private static int hash(String k) {
        int hash = 0;
        int size = 100;
        int x = 31;// initial Prime number to test with
        for (int i = 0; (int) i < k.length(); ++i) {
            hash = (hash * x + k.charAt(i)) % size;
        }
        return hash;
    }

}