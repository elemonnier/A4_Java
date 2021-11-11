public class Main {
    public static void testPrint() {
        MineSweeper ms = new MineSweeper(4, 6);
        ms.print();
    }

    public static void testPutMines() {
        MineSweeper ms = new MineSweeper(3, 3);
//        ms.putMines(2);
        ms.print();
    }

    public static void testPutMinesConstructor() {
        MineSweeper ms = new MineSweeper(10, 10, 85);
        ms.print();
    }

    public static void testUnveil() {
        MineSweeper ms = new MineSweeper(9, 9, 10);
        ms.unveil(1,2);
        ms.print();
    }

    public static void testPlay() {
        MineSweeper ms = new MineSweeper(16,16 ,10);
        ms.play();
    }

    /** <ul><li>Beginner: 9x9 10 mines </li><li>
     Intermediate: 16x16 40 mines</li><li>
     Expert: 16x30 99 mines</li></ul> */



    public static void main(String[] args) {
        testPlay();
    }
}


