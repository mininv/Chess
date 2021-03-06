/**
 * Created by vlad on 30.06.16.
 */
public class ValidateInput extends ConsoleInput{

    public int ask(String question, int[] range){
        boolean invalid = true;
        int value = -1;
        do{
            try{
                value = super.ask(question, range);//родительский конструтор метода ask
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

    public char ask(String question, char[] range){
        boolean invalid = true;
        char value = 'z';
        do{
            try{
                value = super.ask(question, range);//родительский конструтор метода ask
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

    public String ask(String question, String[] ra){
        boolean invalid = true;
        String value="";
        do{
            try{
                value = super.ask(question, ra);//родительский конструтор метода ask
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