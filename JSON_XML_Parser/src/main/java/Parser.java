import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

/**
 * Created by denis on 27.10.14.
 */
public class Parser {
    private static String requestPathFile() {
        System.out.print("Input file's path, please: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        try {
            path = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: requestPathFile");
        }
        return path;
    }

    public static String readSourceFile() {
        File sourceFile = new File(requestPathFile());
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scan = null;
        try {
            scan = new Scanner(sourceFile);
            while (scan.hasNext())
                stringBuilder.append(scan.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Error: FileNotFoundException");
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return String.valueOf(stringBuilder);
    }

    public static void parserJSON(String pathSourceFile) {

        JSONObject object = new JSONObject(pathSourceFile);
        System.out.println(object.getString("name") + " " + object.getInt("age"));

        JSONObject obj1 = object.getJSONObject("address");
        System.out.println(obj1.getString("city") + " " + obj1.getString("streetAddress"));

        JSONObject obj = object.getJSONArray("phoneNumber").getJSONObject(0);
        System.out.println(obj.getString("type") + " " + obj.getString("number"));

        JSONObject obj2 = object.getJSONArray("phoneNumber").getJSONObject(1);
        System.out.println(obj2.getString("type") + " " + obj2.getString("number"));
    }
}
