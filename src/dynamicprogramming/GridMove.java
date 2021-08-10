package dynamicprogramming;


import java.util.ArrayDeque;
import java.util.Stack;

class Coordinates {
    private final int x,y;
    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ", "+ y + "}";
    }
}
public class GridMove {

    private static int move(int row, int col, int nRow, int nCol, int ways, Stack<Coordinates> path){
        int moveRight = col + 1;
        int moveDown = row + 1;
        path.add(new Coordinates(row,col));
        if(row == nRow && col == nCol){
            System.out.println(path);
            return ways+1;
        }
        if(row == nRow && col < nCol){
            ways = move(row, moveRight, nRow, nCol, ways,path);
        }
        else if(row < nRow && col == nCol){
            ways = move(moveDown, col, nRow, nCol, ways,path);
        }else if(row < nRow && col < nCol){
            ways = move(moveDown,col,nRow, nCol,ways,path);
            path.pop();
            ways = move(row, moveRight, nRow, nCol,ways,path);

        }
        path.pop();
        return ways;
    }

    public static void main(String[] args) {
        /*
        You solve for sub-array - 0x0 - 1x0 and 0x1
        What is the base case?
            1. when I can't move more right or more down

        Do we use Memoization? - Yes
         */
        Stack<Coordinates> path = new Stack<>();
        System.out.println(move(1,1,4,4,0,path));

    }
}
