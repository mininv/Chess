import org.omg.CORBA.Object;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by vlad on 28.06.16.
 */
public class Chess {
    char x;
    int y;
    String name;
    public Chess(int y, char x){
        this.y = y;
        this.x = x;
    }
    public String getName(){
        return this.name;
    }
    public char getX(){return x;}
    public int getY(){return y;}
}
