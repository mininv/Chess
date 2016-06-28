/**
 * Created by vlad on 28.06.16.
 */
public class Bishop extends Chess{
    int y;
    char x;
    String name = "Bishop";
    public Bishop(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(Bishop start, Bishop end){
        if((start.x != end.x) & (start.y!=end.y)
                & (Math.abs(start.y -end.y)==Math.abs(start.x -end.x))) return true;
        else return false;
    }
}
