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
        boolean invalid = true;
        int value = -1;
        do{
            try{
                value = ask(question, range);
                invalid = false;
            }catch(MenuOutException moe){
                System.out.println("Please select key from menu. ");
            }
            catch(NumberFormatException nfe){
                System.out.println("Please enter validate data again. ");
            }
        }while(invalid);
        return value;
    }
}
