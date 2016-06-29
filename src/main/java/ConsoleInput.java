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
}
