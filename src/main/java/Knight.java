/**
 * Created by vlad on 28.06.16.
 */
public class Knight extends Chess{
    int y;
    char x;
    String name = "Knight";
    Chess[]newMove =new Chess[8];

    public Knight(int y, char x) {
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
        if( hop && (Math.abs(start.y -end.y))== 1 & (Math.abs(start.x -end.x) == 2)) return true;
        if( hop && (Math.abs(start.y -end.y))== 2 & (Math.abs(start.x -end.x) == 1 )) return true;
        else return false;
    }
    public Chess[] allMoves(Chess start){//запись массива возможных ходов
        newMove[0]= new Chess(start.getY()+1,(char)(start.getX()-2));
        newMove[1]= new Chess(start.getY()+2,(char)(start.getX()-1));
        newMove[2]= new Chess(start.getY()+2,(char)(start.getX()+1));
        newMove[3]= new Chess(start.getY()+1,(char)(start.getX()+2));
        newMove[4]= new Chess(start.getY()-1,(char)(start.getX()+2));
        newMove[5]= new Chess(start.getY()-2,(char)(start.getX()+1));
        newMove[6]= new Chess(start.getY()-2,(char)(start.getX()-1));
        newMove[7]= new Chess(start.getY()-1,(char)(start.getX()-2));
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
