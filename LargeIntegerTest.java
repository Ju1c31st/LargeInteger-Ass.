/**
 * DO NOT MODIFY ANY PART OF THIS FILE.
 * We will replace this test file with a different test file
 * while automarking your submission
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargeIntegerTest {
	private LargeInteger a, b, c, d, e, f;

	@Before
	public void run() {
		a = new LargeInteger("123456789101112131415");
		b = new LargeInteger("123456789101112131415");
		c = new LargeInteger("1729");
		d = new LargeInteger("0");
		e = new LargeInteger("-123456789101112131415");
		f = new LargeInteger("-123456789101112131415");

	}

	@Test
	public void testGetWithoutLeadingZeroes() {
		assertEquals("1", LargeInteger.getWithoutLeadingZeroes("000000000001"));
		assertEquals("0", LargeInteger.getWithoutLeadingZeroes("000000000000"));
		assertEquals("-2010", LargeInteger.getWithoutLeadingZeroes("-000000000002010"));
		assertNull(LargeInteger.getWithoutLeadingZeroes(null));
		assertEquals("0", LargeInteger.getWithoutLeadingZeroes(""));
		assertEquals("0", LargeInteger.getWithoutLeadingZeroes("0"));
	}

	@Test
	public void testIsInteger() {
		assertTrue(LargeInteger.isInteger("4566745"));
		assertTrue(LargeInteger.isInteger("-4566745"));
		assertTrue(LargeInteger.isInteger("+4566745"));
		assertTrue(LargeInteger.isInteger("-004566745"));
		assertTrue(LargeInteger.isInteger("+004566745"));
		assertFalse(LargeInteger.isInteger("-+4566745"));
		assertFalse(LargeInteger.isInteger("+-4566745"));
		assertTrue(LargeInteger.isInteger("0"));
		assertFalse(LargeInteger.isInteger(""));
		assertFalse(LargeInteger.isInteger(null));
	}

	@Test
	public void testSetNumber() {
		assertTrue(a.setNumber("4547543567587345675846356578697564325350945604596350694079307946706"));
		assertTrue(a.setNumber("-4547543567587345675846356578697564325350945604596350694079307946706"));
		assertTrue(a.setNumber("+4547543567587345675846356578697564325350945604596350694079307946706"));
		assertTrue(a.setNumber("-00000004547543567587345675846356578697564325350945604596350694079307946706"));
		assertTrue(a.setNumber("+00000004547543567587345675846356578697564325350945604596350694079307946706"));
		assertFalse(a.setNumber("45475-43567587345675846356578697564325350945604596350694079307946706"));
	}

	@Test
	public void testLargeInteger() {
		a = new LargeInteger("2342424245364646475674627657583793984069804070353734024540679605464");
		assertEquals("2342424245364646475674627657583793984069804070353734024540679605464", a.getNumber());
		assertFalse(a.isNegative());
		a = new LargeInteger("-2342424245364646475674627657583793984069804070353734024540679605464");
		assertEquals("2342424245364646475674627657583793984069804070353734024540679605464", a.getNumber());
		assertTrue(a.isNegative());
	}

	@Test
	public void testToString() {
		a = new LargeInteger("-2342424245364646475674627657583793984069804070353734024540679605464");
		assertEquals("-2342424245364646475674627657583793984069804070353734024540679605464", a.toString());
		a = new LargeInteger("+2342424245364646475674627657583793984069804070353734024540679605464");
		assertEquals("2342424245364646475674627657583793984069804070353734024540679605464", a.toString());
	}

	@Test
	public void testIsNegative() {
		a = new LargeInteger("2342424245364646475674627657583793984069804070353734024540679605464");
		assertFalse(a.isNegative());
		a = new LargeInteger("0");
		assertFalse(a.isNegative());
		a = new LargeInteger("-2342424245364646475674627657583793984069804070353734024540679605464");
		assertTrue(a.isNegative());
	}

	@Test
	public void testEqualsObject() {
		assertFalse(c.equals("1729"));
		assertTrue(a.equals(b));
		assertTrue(e.equals(f));
		assertFalse(a.equals(c));
		assertFalse(a.equals(d));
		assertFalse(a.equals(e));
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, a.compareTo(b));
		assertEquals(1, a.compareTo(c));
		assertEquals(1, a.compareTo(d));
		assertEquals(1, a.compareTo(e));
		assertEquals(0, e.compareTo(f));
		assertEquals(-1, e.compareTo(c));
		assertEquals(-1, e.compareTo(d));
	}

	@Test
	public void testNegate() {
		assertEquals(a.negate(), e);
		assertEquals(f.negate(), b);
	}

	@Test
	public void testAbsolute() {
		assertEquals(e.absolute(), a);
		assertNotEquals(e.absolute(), e);
		assertEquals(d.absolute(), d);
		assertEquals(c.absolute(), c);
	}

	@Test
	public void testCompareAbsolutes() {
		assertEquals(0, a.compareAbsolutes(e));
		assertEquals(1, e.compareAbsolutes(c));
		assertEquals(-1, d.compareAbsolutes(f));
	}

	@Test
	public void testAdd() {
		e = new LargeInteger("1729");
		f = new LargeInteger("812");
		assertEquals("2541", e.add(f).toString());

		e = new LargeInteger("999999");
		f = new LargeInteger("1");
		assertEquals("1000000", e.add(f).toString());

		e = new LargeInteger("1000000");
		f = new LargeInteger("-1");
		assertEquals("999999", e.add(f).toString());

		e = new LargeInteger("-999999");
		f = new LargeInteger("-1");
		assertEquals("-1000000", e.add(f).toString());

		e = new LargeInteger("-1000000");
		f = new LargeInteger("1");
		assertEquals("-999999", e.add(f).toString());


		a = new LargeInteger("008045268402406860428629358926947629674962496349724596734697469729627624824068240624682406840682078205028642068058325068240842503826048602485023");
		b = new LargeInteger("05406735906926036045876028605482760485607830548270854058670487");
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", a.add(b).toString());
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", b.add(a).toString());

		c = new LargeInteger("-008045268402406860428629358926947629674962496349724596734697469729627624824068240624682406840682078205028642068058325068240842503826048602485023");
		d = new LargeInteger("-05406735906926036045876028605482760485607830548270854058670487");

		assertEquals("-8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", c.add(b).toString());
		assertEquals("-8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", b.add(c).toString());
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", a.add(d).toString());
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", d.add(a).toString());
		assertEquals("0", a.add(c).toString());
	}

	@Test
	public void testSubtract() {
		e = new LargeInteger("1729");
		f = new LargeInteger("812");
		assertEquals("917", e.subtract(f).toString());
		assertEquals("-917", f.subtract(e).toString());

		f = new LargeInteger("-812");
		assertEquals("2541", e.subtract(f).toString());
		assertEquals("-2541", f.subtract(e).toString());

		e = new LargeInteger("1000000");
		f = new LargeInteger("1");
		assertEquals("999999", e.subtract(f).toString());

		e = new LargeInteger("999999");
		f = new LargeInteger("-1");
		assertEquals("1000000", e.subtract(f).toString());
		assertEquals("-1000000", f.subtract(e).toString());

		e = new LargeInteger("-999999");
		f = new LargeInteger("1");
		assertEquals("-1000000", e.subtract(f).toString());

		e = new LargeInteger("-1000000");
		f = new LargeInteger("1");
		assertEquals("-1000001", e.subtract(f).toString());


		a = new LargeInteger("008045268402406860428629358926947629674962496349724596734697469729627624824068240624682406840682078205028642068058325068240842503826048602485023");
		b = new LargeInteger("05406735906926036045876028605482760485607830548270854058670487");
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", a.subtract(b).toString());
		assertEquals("-8045268402406860428629358926947629674962496349724596734697469729627624824068240619275670933756042159152613462575564582633011955555194543814536", b.subtract(a).toString());

		c = new LargeInteger("-008045268402406860428629358926947629674962496349724596734697469729627624824068240624682406840682078205028642068058325068240842503826048602485023");
		d = new LargeInteger("-05406735906926036045876028605482760485607830548270854058670487");

		e = new LargeInteger("008045268402406860428629358926947629674962496349724596734697469729627624824068240624682406840682078205028642068058325068240842503826048602485023");
		
		assertEquals("-8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", c.subtract(b).toString());
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", b.subtract(c).toString());
		assertEquals("8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", a.subtract(d).toString());
		assertEquals("-8045268402406860428629358926947629674962496349724596734697469729627624824068240630089142747608114250904670673541085553848673052096902661155510", d.subtract(a).toString());
		assertEquals("0", a.subtract(e).toString());
	}
}
