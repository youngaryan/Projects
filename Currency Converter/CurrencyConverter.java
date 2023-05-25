import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "USD");
        hashMap.put(2, "KWD");
        hashMap.put(3, "GBP");
        hashMap.put(4, "IRR");

        String fromCode, toCode;
        double amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println(hashMap);

        System.out.println("Which currency from?");
        fromCode = hashMap.get(scanner.nextInt());

        System.out.println("Which currency to?");
        toCode = hashMap.get(scanner.nextInt());

        System.out.println("Enter the amount you would like to convert: ");
        amount = scanner.nextFloat();

        scanner.close();

        sendHttpRquest(amount,fromCode,toCode);

    }

    private static void sendHttpRquest(double amount, String fromCode, String toCode) throws IOException {
        String url_str = "https://api.exchangerate.host/latest?base="+ toCode + "&symbols=" + fromCode;
        DecimalFormat f = new DecimalFormat("0.00");

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        int responseCode = request.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            double exchangeRate = jsonObject.getJSONObject("rates").getDouble(fromCode);

            System.out.println(f.format(amount) + " " + fromCode + " = " + f.format(amount/exchangeRate) + " " + toCode);
        }
        else
            System.out.println("Connection Failed!");
    }
}
