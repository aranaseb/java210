/**
 * StringSet objects store a set of strings.
 * 
 * @author Rick Mercer and Sebastian Arana
 */

public class StringSet {

	String[] set;

	// Construct an empty set (no elements yet)
	public StringSet(int capacity) {
		set = new String[capacity];
	}

	// Add a string to this StringSet if it is not already in this StringSet.
	// This StringSet may be filled to capacity. If so, grow the array.
	public boolean add(String stringToAdd) {
		if (!contains(stringToAdd)) {
			if (size() == set.length) {
				String[] newSet = new String[set.length + 1];
				for (int i = 0; i < set.length; i++) {
					newSet[i] = set[i];
				}
				set = newSet;
			}
			set[size()] = stringToAdd;
			return true;
		}
		return false;
	}

	// Determine if stringToAdd is, or is not in this set
	public boolean contains(String stringToAdd) {
		for (int i = 0; i < size(); i++) {
			if (set[i].equals(stringToAdd)) {
				return true;
			}
		}
		return false;
	}

	// Return how many consecutive meaningful elements are in the array
	public int size() {
		int i = 0;
		while (i < set.length && set[i] != null) {
			i++;
		}
		return i;
	}

	// Return true if there are no elements in this set
	public boolean isEmpty() {
		return size() == 0;
	}

	// toString shows all elements surrounded by curly braces { } and
	// all elements separated by ", " as shown in this @Test method.
	//
	// @Test
	// public void testToString() {
	// StringSet names = new StringSet(10);
	// assertEquals("{}", names.toString());
	// assertTrue(names.add("Kim"));
	// assertEquals("{Kim}", names.toString());
	// assertTrue(names.add("Chris"));
	// assertEquals("{Kim, Chris}", names.toString());
	// assertTrue(names.add("Devon"));
	// assertEquals("{Kim, Chris, Devon}", names.toString());
	// assertTrue(names.add("Ali"));
	// assertEquals("{Kim, Chris, Devon, Ali}", names.toString());
	// }
	//
	public String toString() {
		String result = "{";
		for (int i = 0; i < size(); i++) {
			result += set[i];
			if (i != size() - 1) {
				result += ", ";
			}
		}
		return result + "}";

	}

	// Remove element if it is in this set and return true, otherwise leave
	// this set unchanged and return false
	public boolean remove(String element) {
		if (contains(element)) {
			String[] newSet = new String[set.length];
			boolean found = false;
			for (int i = 0; i < size(); i++) {
				if (set[i].equals(element)) {
					found = true;
				} else {
					if (!found) {
						newSet[i] = set[i];
					} else {
						newSet[i - 1] = set[i];
					}
				}
			}
			set = newSet;
			return true;
		}
		return false;
	}

	// Complete method intersection to return the intersection of two StringSets.
	// oneStringSet.intersection(StringSet other) returns a StringSet that contains
	// all elements of oneStringSet that also belong to other. For example,
	// {"a", "b", "c"}.intersection ({"b", "c", "d"})) returns {"b", "c"}
	// Do not modify either StringSet involved in the message.
	//
	public StringSet intersection(StringSet other) {
		StringSet largerSet;
		StringSet smallerSet;
		if (size() < other.size()) {
			largerSet = this;
			smallerSet = other;
		} else {
			largerSet = other;
			smallerSet = this;
		}
		StringSet newSet = new StringSet(0);
		for (int i = 0; i < largerSet.size(); i++) {
			if (smallerSet.contains(largerSet.set[i])) {
				newSet.add(largerSet.set[i]);
			}
		}
		return newSet;
	}

	// Complete method union to return the union of two StringSets.
	// oneStringSet.union(StringSet other) should return a StringSet that contains
	// all
	// elements that are in oneStringSet or in other, possibly both. For example,
	// {"a", "b", "c", "f"}.union( {"b", "c", "e"}) returns {"a", "b", "c", "e",
	// "f"}.
	// Do not modify either StringSet involved in the message.
	//
	public StringSet union(StringSet other) {
		StringSet newSet = new StringSet(0);
		for (String item : set) {
			newSet.add(item);
		}
		for (String item2 : other.set) {
			newSet.add(item2);
		}
		return newSet;
	}
}