import java.security.cert.LDAPCertStoreParameters;
import java.util.Scanner;
import org.omg.PortableInterceptor.NON_EXISTENT;
import java.lang.Integer;

public class BrokenKeyboard {

	public static void main(String[] args) {

		ListNode[] table;
		int size;
		Scanner kb = new Scanner(System.in);
		ListSet x = new ListSet();
		String text = "";
		boolean home_active = true;
		boolean end_active = false;
		boolean prev_end = true;
		while (kb.hasNext()) {

			String word = kb.next();
			int count = word.length();
			System.out.println("The word length is = " + count);
			// text = text.substring(0, text.length() - 1); // Removing the last \n.
			int home = word.indexOf('^');
			System.out.println("Index of ^ in word is " + home);
			int end = word.indexOf('$');
			System.out.println("Index of $ in word is " + end);
			// Newline not being detected by this:
			// int newL = word.indexOf('\n');
			// System.out.println("Index of newline in word is " + newL);

			// boolean prev_home = true;//Assume everything is place at head of list
			// Now we can see if ^ or $ are not in the word (returns -1)
			// However, if they are there, their index in the word is given
			// and we will have to split the word at that point
			// First check home ^, if found, everything after ^ up to the next $
			// will be put in front of the existing string
			// * Interesting Note * none of the words have both ^ and $ in them
			// which means, we can separate words based on the single character
			// and then parse which piece goes to which end of our linked-list
			// -----------------------------------------------------------------
			// First time in, we will allow both ^ and $ being true
			if (home < 0 && end < 0 && home_active == true && end_active != true) {
				x.insert_head(word);
				System.out.println("Inserting head 1: " + word);
				// Verified - prints: men egg am the am
			} else if (home < 0 && end < 0 && end_active == true) {
				x.insert_tail(word);
				System.out.println("Inserting tail 1b: " + word);
			}
			for (int i = 0; i < word.length(); ++i) {
				// If home ^ is in position 0, then everything after it goes to head
				if (home == 0) {
					home_active = true;
					String subStr4 = word.substring(1, word.length());
					x.insert_head(subStr4);
					System.out.println("Inserting head 2: " + subStr4);
					// Next, we look at embedded home ^, with letters before and after
				} else if (end == 0 && word.length() == 1) {
					// Checking for a single $, then words afterword adding to tail
					end_active = true;
					home_active = false;
					System.out.println("Found a SINGLE $ ");
				} else if (home == i) {
					home_active = true;
					end_active = false;
					if ((word.length() - (i + 1)) == 0) {
						// If home ^ is at the first position
						String subStr5a = word.substring(0, word.length() - i);
						x.insert_tail(subStr5a);
						System.out.println("Inserting head 3: " + subStr5a);
						break;
					}
					// Home ^ is embedded in the word
					String subStr5c = word.substring(0, i);
					x.insert_tail(subStr5c);
					end_active = false;
					String subStr5b = word.substring(i + 1, word.length());
					x.insert_head(subStr5b);
					System.out.println("Inserting head 4 tail: " + subStr5c);
					System.out.println("Inserting head 4b head: " + subStr5b);
				}
			}
			for (int i = 0; i < word.length(); ++i) {
				// If $ is in position 0, then everything after it goes in tail
				if (end == i && end_active == true && word.length() != 1) {
					home_active = false;
					String subStr3 = word.substring(i + 1, word.length());
					x.insert_tail(subStr3);
					System.out.println("Inserting tail 1: " + subStr3);
				} else if (end == i && end_active != true && word.length() != 1) {
					String subStr3b = word.substring(0, i);
					x.insert_head(subStr3b);
					end_active = true;
					String subStr3c = word.substring(i + 1, word.length());
					x.insert_tail(subStr3c);
					System.out.println("Inserting head 3b tail: " + subStr3b);
					System.out.println("Inserting head 3c head: " + subStr3c);
				}
			}
			/*
			 * } else if (home < 0 && end < 0 && home_active == true) {
			 * x.insert_head(word);
			 * System.out.println("Inserting head 3: " + word);
			 * } else if (home < 0 && end < 0 && home_active == false) {
			 * x.insert_tail(word);
			 * System.out.println("Inserting tail 2: " + word);
			 * }
			 * // Now the tricky part||Separating the letters of the words
			 * for (int i = 1; i < word.length(); ++i) {
			 * if (home == i) {
			 * // prev letter(s) go to tail
			 * // trailing letter(s) go to head
			 * String subStr1 = word.substring(0, i);
			 * System.out.println("Substr1 is " + subStr1);
			 * x.insert_tail(subStr1);
			 * String subStr2 = word.substring(word.length() - i);
			 * System.out.println("Substr2 is " + subStr2);
			 * if (subStr2 != "^")
			 * x.insert_head(subStr2);
			 * }
			 * }
			 * for (int i = 1; i < word.length(); ++i) {
			 * if (end == i) {
			 * // prev letter(s) go to head
			 * // trailing letter(s) go to tail
			 * }
			 * }
			 */
		}
		kb.close();
		x.print();
		// Initialize str to line
		// StringBuffer str = new StringBuffer(line);
		// String temp = line;
		// text = text + line + "\n";
		/*
		 * ListNode head = null;
		 * ListNode tail = null;
		 * // ListNode next = null;
		 * ListNode cur = new ListNode();
		 * Character c1 = new Character('$');
		 * System.out.println("Character $ is = " + c1);
		 * // cur = head;
		 * // cur.letters = text;
		 * // System.out.println("cur.letters becomes "+text);
		 * for (int i = 0; i < count; ++i) {
		 * int counter = 0;
		 * 
		 * // Read in text until we come to a special character
		 * // Look for letters that don't have ^ or newline
		 * // if (str.charAt(i) != '^' && str.charAt(i) != '\n' && (counter <= count)) {
		 * if (str.charAt(i) != '^' && (counter <= count)) {
		 * if (str.charAt(i) == '\n') {
		 * cur.letters = cur.letters + '\n';
		 * System.out.println("The special character \n was found");
		 * } else {
		 * text = text + str.charAt(i);
		 * cur.letters = text;
		 * if (head == null) {
		 * ListNode head = new ListNode(text, cur.next);
		 * cur = head;
		 * }
		 * cur.next = null;
		 * }
		 * } else if ((str.charAt(i)) == '^' && (counter <= count)) {
		 * // Now that we found a ^ character, we must move the text
		 * // that follows to the front until we come to a $.
		 * if ((str.charAt(i)) != '$' && (counter <= count)) {
		 * System.out.println("We have found ^, letters" + cur.letters);
		 * cur.next = head;
		 * head = cur;
		 * cur.letters = text;
		 * // System.out.println("Letters after move to head " + cur.letters);
		 * } else if ((str.charAt(i)) == c1 && (counter <= count)) {
		 * System.out.println("Found $ ");
		 * while (tail != null)
		 * tail = tail.next;
		 * tail.next = cur;
		 * }
		 * }
		 * // cur.letters = text;
		 * }
		 */
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

		// text = text.substring(0, text.length() - 1); // Removing the last \n.
		// System.out.println(text);
		// TODO: text is the entire input string,
		// with home (^) and end ($) characters pressed.
		// Please write code to reconstruct the original
		// text without the home and end characters.
	}
}
