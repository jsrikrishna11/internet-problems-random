package dynamicprogramming;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

class Coordinates {
    private final int x,y;
    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    @Override
    public int hashCode(){
        return (new Integer(x)).hashCode()+(new Integer(y)).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Coordinates b=(Coordinates) obj;

        return b.getX()==x && b.getY() == y;
    }

    @Override
    public String toString() {
        return "{" + x + ", "+ y + "}";
    }
}
public class GridMove {

    private static int move(int row, int col, int nRow, int nCol, Stack<Coordinates> path, HashMap<Coordinates,Integer> memo){
        int ways = 0;
        int moveRight = col + 1;
        int moveDown = row + 1;
        Coordinates currentNode = new Coordinates(row, col);
        path.add(new Coordinates(row,col));
        if(memo.containsKey(currentNode)){
            return memo.get(currentNode).intValue();
        }
        if(row == nRow && col == nCol){
            //System.out.println(path);
            memo.put(currentNode, ways+1);
            return ways+1;
        }
        if(row == nRow && col < nCol){
            ways += move(row, moveRight, nRow, nCol, path, memo);
        }
        else if(row < nRow && col == nCol){
            ways += move(moveDown, col, nRow, nCol, path, memo);
        }else if(row < nRow && col < nCol){
            ways += move(moveDown,col,nRow, nCol,path, memo);
            path.pop();
            ways += move(row, moveRight, nRow, nCol,path, memo);

        }
        path.pop();
        memo.put(currentNode, ways);
        return ways;
    }
    private static int move(int row, int col, int nRow, int nCol, Stack<Coordinates> path){
        int ways = 0;
        int moveRight = col + 1;
        int moveDown = row + 1;
        path.add(new Coordinates(row,col));

        if(row == nRow && col == nCol){
            //System.out.println(path);
            return ways+1;
        }
        if(row == nRow && col < nCol){
            ways += move(row, moveRight, nRow, nCol, path);
        }
        else if(row < nRow && col == nCol){
            ways += move(moveDown, col, nRow, nCol, path);
        }else if(row < nRow && col < nCol){
            ways += move(moveDown,col,nRow, nCol,path);
            path.pop();
            ways += move(row, moveRight, nRow, nCol,path);

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
        final long startTime = System.currentTimeMillis();
        Stack<Coordinates> path = new Stack<>();
        HashMap<Coordinates,Integer> memo = new HashMap<>();
        System.out.println(move(1,1,20,20,path,memo));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for Memoization: " + (endTime - startTime));

        final long startTime1 = System.currentTimeMillis();
        System.out.println(move(1,1,15,15,path));
        final long endTime1 = System.currentTimeMillis();
        System.out.println("Total execution time for Pure Recursion: " + (endTime1 - startTime1));

    }
}
