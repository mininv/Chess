/**
 * Created by vlad on 28.06.16.
 */
public class StartUI {
    private int[] range = {0,1,2,3,4,5,6,7,8};
    private char[] chrang = {'a', 'b', 'c', 'd','e','f','g'};
    private ConsoleInput input;
    public StartUI(ConsoleInput input){
        this.input = input;
    }
    public void init() {
        Action action =new Action();
        MenuAction menu = new MenuAction(this.input, action);
        menu.fillActions();
        do{
            menu.show();
            int key = input.ask("Select: ",range);
            menu.select(key);
        } while(!"y".equals(this.input.ask("Exit?(y): ")));
    }
    public static void main(String[] args){
        ConsoleInput input = new ConsoleInput();
        new StartUI(input).init();
    }

}
