package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Choice;
import model.GameTree;

class GameTreeTest {

  @Test
  public void testGameWithSevenNodes() {
    // This test uses the input file animals.txt
    // This string should be returned from toString():
    //
    // - - rattlesnake
    // - Is it a mammal?
    // - - tiger
    // Has feathers?
    // - - owl
    // - Barnyard?
    // - - chicken

    // Simulate running the Game:
    GameTree aGame = new GameTree("animals.txt");
    assertFalse(aGame.foundAnswer());
    assertEquals("Has feathers?", aGame.getCurrent());
    assertFalse(aGame.foundAnswer());
    
    aGame.playerSelected(Choice.YES);
    assertEquals("Barnyard?", aGame.getCurrent());
    assertFalse(aGame.foundAnswer());
   
    aGame.playerSelected(Choice.NO);
    assertEquals("owl", aGame.getCurrent());
    assertTrue(aGame.foundAnswer());  
  }
}