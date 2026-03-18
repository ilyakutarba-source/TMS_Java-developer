import java.sql.SQLOutput;

/**
 * @author Ilya
 * @date 18.03.2026
 */

public class homeWork5Second {
    public static void main(String[] args) {

        String[][] board = new String[8][8];
        // Заполнение шахматной доски
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = "W";
                } else {
                    board[i][j] = "B";
                }
            }
        }
        // Вывод
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
