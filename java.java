import java.math.BigInteger;
import org.json.*;
import java.net.*;
import java.io.*;

public class Java {

    public static void main(String[] args) throws Exception {
        try {
            String token = "XXXXXXX";
            String url = "https://api.telegram.org/bot" + token + "/";
            JSONObject request = new JSONObject(readUrl(url + "getUpdates"));

            JSONArray result = request.getJSONArray("result");

            for (int i = 0; i < result.length(); ++i) {
                JSONObject message = result.getJSONObject(i).getJSONObject("message");
                String text=message.get("text").toString();
                JSONObject chat = message.getJSONObject("chat");
                BigInteger chat_id= new BigInteger(chat.get("id").toString());
                if(text.equals("/start")){
                    String hw=URLEncoder.encode("Hello world", "UTF-8");
                    JSONObject sendMessage = new JSONObject(readUrl(url + "sendMessage?chat_id="+chat_id+"&text="+hw));
                    System.out.println(sendMessage);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

}

