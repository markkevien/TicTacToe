package play;
public class Player{
  // Attributes
  private String name;
  private int points;
  private char mark;

  // Contructor
  public Player(String name){
    this.points = 0;
  }

  // Setters
  public void setPoints(int points){
    this.points = points;
  }
  public void setMark(char mark){
    this.mark = mark;
  }

  // Getters
  public char getMark(){
    return this.mark;
  }
  public String getName(){
    return this.name;
  }
  public int getPoints(){
    return this.points;
  }

}
