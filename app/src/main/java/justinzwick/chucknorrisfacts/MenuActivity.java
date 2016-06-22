package justinzwick.chucknorrisfacts;

import android.app.ActivityOptions;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private Button aboutButton, settingsButton, startButton;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        startButton = (Button) findViewById(R.id.startButton);
        getWindow().setEnterTransition(new ChangeImageTransform());

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ad = new AboutDialog();
                ad.show(getFragmentManager().beginTransaction(),"ok");
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

                Intent intent = new Intent(MenuActivity.this,FactActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MenuActivity.this).toBundle());
            }
        });
    }
}
