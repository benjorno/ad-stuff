package aufgabenblatt6;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testklasse
 * 
 * @author 
 *
 */
public class HuffmanTest {


  @Test
  public void testeVerschluesseln() {
    HuffmanCodierung code = new HuffmanCodierung();
    try {
      byte[] array = code
          .verschluesseln("If you give someone a program you will frustrate them for a day? If you teach them how to"
              + "program, you will frustrate them for a lifetime. The computing scientist?s main challenge is not to"
              + " get confused by the complexities of his own making. Beauty is more important in computing than"
              + " anywhere else in technology because software is so complicated. Beauty is the ultimate defence"
              + " against complexity");
      assertEquals("Fehler",
          "If you give someone a program you will frustrate them for a day? If you teach them how to"
              + "program, you will frustrate them for a lifetime. The computing scientist?s main challenge is not to"
              + " get confused by the complexities of his own making. Beauty is more important in computing than"
              + " anywhere else in technology because software is so complicated. Beauty is the ultimate defence"
              + " against complexity",
          code.entschluesseln(array));
    } catch (Exception e) {
      // TODO Auto-generated catch block
    }
  }
  
  @Test
  public void teste1fall() {
	  HuffmanCodierung code = new HuffmanCodierung();
    try {
      byte[] array=code.verschluesseln("ab");
      
      assertEquals("Fehler","ab",code.entschluesseln(array));
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
    }
  }
  
  @Test
  public void teste2fall() {
	  HuffmanCodierung code = new HuffmanCodierung();
    try {
      byte[] array=code.verschluesseln("a");
      assertEquals("a", code.entschluesseln(array));
    } catch (Exception e) {
      assertTrue(true);
    }
  }
  
  @Test
  public void teste3fall() {
	  HuffmanCodierung code = new HuffmanCodierung();
    try {
      byte[] array=code.verschluesseln("im westen nichts neues");
      assertEquals("Fehler","im westen nichts neues",code.entschluesseln(array));
    } catch (Exception e) {
  
    }
  }
  
} 
  



