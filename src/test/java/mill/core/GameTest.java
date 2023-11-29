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

}