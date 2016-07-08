/**
 * Created by vlad on 28.06.16.
 */
public class King extends Chess{
    int y;
    char x;
    Chess[]newMove = new King[20];
    int position = 0;
    String name = "King";
    public King(int y, char x) {
        super(y,x);
        super.name= this.name;
    }
    public boolean move(Chess start, Chess end, Chess[] chesses){
        for (Chess ch: chesses
                ) {
            if(ch != null && ch.getX()==end.getX() & ch.getY()== end.getY()){
                System.out.println("On the motion of the line is a figure ");
                hop = false;
                break;
            }
        }
      if(hop && (start.x == end.x) & (Math.abs(start.y -end.y)==1)) return true;
        else if (hop && (start.y == end.y) & (Math.abs(start.x -end.x)==1)) return true;
        else return false;
    }
    public Chess[] allMoves(Chess start) {
        int y = start.getY() -1;
        char x = (char) (start.getX() - 1);
        do{
            newMove[position++] = new King(y++, x);
        }while (y<= start.getY()+1);
        y = start.getY() -1;
        x = start.getX();
        do{
            newMove[position++] = new King(y++, x);
        }while (y<= start.getY()+1);
        y = start.getY() -1;
        x = (char) (start.getX()+1);
        do{
            newMove[position++] = new King(y++, x);
        }while (y<= start.getY()+1);
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
