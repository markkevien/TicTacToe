import play.Player;
public class RowChecker implements Runnable{
  private Thread t;
  private String threadName;
  private boolean checker = true;
  static char[][] board = new char[3][3];
  Player one;
  Player two;
  public RowChecker(String name,char[][] board,Player one,Player two){
    System.out.println("Initializing RowChecker");
    this.threadName = name;
    this.board = board;
    this.one = one;
    this.two = two;
  }
  public void run(){
      rowChecker();
    }
  public void start(){
    System.out.println("Starting RowChecker");
      t = new Thread(this,threadName);
      t.start();

  }
  public boolean getChecker(){
    return this.checker;
  }
  public Thread getThread(){
    return t;
  }
  private void rowChecker(){
        int i;
        for(i=0;i<3;i++){
          if(this.board[i][0]==this.board[i][1]&&this.board[i][1]==this.board[i][2]){
            if(this.board[i][0]!=' '){
              this.checker=false;
              if(this.board[i][0]==one.getMark()){
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
