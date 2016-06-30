/**
 * Created by vlad on 28.06.16.
 */
public class Bishop extends Chess{
    String name = "Bishop";
    public Bishop(int y, char x) {
        super(y,x);
        super.name= this.name;
    }
    public boolean move(Chess start, Chess end){
        if((start.x != end.x) & (start.y!=end.y)
                & (Math.abs(start.y -end.y)==Math.abs(start.x -end.x))) return true;
        else return false;
    }
}
