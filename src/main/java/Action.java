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

}
