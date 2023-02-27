import java.util.Arrays;

public class Minesweeper {
    public static boolean[][] makeMinesweeperBoard(int n,int m, double p){
        boolean[][] board= new boolean[n][m];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                double rand=Math.random();
                if(rand<p){
                    board[x][y]=true;
                }else{
                    board[x][y]=false;
                }

            }
        }


        return board;
    }
    public static void main(String[] args) {
    System.out.println(Arrays.deepToString(makeMinesweeperBoard(5, 5, 0.50)));
    
    }
}
