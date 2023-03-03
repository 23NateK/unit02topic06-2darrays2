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
    public static void printMinesweeperBoard(boolean[][] board){
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]){
                    System.out.print("* ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
    printMinesweeperBoard(makeMinesweeperBoard(5, 5, 0.25));
    }
}
