import org.omg.CORBA.Object;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by vlad on 28.06.16.
 */
public class Chess {

    char x;
    int y;
    String name = "123";
    Chess[]newMove = new Chess[2];
    boolean hop = true;

    public Chess(int y, char x){
        this.y = y;
        this.x = x;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){this.name = name;}

    public char getX(){return x;}

    public int getY(){return y;}

    public void setX(char x){this.x = x;}

    public void setY(int y){this.y = y;}

    //метод проверки правильности хода и отсутствия других фигур на пути движения
    public boolean move(Chess start, Chess end, Chess [] chesses){
        if((start.getX()== end.getX()) &(start.getY()== end.getY())){
            return false;
        }
        else return true;
    }

    public Chess[] allMoves(Chess start){//метод для создания массива всех ходов
        for (int i = 0; i < 2; i++) {
            newMove[i] = new Chess(start.getY()+i,start.getX());
        }
        return newMove;
    }

    public boolean canMove(Chess end){// проверка попадания конечного хода в массив
        boolean move = false;
        for (Chess css: newMove
                ) {
            if (css!= null && css.getY() == end.getY() && css.getX() == end.getX() ){
                move = true;
                break;
            }
        }
        return move;
    }

}
