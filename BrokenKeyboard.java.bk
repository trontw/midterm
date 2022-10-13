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
		boolean prev_letter = false;
		boolean new_line = false;
		while (kb.hasNext()) {

			String word = kb.next();
			int count = word.length();
			// System.out.println("The word length is = " + count);
			int home = word.indexOf('^');
			// System.out.println("Index of ^ in word is " + home);
			int end = word.indexOf('$');
			// System.out.println("Index of $ in word is " + end);
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
				// if (prev_letter == true && new_line != true) {
				// x.insert_behind_head(word);
				// } else {
				x.insert_head(" " + word + " ");
				// }
				// System.out.println("Inserting head 1: " + word);
				// Verified - prints: men egg am the am
			} else if (home < 0 && end < 0 && end_active == true) {
				x.insert_tail(word + " ");
				// System.out.println("Inserting tail 1b: " + word);
			}
			for (int i = 0; i < word.length(); ++i) {
				// If home ^ is in position 0, then everything after it goes to head
				if (home == 0) {
					home_active = true;
					String subStr4 = word.substring(1, word.length());
					x.insert_head(subStr4 + " ");
					// System.out.println("Inserting head 2: " + subStr4);
					end_active = false;
					prev_letter = true;// without a newline before
					break;
					// Next, we look at embedded home ^, with letters before and after
				} else if (end == 0 && word.length() == 1) {
					// Checking for a single $, then words afterword adding to tail
					end_active = true;
					home_active = false;
					// System.out.println("Found a SINGLE $ ");
				} else if (home == i) {
					home_active = true;
					end_active = false;
					if ((word.length() - (i + 1)) == 0) {
						// If home ^ is at the first position
						String subStr5a = word.substring(0, word.length() - 1);
						x.insert_tail(subStr5a + " ");
						// System.out.println("Inserting head 3: " + subStr5a);
						break;
					}
					// Home ^ is embedded in the word
					String subStr5c = word.substring(0, i);
					x.insert_tail(subStr5c);
					end_active = false;
					String subStr5b = word.substring(i + 1, word.length());
					x.insert_head(subStr5b + " ");
					// System.out.println("Inserting head 4 tail: " + subStr5c);
					// System.out.println("Inserting head 4b head: " + subStr5b);
				}
			}
			for (int i = 0; i < word.length(); ++i) {
				// If $ is in position 0, then everything after it goes in tail
				if (end == i && end_active == true && word.length() != 1) {
					home_active = false;
					String subStr3 = word.substring(i + 1, word.length());
					x.insert_tail(subStr3);
					// System.out.println("Inserting tail 1: " + subStr3);
				} else if (end == i && end_active != true && word.length() != 1) {
					String subStr3b = word.substring(0, i);
					x.insert_behind_head(subStr3b);
					end_active = true;
					String subStr3c = word.substring(i + 1, word.length());
					x.insert_tail(subStr3c + " ");
					// System.out.println("Inserting head 3b head: " + subStr3b);
					// System.out.println("Inserting head 3c tail: " + subStr3c);
				}
			}
		}
		kb.close();
		x.print();
	}
}
