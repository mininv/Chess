/**
 * Created by vlad on 28.06.16.
 */
public class King extends Chess{
    int y;
    char x;
    String name = "King";
    public King(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(King start, King end){
      if((start.x == end.x) & (Math.abs(start.y -end.y)==1)) return true;
        else if ((start.y == end.y) & (Math.abs(start.x -end.x)==1)) return true;
        else return false;
    }

}
