import java.util.Scanner;
import play.Player;
public class Main{
  static char[][] board = new char[3][3];
  static char[][] interfaceboard = new char[7][7];
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String player1, player2;
    int noOfRounds, winchecker, round = 0, i, j;
    cleanBoard();
    setupDisplayBoard();
    displayBoard();

    // Interface shits
    System.out.println("-______________-");
    System.out.println("-_TIC_TAC_TOE_-");
    System.out.println("-______________-");
    System.out.println(" ");

    System.out.print("  Player 1: ");
    player1 = sc.nextLine();
    Player playerOne = new Player(player1);

    System.out.print("  Player 2: ");
    player2 = sc.nextLine();
    Player playerTwo = new Player(player2);


    System.out.print("  Rounds: ");
    noOfRounds = sc.nextInt();
    winchecker = (noOfRounds+1)/2;

    // loop for the number of rounds
    while(round != noOfRounds){
        // if a one of the players' point reaches more than the half of rounds
        if(playerOne.getPoints() == winchecker || playerTwo.getPoints() == winchecker){
          break;
        }
        else{ // Start a new round
          round += 1; // increment the round counter
          System.out.println("Round " + round + " Begins");
          // selection of player one and two
          if(round%2 != 0){
            Fight(playerOne, playerTwo);
          }else{
            Fight(playerTwo,playerOne);
          }
        }
      System.out.println("Round " + round + " Ended");
    }
  }
//End of Main


  public static void setupDisplayBoard(){
    int i, j, k=1, l=1, m=1;
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        if(i==0 || i==2 || i==4 || i==6 || j==0 || j==2 || j==4 || j==6){ // for borders
          interfaceboard[i][j] = '*';
        }
        else{
          if(i==1){ // get the data for the original board and put it in interfaceboard
              interfaceboard[i][j] =board[i-1][j-k];
              k+=1;
          }
          else if(i==3){
            interfaceboard[i][j] =board[i-2][j-l];
            l+=1;
          }
          else{
            interfaceboard[i][j] =board[i-3][j-m];
            m+=1;
          }

        }
      }
    }
  }

  public static void displayBoard(){ // print the interfaceboard
    int i, j;
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        System.out.print(interfaceboard[i][j]);
        System.out.print(" ");
      }
      System.out.println(" ");
    }
  }

  public static void Fight(Player one, Player two){ // taking turns method
    Scanner sc = new Scanner(System.in);
    Player currentTurn;
    int x, y, i=0;
    char mark;
    // set the players' mark
    one.setMark('O');
    two.setMark('X');

    ColumnChecker colchecker = new ColumnChecker("ColChecker",board,one,two);
    RowChecker rowchecker = new RowChecker("RowChecker",board,one,two);
    DiagChecker diagchecker = new DiagChecker("DiagChecker",board,one,two);

    while(i<9&&rowchecker.getChecker()&&colchecker.getChecker()&&diagchecker.getChecker()){ // while the board is not yet full
      // for taking turns shits
      if(i%2 == 0)currentTurn = one;
      else{currentTurn = two;}
      mark = currentTurn.getMark();
      // get x and y coordinate
      System.out.print("  x-coordinate: ");
      x = sc.nextInt();
      System.out.print("  y-coordinate: ");
      y = sc.nextInt();
      // put the mark into the coordinates
      if(board[x][y] == ' ')board[x][y] = mark; // if it is empty
      else{System.out.println("You loose a turn you dumb ass!!");}
      //interface shits
      setupDisplayBoard();
      displayBoard();
      colchecker.start();
      rowchecker.start();
      diagchecker.start();
      try{
        colchecker.getThread().join();
        rowchecker.getThread().join();
        diagchecker.getThread().join();
      }catch(Exception e){
      }
      i++;
    }
    // clean the board after rounds
    cleanBoard();
  }

  public static void cleanBoard(){ // set the all to spaces
    int i, j;
    for(i=0;i<3;i++){
      for(j=0;j<3;j++){
          board[i][j] = ' ';
          interfaceboard[i][j] = ' ';
      }
    }
    setupDisplayBoard();
  }
}
