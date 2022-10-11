import java.security.cert.LDAPCertStoreParameters;
import java.util.Scanner;
import java.lang.Integer;

public class BrokenKeyboard {

	public void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		String text = "";

		while (kb.hasNext()) {

			String line = kb.nextLine();
			int count = line.length();
			System.out.println("The line count is = " + count);
			// Initialize str to line
			StringBuffer str = new StringBuffer(line);
			// String temp = line;
			// text = text + line + "\n";
			ListNode head = null;
			ListNode tail = null;
			// ListNode next = null;
			ListNode cur = new ListNode();
			// cur = head;
			// cur.letters = text;
			// System.out.println("cur.letters becomes "+text);
			for (int i = 0; i < count; ++i) {
				int counter = 0;
				// Read in text until we come to a special character
				// Look for letters that don't have ^ or newline
				// if (str.charAt(i) != '^' && str.charAt(i) != '\n' && (counter <= count)) {
				if (str.charAt(i) != '^' && (counter <= count)) {
					if (str.charAt(i) == '\n') {
						cur.letters = cur.letters + "\n";
						System.out.println("The special character \n was found");
					} else {
						text = text + str.charAt(i);
						cur.letters = text;
						if (head == null) {
							head = new ListNode();
							cur = head;
						}
						cur.next = null;
					}
				} else if ((str.charAt(i)) == '^' && (counter <= count)) {
					// Now that we found a ^ character, we must move the text
					// that follows to the front until we come to a $.
					if ((str.charAt(i)) != '$' && (counter <= count)) {
						System.out.println("We have found ^, letters before move to head " + cur.letters);
						cur.next = head;
						head = cur;
						cur.letters = text;
						System.out.println("Letters after move to head " + cur.letters);
					} else if ((str.charAt(i)) == '$' && (counter <= count)) {
						while (tail != null)
							tail = tail.next;
						tail.next = cur;
					}
				}
				// cur.letters = text;
			}
			// System.out.println("Cur before special chars is ->"+cur.letters);
			/*
			 * //str.setCharAt(i, j);
			 * //line = str.toString();
			 * text = text + line + "\n";
			 * //text = text + str.charAt(i);
			 * //System.out.println("Inside FOR text is "+text);
			 * //Set current string at head
			 * //cur.letters = text;
			 * counter++;
			 * // Found home ^ symbol, move cursor to head of linked-list
			 * } else {
			 * //cur.letters = text;
			 * //Insert text at head of Linked-List
			 * //cur = cur.head;
			 * //cur = cur.next;
			 * //System.out.println("The cur in the else is "+cur);
			 * }
			 * }
			 */
		}
		text = text.substring(0, text.length() - 1); // Removing the last \n.
		// System.out.println(text);
		// TODO: text is the entire input string,
		// with home (^) and end ($) characters pressed.
		// Please write code to reconstruct the original
		// text without the home and end characters.
	}
}
