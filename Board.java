public class Board{
  private char[][] board = new char[3][3];//[row][col]
    int i,j;
  public Board(){
    for(i=0;i<3;i++){
      for(j=0;j<3;j++){
        board[i][j]='H';
      }
    }
  }
  public void displayBoard(){
    for(i=0;i<3;i++){
      for(j=0;j<3;j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println();

  }
  public char getCharacter(int i, int j){
    return board[i][j];
  }
  public boolean setCharacter(int i, int j, int player){
    if(this.board[i][j]=='H'){
    if(player==1){
      this.board[i][j]='O';
    }else if(player==2){
      this.board[i][j]='X';
    }
    return false;
  }else{
    return true;
  }
  }
}
