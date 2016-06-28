/**
 * Created by vlad on 28.06.16.
 */
public class Pawn extends Chess{
    int y;
    char x;
    String name = "Pawn";
    public Pawn(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(Pawn start, Pawn end){
        if((start.x == end.x) & (Math.abs(start.y -end.y)==1)) return true;
        else return false;
    }
}
