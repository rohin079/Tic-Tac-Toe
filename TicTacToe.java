import java.util.*;
public class TicTacToe {
    String board[][] = new String[3][3];

    TicTacToe(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=" ";
            }
        }
    }

    public void display(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j==1){
                    System.out.print(" | "+board[i][j]+" | ");
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            if(i!=2)
            System.out.println("\n---------");
        }
    }
    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe();
        t1.display();
    }
    
}

