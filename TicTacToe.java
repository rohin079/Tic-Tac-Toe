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
    public String winnerCheck(){
    for(int i=0;i<8;i++){
        String line="";
        switch(i){
            case 0:
            line = board[0][0]+board[0][1]+board[0][2];
            break;

            case 1:
            line = board[1][0]+board[1][1]+board[1][2];
            break;

            case 2:
            line = board[2][0]+board[2][1]+board[2][2];
            break;

            case 3:
            line = board[0][0]+board[1][1]+board[2][2];
            break;

            case 4:
            line = board[0][2]+board[1][1]+board[2][0];
            break;

            case 5:
            line = board[0][0]+board[1][0]+board[2][0];
            break;

            case 6:
            line = board[0][1]+board[1][1]+board[2][1];
            break;

            case 7:
            line = board[0][2]+board[1][2]+board[2][2];
            break;
        }
        if(line.equals("XXX"))
            return "X";
        else if(line.equals("OOO"))
            return "O";
    }
    return "1";
}
    public boolean inputValidationCheck(int pos, int player){
        String element="";
        int x=0,y=0;
        switch(pos){
            case 7:
            element = board[0][0];
            x=0; y=0;
            break;
            
            case 8:
            element = board[0][1];
            x=0; y=1;
            break;

            case 9:
            element = board[0][2];
            x=0; y=2;
            break;

            case 4:
            element = board[1][0];
            x=1; y=0;
            break;

            case 5:
            element = board[1][1];
            x=1; y=1;
            break;

            case 6:
            element = board[1][2];
            x=1; y=2;
            break;

            case 1:
            element = board[2][0];
            x=2; y=0;
            break;

            case 2:
            element = board[2][1];
            x=2; y=1;
            break;

            case 3:
            element = board[2][2];
            x=2; y=2;
            break;
        }
        if(element == " "){
            if(player == 0)
            board[x][y]="X";
            else
            board[x][y]="O";
            return true;
        }
        else{
            return false;
        }
    }

    public void computerMoves(int computerChoice){
        for(int i=0;i<8;i++){
            String line="", positions="";
            switch(i){
                case 0:
                line = board[0][0]+board[0][1]+board[0][2];
                positions="789";
                break;

                case 1:
                line = board[1][0]+board[1][1]+board[1][2];
                positions="456";
                break;

                case 2:
                line = board[2][0]+board[2][1]+board[2][2];
                positions="123";
                break;

                case 3:
                line = board[0][0]+board[1][1]+board[2][2];
                positions="753";
                break;

                case 4:
                line = board[0][2]+board[1][1]+board[2][0];
                positions="951";
                break;

                case 5:
                line = board[0][0]+board[1][0]+board[2][0];
                positions="741";
                break;

                case 6:
                line = board[0][1]+board[1][1]+board[2][1];
                positions="852";
                break;

                case 7:
                line = board[0][2]+board[1][2]+board[2][2];
                positions="963";
                break;
            }
            switch (line) {
                case "OO ":
                case "XX ":
                inputValidationCheck(Character.getNumericValue(positions.charAt(2)), computerChoice);
                return;

                case "O O":
                case "X X":
                inputValidationCheck(Character.getNumericValue(positions.charAt(1)), computerChoice);
                return;

                case " OO":
                case " XX":
                inputValidationCheck(Character.getNumericValue(positions.charAt(0)), computerChoice);
                return;
                
                default:
                break;
            }
        }
        Random rand = new Random();
        int pos;
        do{
            pos = rand.nextInt(1,10);
        }while(!(inputValidationCheck(pos, computerChoice)));
        return;
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
        System.out.println();
    }
    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe();
        t1.display();
    }
    
}

