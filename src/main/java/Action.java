/**
 * Created by vlad on 28.06.16.
 */
public class Action {
    Chess [] chesses = new Chess [10];
    private int position = 0;
    // добавляем фигуру на вирт доску
    public Chess add(Chess chess){
        this.chesses[position++] = chess;
        return chess;
    }
    //метод проверяющий наличие других фигур в клетке
    public boolean isEmpt(Chess chess){
        boolean step = true;
        for (Chess ch: chesses){
            if (ch != null & ch.getX() == chess.getX() & ch.getY() == chess.getY()) step = false;
        }
        return step;
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
