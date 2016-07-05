/**
 * Created by vlad on 28.06.16.
 */
public class StartUI {
    private int[] range = {0,1,2};
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
            int key = input.ask("Select: ",this.range);
            menu.select(key);
        } while(!"y".equals(this.input.ask("Exit?(y): ")));
    }
    public static void main(String[] args){
        ConsoleInput input = new ValidateInput();
        new StartUI(input).init();
    }
}
