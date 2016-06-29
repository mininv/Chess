/**
 * Created by vlad on 28.06.16.
 */
public class MenuAction {
    private ConsoleInput input;//Объекты из вне, кторые используются
    private Action action;//в нашей программе - Ввод, выывод и Хранилище
    private UserAction[] acts = new UserAction[3];//действия которые описанны в системе
    private int position = 0;

    public MenuAction(ConsoleInput input, Action action){
        this.input = input;
        this.action = action;
    }
    public void fillActions(){
        this.acts[position++] = (UserAction) this.new AddChess("Add the new chess. ");
        this.acts[position++] = (UserAction) this.new ShowChesses("Show all items. ");
        this.acts[position++] = (UserAction) this.new MoveChess("Add the change items fields. ");

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
    public class AddChess implements UserAction {
        String name;
        public AddChess(String name) {
            this.name = name;
        }
        public int key(){
            return 0;
        }

        public void execute(ConsoleInput input, Action action){
            int y = Integer.parseInt(input.ask("Вводим числовой литерал 1-8: "));
            String alf = input.ask("Водим буквенный литерал a-h: ");
            char x = alf.charAt(0);
            action.add(new Chess(y,x));
        }
        public String info(){
            return String.format("%s. %s", this.key(),
                    this.name );
        }

    }
        public class ShowChesses implements UserAction {
            String name;
            public ShowChesses(String name) {
                this.name = name;
            }
            public int key(){
                return 1;
            }

            public void execute(ConsoleInput input, Action action){
                for (Chess chess: action.getAll()){
                    System.out.println(String.format("name- %s, name- %s, desc- %s.", chess.getName(),
                            chess.getX() , chess.getY()));
                }
            }
            public String info(){
                return String.format("%s. %s", this.key(),
                        this.name );
            }
        }
        public class MoveChess implements UserAction{
            String name;
            public MoveChess(String name) {
                this.name = name;
            }
            public int key(){
                return 2;
            }

            public void execute(ConsoleInput input, Action action){
                String nameCh = input.ask("Please, enter the name of figure: ");
                for (Chess chess: action.chesses) {
                    if (chess.getName().equals(nameCh)) {
                        System.out.println(String.format("name- %s, name- %s, desc- %s.",
                                chess.getName(),
                                chess.getX(), chess.getY()));
                    }
                }
                int y = Integer.parseInt(input.ask("Вводим числовой литерал 1-8: "));
                String alf = input.ask("Водим буквенный литерал a-h: ");
                char x = alf.charAt(0);
                for (Chess ches: action.chesses) {
                   if (ches.getY() == y & ches.getY() == x) {
                       System.out.println("Вы выбрали - ");
                       System.out.println(String.format("name- %s, name- %s, desc- %s.",
                       ches.getName(),
                       ches.getX(), ches.getY()));
                       int yn = Integer.parseInt(input.ask("Вводим новый числовой литерал 1-8: "));
                       String alfn = input.ask("Вводим новый буквенный литерал a-h: ");
                       char xn = alf.charAt(0);
                       if(ches.move(ches, new Chess(yn,xn))){ches.setX(xn);ches.setY(yn);}
                       else System.out.println("Вы сделали не правильный ход!!! ");
                   }
                }
            }
            public String info(){
                return String.format("%s. %s", this.key(),
                        this.name );
            }
        }
    }
