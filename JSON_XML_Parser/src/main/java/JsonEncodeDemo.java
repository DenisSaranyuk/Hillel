import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

class JsonEncodeDemo {
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);

        System.out.println();

        String str = "{ \"number\": [3, 4, 5, 6] }";
        JSONObject obj1 = new JSONObject(str);
        JSONArray arr = obj1.getJSONArray("number");
        for (int i = 0; i < arr.length(); i++)
            System.out.println(arr.getInt(i));

        System.out.println();

        String str1 = "{ \"name\": \"Alice\", \"age\": 20 }";
        JSONObject obj2 = new JSONObject(str1);
        String n = obj2.getString("name");
        int a = obj2.getInt("age");
        System.out.println(n + " " + a);  // prints "Alice 20"

        System.out.println();

        String addr = "Ukraine, Teplodar";
        try {
            geocoding(addr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void geocoding(String addr) throws Exception
    {
        // build a URL
        String s = "http://maps.google.com/maps/api/geocode/json?" +
                "sensor=false&address=";
        s += URLEncoder.encode(addr, "UTF-8");
        URL url = new URL(s);

        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object
        JSONObject obj = new JSONObject(str);
        if (! obj.getString("status").equals("OK"))
            return;

        // get the first result
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("formatted_address"));
        JSONObject loc =
                res.getJSONObject("geometry").getJSONObject("location");
        System.out.println("lat: " + loc.getDouble("lat") +
                ", lng: " + loc.getDouble("lng"));

    }
}
