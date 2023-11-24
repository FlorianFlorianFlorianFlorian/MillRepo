package mill.core;

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

        this.turn = Player.OOO;
        this.PlaceCounter = 0;
    }

    public String getPlayer(){
        if(turn == Player.OOO){
            return "weiß ('O')";
        }
        else{
            return "schwarz ('X')";
        }
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

        if (chooseField[index] != Field.EMPTY) {
            return false;
        }

        /*
        Bug Report:
        when wanting to place a token at a6 it is placed to a5 put it is shown at a6 and m6.
        check out why!
         */

        chooseField[index] = token;
        PlaceCounter++;
        switchPlayer();
        return true;
        // java obj sind immer parse by referenz => also übergeben wir einfach die Speicheradresse und somit ist es direkt in inner/middle/outer gespeichert

    }

    public void drawBoard() {
        Board.drawField(inner, middle, outer);
    }

    private void switchPlayer() {
        // assume ideal conditions
        if (turn == Player.XXX) {
            turn = Player.OOO;
        } else {
            turn = Player.XXX;
        }
    }


    public boolean checkForMills() {
        // maybe use parameter String previousPlace
        // check if usefull or not
        /*
            EMPTY -> '_';
            WHITE -> 'O';
            BLACK -> 'X';
        */

        // STAND AKUTELL: stupideste Logik ever
        // NEEDS SINCERE REFACTORING

        /*
        0   1   2               1   2   3
        3       4               4       5
        5   6   7               6   7   8
         */

        // WHITE
        //          OUTER
        if(outer[0].equals(Field.WHITE) && outer[1].equals(Field.WHITE) && outer[2].equals(Field.WHITE)){
            return true;
        }
        if(outer[0].equals(Field.WHITE) && outer[3].equals(Field.WHITE) && outer[5].equals(Field.WHITE)){
            return true;
        }
        if(outer[2].equals(Field.WHITE) && outer[4].equals(Field.WHITE) && outer[8].equals(Field.WHITE)){
            return true;
        }
        if(outer[5].equals(Field.WHITE) && outer[6].equals(Field.WHITE) && outer[7].equals(Field.WHITE)){
            return true;
        }

        //          MIDDLE
        if(middle[0].equals(Field.WHITE) && middle[1].equals(Field.WHITE) && middle[2].equals(Field.WHITE)){
            return true;
        }
        if(middle[0].equals(Field.WHITE) && middle[3].equals(Field.WHITE) && middle[5].equals(Field.WHITE)){
            return true;
        }
        if(middle[2].equals(Field.WHITE) && middle[4].equals(Field.WHITE) && middle[8].equals(Field.WHITE)){
            return true;
        }
        if(middle[5].equals(Field.WHITE) && middle[6].equals(Field.WHITE) && middle[7].equals(Field.WHITE)){
            return true;
        }

        //          INNER
        if(inner[0].equals(Field.WHITE) && inner[1].equals(Field.WHITE) && inner[2].equals(Field.WHITE)){
            return true;
        }
        if(inner[0].equals(Field.WHITE) && inner[3].equals(Field.WHITE) && inner[5].equals(Field.WHITE)){
            return true;
        }
        if(inner[2].equals(Field.WHITE) && inner[4].equals(Field.WHITE) && inner[8].equals(Field.WHITE)){
            return true;
        }
        if(inner[5].equals(Field.WHITE) && inner[6].equals(Field.WHITE) && inner[7].equals(Field.WHITE)){
            return true;
        }
        // DIAGONALEN
        if(outer[1].equals(Field.WHITE) && middle[1].equals(Field.WHITE) && inner[1].equals(Field.WHITE)){
            return true;
        }
        if(outer[3].equals(Field.WHITE) && middle[3].equals(Field.WHITE) && inner[3].equals(Field.WHITE)){
            return true;
        }
        if(outer[4].equals(Field.WHITE) && middle[4].equals(Field.WHITE) && inner[4].equals(Field.WHITE)){
            return true;
        }
        if(outer[6].equals(Field.WHITE) && middle[6].equals(Field.WHITE) && inner[6].equals(Field.WHITE)){
            return true;
        }

        // BLACK
        //          OUTER
        if(outer[0].equals(Field.BLACK) && outer[1].equals(Field.BLACK) && outer[2].equals(Field.BLACK)){
            return true;
        }
        if(outer[0].equals(Field.BLACK) && outer[3].equals(Field.BLACK) && outer[5].equals(Field.BLACK)){
            return true;
        }
        if(outer[2].equals(Field.BLACK) && outer[4].equals(Field.BLACK) && outer[8].equals(Field.BLACK)){
            return true;
        }
        if(outer[5].equals(Field.BLACK) && outer[6].equals(Field.BLACK) && outer[7].equals(Field.BLACK)){
            return true;
        }

        //          MIDDLE
        if(middle[0].equals(Field.BLACK) && middle[1].equals(Field.BLACK) && middle[2].equals(Field.BLACK)){
            return true;
        }
        if(middle[0].equals(Field.BLACK) && middle[3].equals(Field.BLACK) && middle[5].equals(Field.BLACK)){
            return true;
        }
        if(middle[2].equals(Field.BLACK) && middle[4].equals(Field.BLACK) && middle[8].equals(Field.BLACK)){
            return true;
        }
        if(middle[5].equals(Field.BLACK) && middle[6].equals(Field.BLACK) && middle[7].equals(Field.BLACK)){
            return true;
        }

        //          INNER
        if(inner[0].equals(Field.BLACK) && inner[1].equals(Field.BLACK) && inner[2].equals(Field.BLACK)){
            return true;
        }
        if(inner[0].equals(Field.BLACK) && inner[3].equals(Field.BLACK) && inner[5].equals(Field.BLACK)){
            return true;
        }
        if(inner[2].equals(Field.BLACK) && inner[4].equals(Field.BLACK) && inner[8].equals(Field.BLACK)){
            return true;
        }
        if(inner[5].equals(Field.BLACK) && inner[6].equals(Field.BLACK) && inner[7].equals(Field.BLACK)){
            return true;
        }

        // DIAGONAEL
        if(outer[1].equals(Field.BLACK) && middle[1].equals(Field.BLACK) && inner[1].equals(Field.BLACK)){
            return true;
        }
        if(outer[3].equals(Field.BLACK) && middle[3].equals(Field.BLACK) && inner[3].equals(Field.BLACK)){
            return true;
        }
        if(outer[4].equals(Field.BLACK) && middle[4].equals(Field.BLACK) && inner[4].equals(Field.BLACK)){
            return true;
        }
        if(outer[6].equals(Field.BLACK) && middle[6].equals(Field.BLACK) && inner[6].equals(Field.BLACK)){
            return true;
        }




        return false;
    }

}
