
/**
 * A JUnit test for class StringSet.
 * 
 * @author Sebastian Arana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringSetTest {

	@Test
	public void test() {
		StringSet set = new StringSet(0);
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		StringSet set2 = new StringSet(Integer.MAX_VALUE / 10000);
		assertEquals(0, set2.size());
		assertTrue(set2.isEmpty());
	}

	@Test
	public void testAdd() {
		StringSet set = new StringSet(3);
		set.add("fortnite");
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
		set.add("fortnite2");
		assertEquals(2, set.size());
		set.add("fortnite3");
		assertEquals(3, set.size());
		set.add("fortnite4");
		assertEquals(4, set.size());
	}

	@Test
	public void testContains() {
		StringSet set = new StringSet(10);
		set.add("fortnite");
		assertTrue(set.contains("fortnite"));
		set.add("fortnite victory royal");
		assertFalse(set.contains("fortnite vicroy royal"));
		assertTrue(set.contains("fortnite victory royal"));
		assertFalse(set.contains("apex losers"));
	}

	@Test
	public void testRemove() {
		StringSet set = new StringSet(5);
		assertTrue(set.add("skibidi toilet"));
		assertTrue(set.add("gyat"));
		assertTrue(set.add("rizz"));
		assertTrue(set.add("mewing"));
		assertTrue(set.add("edging"));
		assertFalse(set.remove("sigma"));
		assertEquals(5, set.size());
		assertTrue(set.remove("edging"));
		assertFalse(set.contains("edging"));
		assertEquals(4, set.size());
	}

	@Test
	public void testToString() {
		StringSet names = new StringSet(10);
		assertEquals("{}", names.toString());
		assertTrue(names.add("Kim"));
		assertEquals("{Kim}", names.toString());
		assertTrue(names.add("Chris"));
		assertEquals("{Kim, Chris}", names.toString());
		assertTrue(names.add("Devon"));
		assertEquals("{Kim, Chris, Devon}", names.toString());
		assertTrue(names.add("Ali"));
		assertEquals("{Kim, Chris, Devon, Ali}", names.toString());
		assertTrue(names.add("Leonid Brezhnev - former general secretary of the USSR"));
		assertFalse(names.add("Leonid Brezhnev - former general secretary of the USSR"));
		assertEquals("{Kim, Chris, Devon, Ali, Leonid Brezhnev - former general secretary of the USSR}",
				names.toString());
	}

	@Test
	public void testIntersection() {
		StringSet coolDudes = new StringSet(46);
		coolDudes.add("Mikhail Gorbachev");
		coolDudes.add("Nikita Khrushchev");
		coolDudes.add("J Robert Oppenheimer");
		coolDudes.add("Leon Trotsky");
		coolDudes.add("Tyler Ninja Blevins");
		coolDudes.add("Rick Grimes");
		coolDudes.add("Joe Rogan");
		StringSet lameDudes = new StringSet(5);
		lameDudes.add("Jeff");
		lameDudes.add("Joseph Stalin");
		lameDudes.add("J Robert Oppenheimer");
		lameDudes.add("Jared Leto");
		lameDudes.add("Mikhail Gorbachev");
		lameDudes.add("Tyler Ninja Blevins");
		lameDudes.add("Jon Bernthal");
		lameDudes.add("I don't take naps it's for the birds man");
		lameDudes.add("Rick Grimes");
		lameDudes.add("Goku");
		StringSet lameCoolDudes = coolDudes.intersection(lameDudes);
		assertEquals(4, lameCoolDudes.size());
		assertTrue(lameCoolDudes.contains("J Robert Oppenheimer"));
		assertFalse(lameCoolDudes.contains("Lared Jeto"));
		assertFalse(lameCoolDudes.contains("Jared Leto"));
		assertTrue(lameCoolDudes.contains("Mikhail Gorbachev"));
		assertFalse(lameCoolDudes.contains("I don't take naps it's for the birds man"));
		assertTrue(lameCoolDudes.contains("Rick Grimes"));
		assertTrue(lameCoolDudes.contains("Tyler Ninja Blevins"));
		assertFalse(lameCoolDudes.contains("Jeff"));
		assertFalse(lameCoolDudes.contains("Joe Rogan"));

		StringSet primeNumbers = new StringSet(3);
		primeNumbers.add("My name is Walter hartwell white and I am a prime number");
		primeNumbers.add("I write quality unit tests");
		primeNumbers.add("21 (an actual prime number)");
		StringSet compositeNumbers = new StringSet(3);
		compositeNumbers.add("My name is Walter hartwell White and I am not a prime number");
		compositeNumbers.add("kid named finger");
		StringSet fusionDance = primeNumbers.intersection(compositeNumbers);
		assertEquals(0, fusionDance.size());
		assertFalse(fusionDance.contains("I write quality unit tests"));

	}

	@Test
	public void testUnion() {
		StringSet presidents = new StringSet(5);
		presidents.add("George Washington");
		presidents.add("Ben Franklin");
		presidents.add("John Hanson");
		presidents.remove("George Washington");
		presidents.add("President Walter White");
		presidents.add("Martin Luther of the Protestant reformation (he nailed his 95 theses to the door of a church)");
		StringSet opps = new StringSet(5);
		opps.add("Joseph Stalin");
		opps.add("Mao Zedong");
		opps.add("Benito Mussolini");
		opps.add("George Bush");
		opps.add("Osama Bin Laden");
		opps.add("Nikocado Avocado");
		opps.add("James Corden");
		StringSet worldPeace = presidents.union(opps);
		assertEquals(11, worldPeace.size());
		assertTrue(worldPeace.contains(
				"Martin Luther of the Protestant reformation (he nailed his 95 theses to the door of a church)"));
		worldPeace.remove("James Corden");
		assertFalse(worldPeace.contains("James Corden"));
		assertTrue(worldPeace.contains("Nikocado Avocado"));
		StringSet partOne = new StringSet(1);
		partOne.add("Rick Grimes");
		StringSet partTwo = new StringSet(1);
		partTwo.add("Saul Goodman");
		StringSet betterCallRickGrimes = partOne.union(partTwo);
		assertEquals(2, betterCallRickGrimes.size());
		assertFalse(betterCallRickGrimes.contains("Anything but rick grimes and saul goodman"));
	}

}
