/**
 * Created by vlad on 28.06.16.
 */
public class Rook extends Chess{
    int y;
    char x;
    String name = "Rook";
    public Rook(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(Rook start, Rook end){
        if((start.x == end.x) & (start.y!=end.y)) return true;
        else if ((start.y == end.y) & (start.x != end.x)) return true;
        else return false;
    }

}
