package justinzwick.chucknorrisfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button aboutButton, settingsButton, startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        startButton = (Button) findViewById(R.id.startButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
