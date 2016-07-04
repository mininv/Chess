/**
 * Created by vlad on 28.06.16.
 */
public class MenuAction {
    private  char[] chrang = {'a', 'b', 'c', 'd','e','f','g','h'};
    private  int [] cifri = {1,2,3,4,5,6,7,8};
    private ConsoleInput input;//Объекты из вне, кторые используются
    private Action action;//в нашей программе - Ввод, выывод и Хранилище
    private UserAction[] acts = new UserAction[3];//действия которые описанны в системе
    private int position = 0;

    public MenuAction(ConsoleInput input, Action action){
        this.input = input;
        this.action = action;
    }
    public void fillActions(){
        this.acts[position++] = (UserAction) this.new AddChess("Add a new figure. ");
        this.acts[position++] = (UserAction) this.new ShowChesses("Show all figures. ");
        this.acts[position++] = (UserAction) this.new MoveChess("Move the selected figures. ");

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
            String que = input.ask("Введите тип фигуры(King, Knight, Bishop, Pawn, Queen, Rook): ");
            int y = input.ask(("Вводим числовой литерал 1-8: "), cifri);
            char x = input.ask("Водим буквенный литерал a-h: ",chrang);
            if(que.equals("King")){action.add(new King(y,x)); }
            else if (que.equals("Knight")){action.add(new Knight(y,x));}
            else if (que.equals("Bishop")){action.add(new Bishop(y,x));}
            else if (que.equals("Pawn")){action.add(new Pawn(y,x));}
            else if (que.equals("Queen")){action.add(new Queen(y,x));}
            else if (que.equals("Rook")){action.add(new Rook(y,x));}
            else System.out.println("Введите название фигуры из предложенных");
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
                    System.out.println(String.format("figure %s: %s%s.", chess.getName(),
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
                    if (chess!=null && chess.getName().equals(nameCh)) {
                        System.out.println(String.format("figure %s: %s%s.",
                                chess.getName(),
                                chess.getX(), chess.getY()));
                    }
                }
                int y = input.ask(("Вводим числовой литерал 1-8: "), cifri);
                char x = input.ask("Водим буквенный литерал a-h: ", chrang);
                for (Chess ches: action.chesses) {
                    if (ches!=null && ches.getY() == y && ches.getX() == x) {
                       System.out.print("Вы выбрали - ");
                       System.out.println(String.format("figure %s: %s%s.",
                       ches.getName(),
                       ches.getX(), ches.getY()));
                        int yn = input.ask(("Вводим  новый числовой литерал 1-8: "), cifri);
                        char xn = input.ask("Водим новвый буквенный литерал a-h: ", chrang);
                       if((action.nichegonemeshaet(ches, new Chess(yn,xn))) &&
                               ches.move(ches, new Chess(yn,xn))){
                           ches.setX(xn);ches.setY(yn);
                           System.out.println("Вce ok "+ches.getName() +" может так ходить");
                       }
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
