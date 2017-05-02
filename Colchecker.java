public class Colchecker implements Runnable{
  private Thread t;
  private String threadName;
  private Board board;
  private boolean checker = true;
  public Colchecker(String name,Board board){
    System.out.println("Starting Colchecker");
    this.threadName = name;
    this.board = board;
  }
  public void run(){
    rowChecker();
    columnChecker();

    System.out.println("Game has Ended");
  }
  public Thread getThread(){
    return t;
  }
  public void start(){
    System.out.println("Starting Colchecker");
    if(t==null){
      t = new Thread(this,threadName);
      t.start();
    }
  }
  public boolean getChecker(){
    return this.checker;
  }
  private void rowChecker(){
    int i;
    try{
      while(this.checker){
        for(i=0;i<3;i++){
          if(board.getCharacter(i,0)==board.getCharacter(i,1)&&board.getCharacter(i,1)==board.getCharacter(i,2)){
            if(board.getCharacter(i,0)!=' '){
              this.checker=false;

          }
          }
        }
        t.sleep(1);
      }
    }catch(InterruptedException e){

    }
  }
  private void columnChecker(){
    int i;
    try{
      while(this.checker){
        for(i=0;i<3;i++){
          if(board.getCharacter(0,i)==board.getCharacter(1,i)&&board.getCharacter(1,i)==board.getCharacter(2,i)){
            if(board.getCharacter(0,i)!=' '){
              this.checker=false;

          }
          }
        }
        t.sleep(1);
      }
    }catch(InterruptedException e){

    }
  }
}
