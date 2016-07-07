/**
 * Created by vlad on 28.06.16.
 */
public class Rook extends Chess{
    int y;
    char x;
    Chess[]newMove = new Rook[100];
    int position = 0;
    String name = "Rook";
    public Rook(int y, char x) {
        super(y,x);
        super.name= this.name;
    }
    public boolean move(Chess start, Chess end){
        if((start.x == end.x) & (start.y!=end.y)) return true;
        else if ((start.y == end.y) & (start.x != end.x)) return true;
        else return false;
    }
    public Chess[] allMoves(Chess start) {
        int y = 1;
        char x = start.getX();
        do{
            newMove[position++] = new Rook(y++, x);
        }while (y<= 8);
        y = start.getY();
        x = 'a';
        do{
            newMove[position++] = new Rook(y, x++);
        }while (x<='h');
        return newMove;
    }
    public boolean canMove(Chess end){// проверка попадания конечного хода в массив
        boolean move = false;
        for (Chess css: newMove) {
            if ( css!= null&& css.getY() == end.getY() && css.getX() == end.getX() ){
                move = true;
                break;
            }
        }
        return move;
    }
}
