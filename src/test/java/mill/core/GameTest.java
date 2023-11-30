package mill.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    public void setup(){
        game = new Game();
    }

    @Test
    void checkForMills_firstRow_White(){
        Field[] inner  = new Field[]{Field.WHITE, Field.WHITE, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_firstRow_Black(){
        Field[] inner  = new Field[]{Field.BLACK, Field.BLACK, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_firstRow_White_False(){
        Field[] inner  = new Field[]{Field.WHITE, Field.WHITE, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_firstRow_Black_False(){
        Field[] inner  = new Field[]{Field.BLACK, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }


    @Test
    void checkForMills_ConnectionsRowTop_White(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRowTop_Black(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsLeft_White(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsLeft_Black(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRight_White(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRight_Black(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsBottom_White(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsBottom_Black(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertTrue(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRowTop_White_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRowTop_Black_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsLeft_White_false(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsLeft_Black_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRight_White_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsRight_Black_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsBottom_White_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    @Test
    void checkForMills_ConnectionsBottom_Black_False(){
        Field[] inner  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] outer  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner,middle,outer);
        assertFalse(game.checkForMills());
    }

    // @Test
    // void getPlayersToken_White_valid(){
    //     Player player = Player.OOO;
    //     assertEquals(Field.WHITE, game.getPlayersToken(player));
    //     // getPlayersToken kann man nicht JUnit-testen, weil getPlayersToken private ist
    // }

    @Test
    void checkIfValidTokenToMove_Null(){
        String thetoken = null;
        assertFalse(game.checkIfValidTokenToMove(thetoken));
    }
    @Test
    void checkIfValidTokenToMove_valid_(){
        String input = "a2";
        assertFalse(game.checkIfValidTokenToMove(input));
    }
    @Test
    void checkMoveToken_validStart(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(0, game.moveToken("a1", "a2"));
    }
    @Test
    void checkMoveToken_moveOuter1to2_valid(){
        Field[] empty  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(0, game.moveToken("a1", "a2"));
    }
    @Test
    void checkMoveToken_moveOuter1to2_a2Taken(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(3, game.moveToken("a1", "a2"));
    }
    @Test
    void checkMoveToken_moveOuter1to2_invalid_White(){
        Field[] empty  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(3, game.moveToken("a1", "a2"));
    }
    @Test
    void checkMoveToken_moveOuter1to4_valid(){
        Field[] empty  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(0, game.moveToken("a1", "a4"));
    }

    @Test
    void checkMoveToken_moveOuter2toMiddle2_valid(){
        Field[] inner            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        Field[] middle           = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(inner, middle, checkThisCircle);
        assertEquals(0, game.moveToken("a2", "m2"));

    }
    @Test
    void checkMoveToken_moveOuter2toInner2(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, empty, checkThisCircle);
        assertEquals(4, game.moveToken("a2", "i2"));

    }
    @Test
    void checkMoveToken_moveInner2toOuter2(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(checkThisCircle, empty, empty);
        assertEquals(4, game.moveToken("i2", "a2"));
    }
    @Test
    void checkMoveToken_moveInner2toInner3_valid(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(checkThisCircle, empty, empty);
        assertEquals(0, game.moveToken("i2", "i3"));
    }
    @Test
    void checkMoveToken_moveInner2toInner7_valid(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.BLACK, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(checkThisCircle, empty, empty);
        assertEquals(0, game.moveToken("i2", "i7"));
    }
    @Test
    void checkMoveToken_moveMiddle4to6_valid(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.BLACK, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.WHITE, Field.BLACK, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, checkThisCircle, empty);
        assertEquals(0, game.moveToken("m4", "m6"));
    }
    @Test
    void checkMoveToken_moveMiddle4to6_m4Empty(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};

        game.setGame(empty, empty, empty);
        assertEquals(1, game.moveToken("m4", "m6"));
    }
    @Test
    void checkMoveToken_moveMiddle4to6_m4Taken(){
        Field[] empty            = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY};
        Field[] checkThisCircle  = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.WHITE, Field.EMPTY, Field.EMPTY};
        game.setGame(empty, checkThisCircle, empty);
        assertEquals(3, game.moveToken("m4", "m6"));
    }

}