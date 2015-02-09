import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by denis on 12.10.14.
 */
public class FileOperations {

    public static boolean programExit = false;

    public static void createFile(String pathSourceFile) {

        File file = new File(pathSourceFile);

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Файл " + file.getName() + " создан");
            } catch (IOException e) {
                System.err.println("Ошибка создания файла!");
            }
        } else {
            System.err.println("Такой файл уже существует!");
        }
    }

    public static void copyFile(String pathSourceFile, String pathReceiverFile) {

        File sourceFile = new File(pathSourceFile);
        File receiverFile = new File(pathReceiverFile);

        if (sourceFile.exists()) {
            try {
                if (receiverFile.exists()) { // если конечный файл уже существует
                    checkExistReceiverFile(receiverFile);
                }

                Files.copy(sourceFile.toPath(), receiverFile.toPath());

                System.out.println("Файл " + sourceFile.getName() + " скопирован в " + receiverFile.getName());
            } catch (IOException e) {
                System.err.println("Ошибка копирования!");
            }
        } else {
            System.err.println("Неверно указан путь к файлам!");
        }
    }

    public static void deleteFile(String pathSourceFile) {

        File file = new File(pathSourceFile);

        if (file.exists()) {
            file.delete();
            System.out.println("Файл " + file.getName() + " удален");
        } else {
            System.err.println("Файл не найден");
        }
    }

    public static void renameRemoveFile(String pathSourceFile, String pathReceiverFile) {

        File sourceFile = new File(pathSourceFile);
        File receiverFile = new File(pathReceiverFile);

        if (sourceFile.exists()) {

            if (receiverFile.exists()) {
                checkExistReceiverFile(receiverFile);
            }

            sourceFile.renameTo(receiverFile);

            System.out.println("Файл " + sourceFile.getName() + " переименован в " + receiverFile.getName());
        } else {
            System.err.println("Исходный файл не найден");
        }
    }

    public static void directoryList(String dirPath) {
        File directory = new File(dirPath);
        String[] files = directory.list();
        Arrays.sort(files);
        for (String file : files) {
            System.out.print(file + " ");
        }
        System.out.println();
    }

    public static void inputCommand() {

        String command;
        command = commandLineReader();
        String[] commandAndPath = command.split(" ");
        commandAndPath[0] = commandAndPath[0].toLowerCase();

        try {
            switch (commandAndPath[0]) {
                case "ls":
                    if (commandAndPath.length == 1) {
                        FileOperations.directoryList(".");
                    } else {
                        FileOperations.directoryList(commandAndPath[1]);
                    }
                    break;
                case "cr":
                    FileOperations.createFile(commandAndPath[1]);
                    break;
                case "cp":
                    FileOperations.copyFile(commandAndPath[1], commandAndPath[2]);
                    break;
                case "rm":
                    FileOperations.renameRemoveFile(commandAndPath[1], commandAndPath[2]);
                    break;
                case "del":
                    FileOperations.deleteFile(commandAndPath[1]);
                    break;
                case "exit":
                    programExit = true;
                    break;
                default:
                    System.err.println("Command isn't correct!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Errors input parameters!");
        }
    }

    public static String commandLineReader() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void checkExistReceiverFile(File receiverFile) {
        boolean flagCopyFile = true;

        while (flagCopyFile) {

            System.out.print("Конечный файл уже существует, перезаписать его? Y/n: ");
            String tempCopyFile = commandLineReader().toLowerCase();

            switch (tempCopyFile) {
                case "y":
                case "":
                    receiverFile.delete();
                    flagCopyFile = false;
                    break;
                case "n":
                    System.err.println("Копирование отменено");
                    return;
                default:
                    System.err.println("Неверно введена команда!");
                    break;
            }
        }
    }
}