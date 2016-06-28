/**
 * Created by vlad on 28.06.16.
 */
public class MenuAction {
    private ConsoleInput input;//Объекты из вне, кторые используются
    private Action action;//в нашей программе - Ввод, выывод и Хранилище
    private UserAction[] acts = new UserAction[7];//действия которые описанны в системе
    private int position = 0;

    public MenuAction(ConsoleInput input, Action action){
        this.input = input;
        this.action = action;
    }
    public void fillActions(){
        this.acts[position++] = this.new AddChess("Add the new chess. ");
        this.acts[position++] = this.new ShowChesses("Show all items. ");
        this.acts[position++] = this.new MoveChess("Add the change items fields. ");

    }


    public void select(int key){
        this.acts[key].execute(this.input, this.action);
    }

    public void show(){
        for (UserAction action : this.acts){
            if(action != null){
                System.out.println(action.info());
            }
        }
    }
    private class AddChess {
        String name;
        public AddChess(String name) {
            super(name);
        }
        public int key(){
            return 0;
        }

        public void execute(ConsoleInput input, Action action){
            int y = Integer.parseInt(input.ask("Please, enter the task's name: "));
            char x = input.ask("Please, enter the task's desc: ");
            action.add(new Chess(int y, char x));
        }

    }
}
