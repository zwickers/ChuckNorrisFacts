package justinzwick.chucknorrisfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FactActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private String mChuckData;
    private TextView mFactText;
    private String mChuckFact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        mFactText = (TextView) findViewById(R.id.factText);
        try {
            doGetRequest("https://api.chucknorris.io/jokes/random");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            setFact();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void doGetRequest(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(final Call call, IOException e) {
                        // Error

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // For the example, you can show an error dialog or a toast
                                // on the main UI thread
                                Toast.makeText(FactActivity.this, "there was an error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        mChuckData = response.body().string();

                    }
                });
    }

    public void setFact() throws JSONException {
        JSONObject jsonObject = new JSONObject(mChuckData);
        mChuckFact = jsonObject.getString("value");
    }
}


