package aufgabenblatt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CListTest {
	public IList createListe() {
		return new CList();
	}

	@Test
	public void insertElement() {
		IList liste = this.createListe();
		Element element = new Element();
		try {
			liste.insert(0,  new Element());
			liste.insert(1,  new Element());
			liste.insert(2,  element);
			liste.insert(3,  new Element());
		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		assertEquals("Equals", 4, liste.size());
	}

	@Test
	public void insertPreConditionFile() {
		IList liste = this.createListe();
		Element element = new Element();

		try {
			liste.insert(0, null);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.insert(1, element);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.insert(-23, element);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}

	}
	@Test
	public void delete() {
		IList liste = this.createListe();
		Element element = new Element();
		try {
			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, element);
			
			liste = liste.delete(2);
		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		assertEquals("Equals", 3, liste.size());
	}
	
	@Test
	public void deletePreConditionFile() {
		IList liste = this.createListe();
		@SuppressWarnings("unused")
		Element element = new Element();

		try {
			liste.delete(10);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.delete(-332);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.delete(0);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}

	}	
	@Test
	public void find() {
		IList liste = this.createListe();
		int findPos = 0;
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());

			Element element = new Element();
			liste.insert(4, element);
			
			findPos = liste.find(element);

		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		assertEquals("Equals", 4, findPos);
	}
	
	@Test
	public void findNotValidate() {
		IList liste = this.createListe();
		int findPos = 0;
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());
			
			findPos = liste.find(null);
			assertEquals("Equals", -1, findPos);
			findPos = liste.find(new Element());
			assertEquals("Equals", -1, findPos);
			
		} catch (Exception e) {
			fail("Insert wirft exception");
		}
	}

	@Test
	public void retrieve() {
		IList liste = this.createListe();
		Element findElement = null ;
		Element element = new Element() ;
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());

			element = new Element();
			liste.insert(4, element);
			
			findElement = liste.retrieve(4);
			assertEquals("Equals", findElement, element);
			findElement = liste.retrieve(1);

		} catch (Exception e) {
			fail("Insert wirft exception");
		}

		
	}
	
	@Test
	public void retrieveFails() {
		IList liste = this.createListe();

		try {
			liste.retrieve(4);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.retrieve(-332);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		try {
			liste.retrieve(0);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
		     assertEquals(e.getMessage(), null);
		}
		
		@SuppressWarnings("unused")
		Element findElement = null;
		Element element = new Element();
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());

			element = new Element();
			liste.insert(4, element);
			
			findElement = liste.retrieve(5);
			fail("Exception hatte gewuerfen werden mussen.");
		} catch (Exception e) {
			 assertEquals(e.getMessage(), null);
		}

	}

	@Test
	public void concat() {
		IList liste = this.createListe();
		IList liste2 = this.createListe();
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());

		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		
		try {

			liste2.insert(0, new Element());
			liste2.insert(1, new Element());
			liste2.insert(2, new Element());
			liste2.insert(3, new Element());
          liste = liste.concat(liste2);
		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		assertEquals("Equals",8 , liste.size());
	}
	
	@Test
	public void concatFails() {
		IList liste = this.createListe();
		IList liste2 = this.createListe();
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());
			
			liste =liste.concat(liste2);

		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		
		assertEquals("Equals",4 , liste.size());

	}

	@Test
	public void size() {
		IList liste = this.createListe();
		IList liste2 = this.createListe();
		try {

			liste.insert(0, new Element());
			liste.insert(1, new Element());
			liste.insert(2, new Element());
			liste.insert(3, new Element());

		} catch (Exception e) {
			fail("Insert wirft exception");
		}
		assertEquals("Equals",0 , liste2.size());
		assertEquals("Equals",4 , liste.size());
	}

}


