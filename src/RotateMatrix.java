public class RotateMatrix {
private static void print2D(int matrix[][], int size){
    for (int row=0; row < size; row++){
        for(int col =0; col <size; col++){
            System.out.print(matrix[row][col]);
        }
        System.out.print("\n");
    }
}
    public static void main(String args[]){
        /*
        1, 2, 3         7, 4, 1
        4, 5, 6   to    8, 5, 2
        7, 8, 9         9, 6, 3


        1,2,3,4         13,9,5,1
        5,6,7,8     to  14,10,6,2
        9,10,11,12      15,11,7,3
        13,14,15,16     16,12,8,4
         */
        int nRowsColsSize = 3;
        int nRowsCols = nRowsColsSize -1;
        int input[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int output[][] = new int[nRowsColsSize][nRowsColsSize];
        System.out.println("Input Matrix: \n");
        print2D(input, nRowsColsSize);
        for(int col=0; col<nRowsColsSize; col++){
            for (int row = 0; row< nRowsColsSize; row++){
                int value = input[row][col];
                output[col][nRowsCols-row] = value;
            }
        }

        System.out.println("Output Matrix: \n");
        print2D(output, nRowsColsSize);

    }
}
