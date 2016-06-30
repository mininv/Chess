/**
 * Created by vlad on 28.06.16.
 */
public class MenuAction {
    private  char[] chrang = {'a', 'b', 'c', 'd','e','f','g'};
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
            String que = input.ask("Введите тип фигуры(King, Knight, Bishop, Pawn, Queen, Rook): ");
            int y = Integer.parseInt(input.ask("Вводим числовой литерал 1-8: "));
            String alf = input.ask("Водим буквенный литерал a-h: ");
            char x = alf.charAt(0);
            if(que.equals("King")){action.add(new King(y,x)); }
            else if (que.equals("Knight")){if (proverka(y, x))action.add(new Knight(y,x));
            else System.out.println("Ну как так то");
            }
            else if (que.equals("Bishop")){action.add(new Bishop(y,x));}
            else if (que.equals("Pawn")){action.add(new Pawn(y,x));}
            else if (que.equals("Queen")){action.add(new Queen(y,x));}
            else if (que.equals("Rook")){action.add(new Rook(y,x));}
            else System.out.println("Ататат");
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
                    if (chess!=null && chess.getName().equals(nameCh)) {
                        System.out.println(String.format("name- %s, bukva- %s, cifra- %s.",
                                chess.getName(),
                                chess.getX(), chess.getY()));
                    }
                }
                int y = Integer.parseInt(input.ask("Вводим числовой литерал 1-8: "));
                String alf = input.ask("Водим буквенный литерал a-h: ");
                char x = alf.charAt(0);
                for (Chess ches: action.chesses) {
                    if (ches!=null && ches.getY() == y & ches.getX() == x) {
                       System.out.println("Вы выбрали - ");
                       System.out.println(String.format("name- %s, bukva- %s, cifra- %s.",
                       ches.getName(),
                       ches.getX(), ches.getY()));
                       int yn = Integer.parseInt(input.ask("Вводим новый числовой литерал 1-8: "));
                       String alfn = input.ask("Вводим новый буквенный литерал a-h: ");
                       char xn = alfn.charAt(0);
                       if(ches.move(ches, new Chess(yn,xn))){
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
    public boolean proverka(int yn, char xn){
        boolean one = false;
        boolean two =false;
        for (int v:
                cifri) {
            if( v==yn )  one = true;
            System.out.println("Yraaa");
        }
        for (char g:
                chrang) {
            if( g==xn ) two = true;
            System.out.println("Yraaa2");
        }
        if(one & two) return true;
        else return false;
    }
    }
