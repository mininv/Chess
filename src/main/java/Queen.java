/**
 * Created by vlad on 28.06.16.
 */
public class Queen extends Chess{
    int y;
    char x;
    String name = "Queen";
    public Queen(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(Queen start, Queen end){
        if((start.x != end.x) & (start.y!=end.y)
                & (Math.abs(start.y -end.y)==Math.abs(start.x -end.x))) return true;
        if((start.x == end.x) & (start.y!=end.y)) return true;
        else if ((start.y == end.y) & (start.x != end.x)) return true;
        else return false;
    }
}
