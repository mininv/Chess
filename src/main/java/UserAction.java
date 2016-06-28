/**
 * Created by vlad on 28.06.16.
 */
public interface UserAction{
    // запрашиваем действие ключ действия пользователя
    int key();
    //запрашивать действие
    void execute(ConsoleInput input, Action action);

    String info();
}