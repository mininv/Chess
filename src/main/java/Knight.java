/**
 * Created by vlad on 28.06.16.
 */
public class Knight extends Chess{
    int y;
    char x;
    String name = "Knight";
    public Knight(int y, char x) {
        this.y = y;
        this.x = x;
    }
    public boolean move(Knight start, Knight end){
        if( (Math.abs(start.y -end.y))== 1 & (Math.abs(start.x -end.x) == 2)) return true;
        if( (Math.abs(start.y -end.y))== 2 & (Math.abs(start.x -end.x) == 1 )) return true;
        else return false;
    }
}
