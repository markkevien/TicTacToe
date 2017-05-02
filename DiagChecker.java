import play.Player;
public class DiagChecker implements Runnable{
  private Thread t;
  private String threadName;
  private boolean checker = true;
  static char[][] board = new char[3][3];
  Player one;
  Player two;
  public DiagChecker(String name,char[][] board,Player one,Player two){
    System.out.println("Initializing DiagChecker");
    this.threadName = name;
    this.board = board;
    this.one = one;
    this.two = two;
  }
  public void run(){
      diagChecker();
    }
  public void start(){
    System.out.println("Starting DiagChecker");
      t = new Thread(this,threadName);
      t.start();

  }
  public boolean getChecker(){
    return this.checker;
  }
  public Thread getThread(){
    return t;
  }
  private void diagChecker(){

          if(this.board[0][0]==this.board[1][1]&&this.board[1][1]==this.board[2][2]){
            if(this.board[1][1]!=' '){
              this.checker=false;
              if(this.board[1][1]==one.getMark()){
                  one.setPoints(one.getPoints()+1);
                  System.out.println("Player 1 wins");
              }else{
                two.setPoints(two.getPoints()+1);
                System.out.println("Player 2 wins");
              }
              System.out.println("Finished");

          }
        }else if(this.board[0][2]==this.board[1][1]&&this.board[1][1]==this.board[2][0]){
                  if(this.board[1][1]!=' '){
                    this.checker=false;
                    if(this.board[1][1]==one.getMark()){
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
  public void updateBoard(){
        this.board = Main.board;

  }
}
