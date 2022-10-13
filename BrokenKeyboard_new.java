import java.security.cert.LDAPCertStoreParameters;
import java.util.Scanner;
import org.omg.PortableInterceptor.NON_EXISTENT;
import java.lang.Integer;

public class BrokenKeyboard_new {

	public static void main(String[] args) {

		ListNode[] table;
		int size;
		Scanner kb = new Scanner(System.in);
		ListSet x = new ListSet();
		String text = "";
		boolean home_active = true;
		boolean end_active = false;
		boolean not_front = false;
		boolean new_line = false;
		while (kb.hasNext()) {

			String line = kb.nextLine();
			while (line.length() != 0) {
				int count = line.length();
				System.out.println("The line length is = " + count);
				int home = line.indexOf('^');
				int end = line.indexOf('$');
				int homeOffset = line.indexOf('^');
				System.out.println("Index of ^ in line is " + homeOffset);
				int endOffset = line.indexOf('$');
				System.out.println("Index of $ in line is " + endOffset);
				// ----------------------------------------------------------------
				// First check home ^, if found, everything after ^ up to the next $
				// will be put in front of the existing string
				// * Interesting Note * none of the words have both ^ and $ in them
				// which means, we can separate words based on the single character
				// and then parse which piece goes to which end of our linked-list
				// -----------------------------------------------------------------
				// First time in, we are looking for words without any ^ or $
				if (home < 0 && end < 0 && home_active == true && end_active != true) {
					x.insert_head(" " + line + " ");
					System.out.println("Inserting head 1: " + line);
					home_active = true;
					// Verified - prints: men
					break;
				}
				// Case where home ^ comes before end $
				// while (homeOffset >= 0 && endOffset >= 0) {
				if (homeOffset < endOffset && home_active == true && end_active != true) {
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					// Initially, get letters before 1st Offset
					// prints 'I'
					String subStr6a = line.substring(0, homeOffset);
					x.insert_behind_head(subStr6a);
					System.out.println("Inserting behind head 6a: " + subStr6a);
					// home_active is already true
					// Keeping offset conditions (i.e. home = 1, end = 7)
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					// After initial home ^, now we traverse through more offsets
					// prints 'egg'
					String subStr6aa = line.substring(homeOffset + 1, endOffset);
					x.insert_head(subStr6aa + " ");
					System.out.println("Inserting head 6aa: " + subStr6aa);
					not_front = true;
					// Next, we must increment home ^ to the next offset
					if (homeOffset != -1) {
						System.out.println("Home offset = " + homeOffset);
						homeOffset = line.indexOf('^', ++homeOffset);
						if (homeOffset == -1)
							break;
					}
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					// Now endOffset < homeOffset
					// Trying to get 'an' in the right place
				}
				if (endOffset < homeOffset) {
					String temp = line.substring(0, 3);
					int bk = temp.indexOf('$');
					if (endOffset > 0 && bk > 0) {
						// We have letters before end $ to take care of
						System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
						String subStr6f = line.substring(0, endOffset);
						x.insert_behind_head(subStr6f);
						System.out.println("Inserting head 6f: " + subStr6f);
					} // Maintain current offset values, and continue
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					String subStr6c = line.substring(endOffset + 1, homeOffset);
					x.insert_tail(subStr6c);
					System.out.println("Inserting tail 6b: " + subStr6c);
					// end_active = true;
					if (endOffset != -1) {
						System.out.println("End offset = " + endOffset);
						endOffset = line.indexOf('$', ++endOffset);
						if (endOffset == -1)
							break;
					}
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					// Case of end $ being first offset in line
				}
				if (homeOffset < endOffset) {
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					String subStr6b = line.substring(homeOffset + 1, endOffset);
					x.insert_head(subStr6b);
					System.out.println("Inserting head 6c: " + subStr6b);
					home_active = true;
					if (homeOffset != -1) {
						System.out.println("Home offset = " + homeOffset);
						homeOffset = line.indexOf('^', ++homeOffset);
						if (homeOffset == -1)
							break;
					}
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
				}
				if (endOffset < homeOffset) {
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					String subStr6d = line.substring(endOffset + 1, homeOffset);
					x.insert_tail(subStr6d);
					System.out.println("Inserting tail 6d: " + subStr6d);
					if (endOffset != -1) {
						System.out.println("End offset = " + endOffset);
						endOffset = line.indexOf('$', ++endOffset);
						if (endOffset == -1)
							break;
					}
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
				}
				if (homeOffset < endOffset) {
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					String subStr6e = line.substring(homeOffset + 1, endOffset);
					x.insert_head(subStr6e);
					System.out.println("Inserting head 6e: " + subStr6e);
					home_active = true;
					if (homeOffset != -1) {
						System.out.println("Home offset = " + homeOffset);
						homeOffset = line.indexOf('^', ++homeOffset);
						if (homeOffset == -1 && endOffset <= line.length()) {
							// Last part of the line
							String subStr6ee = line.substring(endOffset + 1, line.length());
							x.insert_tail(subStr6ee + " ");
							System.out.println("Inserting tail 6ee: " + subStr6ee);
							break;
						} else
							break;
					}
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
				}
				if (homeOffset == 0 && endOffset < 0) {
					// Initially, get letters before 1st Offset
					System.out.println("homeOffset = " + homeOffset + " endOffset = " + endOffset);
					String subStr4 = line.substring(1, line.length());
					x.insert_head(subStr4 + " ");
					System.out.println("Inserting head 2: " + subStr4);
					break;
				}

			}
			// }
			/*
			 * if (homeOffset == 0 && endOffset < 0) {
			 * String subStr4 = line.substring(1, line.length());
			 * x.insert_head(subStr4 + " ");
			 * System.out.println("Inserting head 2: " + subStr4);
			 * home_active = true;
			 * }
			 */
			/*
			 * for (int i = 0; i < line.length(); ++i) {
			 * // If home ^ is in position 0, then everything after it goes to head
			 * if (home == 0 && end < 0) {
			 * home_active = true;
			 * String subStr4 = line.substring(1, line.length());
			 * x.insert_head(subStr4 + " ");
			 * System.out.println("Inserting head 2: " + subStr4);
			 * // end_active = false;
			 * // prev_letter = true;// without a newline before
			 * break;
			 * // Next, we look at embedded home ^, with letters before and after
			 * }
			 *
			 * 
			 * // Home ^ is embedded in the word
			 * String subStr5c = line.substring(0, i);
			 * x.insert_tail(subStr5c);
			 * end_active = false;
			 * String subStr5b = line.substring(i + 1, line.length());
			 * x.insert_head(subStr5b + " ");
			 * System.out.println("Inserting head 4 tail: " + subStr5c);
			 * System.out.println("Inserting head 4b head: " + subStr5b);
			 */

			/*
			 * for (int i = 0; i < line.length(); ++i) {
			 * // If $ is in position 0, then everything after it goes in tail
			 * if (end == i && end_active == true && line.length() != 1) {
			 * home_active = false;
			 * String subStr3 = line.substring(i + 1, line.length());
			 * x.insert_tail(subStr3);
			 * System.out.println("Inserting tail 1: " + subStr3);
			 * } else if (end == i && end_active != true && line.length() != 1) {
			 * String subStr3b = line.substring(0, i);
			 * x.insert_behind_head(subStr3b);
			 * end_active = true;
			 * // String subStr3c = line.substring(i + 1, line.length());
			 * // x.insert_tail(subStr3c + " ");
			 * System.out.println("Inserting head 3b head: " + subStr3b);
			 * // System.out.println("Inserting head 3c tail: " + subStr3c);
			 * }
			 * }
			 */
		}
		kb.close();
		x.print();
	}
}
