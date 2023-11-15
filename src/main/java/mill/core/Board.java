package mill.core;

public class Board {
    /*
        AUFGABEN
    Spielbrett zeichnen

     */
    public static void drawField(Field[] inner, Field[] middle, Field[] outer) {

        System.out.printf("%c----------%c----------%c\n", convertField(outer[0]), convertField(outer[1]), convertField(outer[2]));
        System.out.println("|          |          |");
        System.out.printf("|   %c------%c------%c   |\n", convertField(middle[0]), convertField(middle[1]), convertField(middle[2]));
        System.out.println("|   |      |      |   |");
        System.out.printf("|   |   %c--%c--%c   |   |\n", convertField(inner[0]), convertField(inner[1]), convertField(inner[2]));
        System.out.println("|   |   |     |   |   |");
        System.out.printf("%c---%c---%c     %c---%c---%c\n", convertField(outer[3]), convertField(middle[3]), convertField(inner[3]), convertField(inner[4]), convertField(middle[4]), convertField(outer[4]));
        System.out.println("|   |   |     |   |   |");
        System.out.printf("|   |   %c--%c--%c   |   |\n", convertField(inner[5]), convertField(inner[6]), convertField(inner[7]));
        System.out.println("|   |      |      |   |");
        System.out.printf("|   %c------%c------%c   |\n", convertField(outer[5]), convertField(inner[6]), convertField(inner[7]));
        System.out.println("|          |          |");
        System.out.printf("%c----------%c----------%c\n", convertField(outer[5]), convertField(outer[6]), convertField(outer[7]));
    }


    /*
     static void printBoard(){
        System.out.println("X----------X----------X");
        System.out.println("|          |          |");
        System.out.println("|   X------X------X   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |   |     |   |   |");
        System.out.println("X---X---X     X---X---X");
        System.out.println("|   |   |     |   |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   X------X------X   |");
        System.out.println("|          |          |");
        System.out.println("X----------X----------X");

    }

     */

}
