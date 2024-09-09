public class Sudoku {
    static int[][] INPUT_SUDOKU = new int[][]{
            {3, 9, 5, 2, 7, 1, 4, 8, 6},
            {7, 4, 6, 8, 3, 5, 2, 1, 9},
            {8, 2, 1, 4, 6, 9, 5, 7, 3},
            {5, 3, 9, 7, 4, 8, 6, 2, 1},
            {2, 7, 8, 5, 1, 6, 9, 3, 4},
            {6, 1, 4, 3, 9, 2, 7, 5, 8},
            {9, 6, 2, 1, 8, 7, 3, 4, 5},
            {1, 5, 3, 6, 2, 4, 8, 9, 7},
            {4, 8, 7, 9, 5, 3, 1, 6, 2}
    };

    static public void main(String[] args){
        System.out.println(eval(INPUT_SUDOKU));
    }

    static public String eval(int[][] sudoku) {
        final int SQUARE_FULL_SIZE = 9;
        final int SQUARE_PART_SIZE = 3;
        final String IS_CORRECT = "корректно";
        final String IS_NOT_CORRECT = "не корректно";

        for (int index = 0; index < SQUARE_FULL_SIZE; index++) {
            int sum = 0;
            for (int i = 0; i < SQUARE_FULL_SIZE; i++) sum = sum + sudoku[index][i];
            if (sum != 45) return IS_NOT_CORRECT;

            sum = 0;
            for (int i = 0; i < SQUARE_FULL_SIZE; i++) sum = sum + sudoku[i][index];
            if (sum != 45) return IS_NOT_CORRECT;

            sum = 0;
            int rowIndex = index / SQUARE_PART_SIZE;
            int colIndex = index - rowIndex * SQUARE_PART_SIZE;
            for (int row = 0; row < SQUARE_PART_SIZE; row++)
                for (int col = 0; col < SQUARE_PART_SIZE; col++)
                    sum = sum + sudoku[row + rowIndex * SQUARE_PART_SIZE][col + colIndex * SQUARE_PART_SIZE];
            if (sum != 45) return IS_NOT_CORRECT;
        }
        return IS_CORRECT;
    }
}
