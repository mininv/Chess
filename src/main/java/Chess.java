import org.omg.CORBA.Object;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by vlad on 28.06.16.
 */
public class Chess {
    char x;
    int y;
    String name = "123";
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



    public boolean move(Chess start, Chess end){
        if((start.getX()== end.getX()) &(start.getY()== end.getY())){
            return false;
        }
        else return true;
    }
}
