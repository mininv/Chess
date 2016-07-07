/**
 * Created by vlad on 28.06.16.
 */
public class Bishop extends Chess{
    String name = "Bishop";
    int position = 0;
    Chess[]newMove = new Bishop[50];
    public Bishop(int y, char x) {
        super(y,x);
        super.name= this.name;
    }
    public boolean move(Chess start, Chess end){
        if((start.x != end.x) & (start.y!=end.y)
                & (Math.abs(start.y -end.y)==Math.abs(start.x -end.x))) return true;
        else return false;
    }
    public Chess[] allMoves(Chess start){
        int y = start.getY();
        char x = start.getX();
        do{
            newMove[position++] = new Bishop(y++, x--);
        }while(y<=8);
        y = start.getY();
        x = start.getX();
        do{
            newMove[position++] = new Bishop(y++, x++);
        }while (y<=8);
        y = start.getY();
        x = start.getX();
        do{
            newMove[position++] = new Bishop(y--, x++);
        }while (x>='h');
        y = start.getY();
        x = start.getX();
        do{
            newMove[position++] = new Bishop(y--, x--);
        }while (x>='h');
        return newMove;
    }
    public boolean canMove(Chess end){// проверка попадания конечного хода в массив
        boolean move = false;
        for (Chess css: newMove) {
            if ( css!= null && css.getY() == end.getY() && css.getX() == end.getX() ){
                move = true;
                break;
            }
        }
        return move;
    }
}
