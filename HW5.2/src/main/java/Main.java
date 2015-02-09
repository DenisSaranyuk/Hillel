/**
 * Created by denis on 12.10.14.
 */

/**
 * НЕ создает файл если НЕ существует директория с таким путем - можно доделать проверку и создание папки
 * добавить: запись строк в файл с консоли(как сделал в SendMail)?
 * переход в другой каталог
 * параметры команд?
 * тесты на все операции?
*/
public class Main {
    public static void main(String[] args) {

        printCommandMenu();

        while (!FileOperations.programExit) {
            System.out.print("input your command:~ > ");
            FileOperations.inputCommand();
        }
    }

    public static void printCommandMenu() {
        System.out.printf("Dir view: \t %s\n", "ls [путь к директории]");
        System.out.printf("Create: \t %s\n", "cr [путь к файлу]");
        System.out.printf("Copy: \t \t %s\n", "cp [путь к файлу] [путь к файлу]");
        System.out.printf("Remove/Rename: \t %s\n", "rm [путь к файлу] [путь к файлу]");
        System.out.printf("Delete: \t %s\n", "del [путь к файлу]");
        System.out.println("For end of Program input \"exit\", please.");
    }
}
