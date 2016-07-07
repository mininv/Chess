/**
 * Created by vlad on 28.06.16.
 */
public class Action {
    public Chess [] chesses = new Chess [64];// максю число фигур на шахматной доске
    private int position = 0;
    // добавляем фигуру на вирт доску
    public Chess add(Chess chess){
        if(this.chesses[0]==null)this.chesses[position++] = chess;
        else {
            boolean step = true;
            for (Chess ch : chesses) {
                if (ch != null && (ch.getX() == chess.getX()) &&
                        (ch.getY() == chess.getY())) {System.out.println("Клетка занята то");
                step = false;
                break;}
            }
            if (step)this.chesses[position++] = chess;
        }
        return chess;
    }

    //массив объектов, для тех элементов которые мы вставили
    public Chess[] getAll(){
        Chess[] result = new Chess[this.position];
        for (int index = 0; index != this.position; index++){
            result[index] = this.chesses[index];
        }
        return result;
    }
    public boolean moveByChess(Chess start, Chess end){
        boolean hop = true;
        if (start.getName() == "Knight"|start.getName() == "Pawn"|
                start.getName() == "King"){// условие наличия фигур у коняки
            for (Chess ch: chesses
                 ) {
                if(ch != null && ch.getX()==end.getX() & ch.getY()== end.getY()){
                    System.out.println("On the motion of the line is a figure ");
                    hop = false;
                    break;
                }
            }
        }
        if (start.getName() == "Bishop"|
                start.getName() == "Rook" | start.getName() == "Queen") {
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
            if(end.getX() > start.getX() & end.getY() != start.getY()){// по диагонали вправо
                if (end.getY() > start.getY()){
                    char X = end.getX();
                    for (int i = end.getY(); i> start.getY(); i--){
                        Chess chez = new Chess(  i, X--);
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
                else{
                    char X = end.getX();
                    for (int i = end.getY(); i< start.getY(); i++){
                        Chess chez = new Chess(  i, X--);
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
            if(end.getX() < start.getX() ) {// по диагонали влево
                if (end.getY() > start.getY()){
                    char X = end.getX();
                    for (int i = end.getY(); i> start.getY(); i--){
                        Chess chez = new Chess(  i, X++);
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
                else{
                    char X = end.getX();
                    for (int i = end.getY(); i< start.getY(); i++){
                        Chess chez = new Chess(  i, X++);
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
        }
        return hop;
    }
}
