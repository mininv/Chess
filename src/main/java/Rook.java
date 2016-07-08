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
    public boolean move(Chess start, Chess end, Chess[] chesses){
        if (start.getY() == end.getY()
                & end.getX() != start.getX()) { // перемещение по горизонтали
            if (end.getX() > start.getX()) {
                char i = (char) (start.getX() + 1);
                for (; i <= end.getX(); i++) {
                    Chess chez = new Chess(start.getY(), i);
                    for (Chess ch : chesses
                            ) {
                        if (ch != null && ch.getX() == chez.getX()
                                & ch.getY() == chez.getY()){ hop = false;
                            System.out.println("On the motion of the line is a figure ");
                            break;}
                    }
                }
            } else {
                char i = end.getX() ;
                for (; i < start.getX(); i++) {
                    Chess chez = new Chess(start.getY(), i);
                    for (Chess ch : chesses
                            ) {
                        if (ch != null && ch.getX() == chez.getX() &
                                ch.getY() == chez.getY()){
                            System.out.println("On the motion of the line is a figure ");
                            hop = false;
                            break;}
                    }
                }
            }
        }
        if (start.getX() == end.getX() & start.getY() != end.getY()) {//перемещение по верт.
            if (end.getY() > start.getY()) {
                int i = (start.getY() + 1);
                for (; i <= end.getY(); i++) {
                    Chess chez = new Chess(i, start.getX());
                    for (Chess ch : chesses
                            ) {
                        if (ch != null && ch.getX() == chez.getX()
                                & ch.getY() == chez.getY()){
                            System.out.println("On the motion of the line is a figure ");
                            hop = false;
                            break;}
                    }
                }
            } else {
                int i = end.getY() ;
                for (; i < start.getY(); i++) {
                    Chess chez = new Chess(i, start.getX());
                    for (Chess ch : chesses
                            ) {
                        if (ch != null && ch.getX() == chez.getX()
                                & ch.getY() == chez.getY()){
                            System.out.println("On the motion of the line is a figure ");
                            hop = false;
                            break;}
                    }
                }
            }
        }
        if(hop && (start.x == end.x) & (start.y!=end.y)) return true;
        else if (hop && (start.y == end.y) & (start.x != end.x)) return true;
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
