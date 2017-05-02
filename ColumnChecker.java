import play.Player;
public class ColumnChecker implements Runnable{
  private Thread t;
  private String threadName;
  private boolean checker = true;
  static char[][] board = new char[3][3];
  Player one;
  Player two;
  public ColumnChecker(String name,char[][] board,Player one,Player two){
    System.out.println("Initializing ColChecker");
    this.threadName = name;
    this.board = board;
    this.one = one;
    this.two = two;
  }
  public void run(){
      columnChecker();
  }
  public Thread getThread(){
    return t;
  }
  public void start(){
    System.out.println("Starting ColChecker");
      t = new Thread(this,threadName);
      t.start();

  }
  public boolean getChecker(){
    return this.checker;
  }
  private void columnChecker(){
    int i;


        for(i=0;i<3;i++){
          if(this.board[0][i]==this.board[1][i]&&this.board[1][i]==this.board[2][i]){
            if(this.board[0][i]!=' '){
              this.checker=false;
              if(this.board[0][i]==one.getMark()){
                  one.setPoints(one.getPoints()+1);
                  System.out.println("Player 1 wins");
              }else{
                two.setPoints(two.getPoints()+1);
                System.out.println("Player 2 wins");
              }
              System.out.println("Finished");

          }
          }

  }
}

  public void updateBoard(){
        this.board = Main.board;

  }
}
