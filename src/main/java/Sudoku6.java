public class Sudoku6 {

    static final int SQUARE_FULL_SIZE = 9;
    static final int SQUARE_PART_SIZE = 3;
    static final int[] CONTROL_LINE = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static final String IS_CORRECT = "корректно";
    static final String IS_NOT_CORRECT = "не корректно";


    public String eval(int[][] sudoku) {
        for (int i = 0; i < SQUARE_FULL_SIZE; i++) {
            if (!isCorrect9(getLine(sudoku, i))) {
                return IS_NOT_CORRECT;
            } else if (!isCorrect9(getColumn(sudoku, i))) {
                return IS_NOT_CORRECT;
            } else if (!isCorrect9(getSquare(sudoku, i))) {
                return IS_NOT_CORRECT;
            }
        }
        return IS_CORRECT;
    }


    int[] getLine(int[][] matrix, int index) {
        return matrix[index];
    }


    int[] getColumn(int[][] matrix, int index) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }


    int[] getSquare(int[][] matrix, int squareNum) {
        int[] square = new int[matrix.length];
        int rowIndex = squareNum / SQUARE_PART_SIZE;
        int colIndex = squareNum - rowIndex * SQUARE_PART_SIZE;
        for (int row = 0; row < SQUARE_PART_SIZE; row++)
            for (int col = 0; col < SQUARE_PART_SIZE; col++)
                square[row * SQUARE_PART_SIZE + col]
                        = matrix[row + rowIndex*SQUARE_PART_SIZE][col + colIndex*SQUARE_PART_SIZE];
        return square;
    }


    public boolean isCorrect9(int[] inputLine) {
        int control = 0;
        int[] controlLine = CONTROL_LINE.clone();
        for (int row = 0; row < CONTROL_LINE.length; row++) {
            for (int col = 0; col < inputLine.length; col++) {
                if (controlLine[row] == inputLine[col]) {
                    controlLine[row] = 0;
                    control++;
                }
            }
        }
        if (control == inputLine.length) {
            return true;
        } else {
            return false;
        }
    }
}
