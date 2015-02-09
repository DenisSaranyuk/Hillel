import java.io.Console;
import java.util.Scanner;

/**
 * Created by denis on 20.10.14.
 */
public class CreateMessage {


    public static String fromEmail;
    public static String password;
    public static String toEmail;
    public static String title;
    public static String text;

    public static void createMessage() {

        try{
            Console cnsl;
            if ((cnsl = System.console()) != null) {
                fromEmail = cnsl.readLine("From: ");
                char[] pwd = cnsl.readPassword("Password: ");
                password = String.valueOf(pwd);
                toEmail = cnsl.readLine("To: ");
                title = cnsl.readLine("Title: ");
            } else {
                System.err.println("Console opa!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
/*      //For IDE:
        System.out.print("From: ");
        fromEmail = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        System.out.print("To: ");
        toEmail = scanner.nextLine();
        System.out.print("Title: ");
        title = scanner.nextLine();
*/
        System.out.print("[enter \".\" in new line for send email]\nText: ");
        StringBuilder builder = new StringBuilder();
        String s;
        while (!(s = scanner.nextLine()).equals(".")) {
            if (s.contains("")) {
                builder.append(s).append('\n');
            }
        }
        text = String.valueOf(builder);
    }
}
