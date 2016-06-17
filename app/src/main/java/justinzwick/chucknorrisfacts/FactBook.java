package justinzwick.chucknorrisfacts;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FactBook {
    String fact;
    private final OkHttpClient client = new OkHttpClient();


    public FactBook(){
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

               Log.v("DATA FROM CHUCK NORRIS",response.body().string());
            }
        });
    }



}
