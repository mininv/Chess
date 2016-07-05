import java.util.Scanner;

/**
 * Created by vlad on 28.06.16.
 */
public class ConsoleInput {
    private Scanner scaner = new Scanner(System.in);
    public String ask(String question){
        System.out.print(question);
        return scaner.nextLine();
    }

    public int ask(String question, int[] range){
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int value : range){
            if(value == key){
                exist =true;
                break;
            }
        }
        if (exist){
            return key;
        } else{
            throw new MenuOutException("Out of menu range. ");
        }
    }

    public char ask(String question ,char[] range){
        String alf = this.ask(question);
        char x = alf.charAt(0);
        boolean exist = false;
        for(char value : range){
            if(value == x){
                exist =true;
                break;
            }
        }
        if (exist){
            return x;
        } else{
            throw new MenuOutException("Out of menu range. ");
        }
    }
    public String ask(String question ,String[] ra){
        String alf = this.ask(question);
        boolean exist = false;
        for(String value : ra){
            if(value.equals(alf)){
                exist =true;
                break;
            }
        }
        if (exist){
            return alf;
        } else{
            throw new MenuOutException("Out of menu range. ");
        }
    }
}
