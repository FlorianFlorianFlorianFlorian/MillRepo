package mill.core;

import java.util.Arrays;

public class Game {
    private Field[] inner;
    private Field[] middle;
    private Field[] outer;

    private Player turn;
    private int PlaceCounter;

    public Game() {
        this.inner = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.outer = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};

        this.turn = Player.XXX;
        this.PlaceCounter = 0;
    }

    public boolean placeToken(String placeToBe) {
        // Annahme: nur valide Inputs
        // maybe implement a timer <= 18
        // wenn timer ture, dann Spielphase 2

        Field token;

        // welcher Spieler
        if (turn == Player.OOO) {
            token = Field.WHITE;
        } else {
            token = Field.BLACK;
        }

        // Wohin?
        // = placeToBe
        char[] location = placeToBe.toCharArray();

        Field[] chooseField = null;
        switch (location[0]) {
            case 'i': {
                chooseField = inner;
                break;
            }
            case 'm': {
                chooseField = middle;
                break;
            }
            case 'a': {
                chooseField = outer;
                break;
            }
        }

        int index = location[1] - '1';
        // ASCII magic

        if(chooseField[index] != Field.EMPTY){
            return false;
        }

        chooseField[index] = token;
        switchPlayer();
        return true;
        // java obj sind immer parse by referenz => also übergeben wir einfach die Speicheradresse und somit ist es direkt in inner/middle/outer gespeichert

    }

    public void drawBoard() {
        Board.drawField(inner, middle, outer);
    }

    private void switchPlayer(){
        // assume ideal conditions
        if(turn == Player.XXX){
            turn = Player.OOO;
        }
        else {
            turn = Player.XXX;
        }
    }
}
