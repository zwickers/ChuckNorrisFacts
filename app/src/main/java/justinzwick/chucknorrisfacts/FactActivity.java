package justinzwick.chucknorrisfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    public String mChuckData;
    private TextView mFactText;
    private String mChuckFact;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        mFactText = (TextView) findViewById(R.id.factText);
        mButton = (Button) findViewById(R.id.nextFactButton);
        try {
            doGetRequest("https://api.chucknorris.io/jokes/random");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    doGetRequest("https://api.chucknorris.io/jokes/random");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
                                Toast.makeText(FactActivity.this, "There was an error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        mChuckData = response.body().string();
                        Log.v("CheckData", mChuckData);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(mChuckData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            mChuckFact = jsonObject.getString("value");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mFactText.setText(mChuckFact);
                            }
                        });
                    }
                });
    }
}


