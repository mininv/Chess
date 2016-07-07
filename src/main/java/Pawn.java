/**
 * Created by vlad on 28.06.16.
 */
public class Pawn extends Chess{
    int y;
    char x;
    Chess[]newMove = new Pawn[1];
    int position = 0;
    String name = "Pawn";
    public Pawn(int y, char x) {
        super(y,x);
        super.name= this.name;
    }
    public boolean move(Chess start, Chess end){
        if((start.x == end.x) & (Math.abs(start.y -end.y)==1)) return true;
        else return false;
    }
    public Chess[] allMoves(Chess start) {
        newMove[0]= new Pawn(start.getY()+1,start.getX());
        return newMove;
    }
    public boolean canMove(Chess end){// проверка попадания конечного хода в массив
        boolean move = false;
        for (Chess css: newMove) {
            if ( css.getY() == end.getY() && css.getX() == end.getX() ){
                move = true;
                break;
            }
        }
        return move;
    }

}
