import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class SudokuTest extends SudokuTest6 {
    @Test
    public void allTest() {
        Sudoku sudoku = new Sudoku();

        Assertions.assertEquals("не корректно", sudoku.eval(notCorrectArray1));
        Assertions.assertEquals("не корректно", sudoku.eval(notCorrectArray2));
        Assertions.assertEquals("не корректно", sudoku.eval(notCorrectArray3));
        Assertions.assertEquals("не корректно", sudoku.eval(notCorrectArray4));
        Assertions.assertEquals("не корректно", sudoku.eval(notCorrectArray5));
        Assertions.assertEquals("корректно", sudoku.eval(correctArray1));
        Assertions.assertEquals("корректно", sudoku.eval(correctArray2));
        Assertions.assertEquals("корректно", sudoku.eval(correctArray3));
        Assertions.assertEquals("корректно", sudoku.eval(correctArray4));
        Assertions.assertEquals("корректно", sudoku.eval(correctArray5));

        for (int j = 0; j < 10; j++) {
            LocalDateTime start = LocalDateTime.now();
            for (int i = 0; i < 1000000; i++) {
                sudoku.eval(correctArray1);
                sudoku.eval(correctArray2);
                sudoku.eval(correctArray3);
                sudoku.eval(correctArray4);
                sudoku.eval(correctArray5);
            }
            LocalDateTime finish = LocalDateTime.now();

            System.out.println("Sudoku: "
                    + start.until(finish, ChronoUnit.MILLIS));
        }
    }
}