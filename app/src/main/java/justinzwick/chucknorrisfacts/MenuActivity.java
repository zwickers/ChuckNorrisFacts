package justinzwick.chucknorrisfacts;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.view.View;
import android.widget.ImageView;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.widgets.ColorSelector;
import com.gc.materialdesign.widgets.Dialog;

public class MenuActivity extends AppCompatActivity {

    private ButtonRectangle aboutButton, settingsButton, startButton;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setEnterTransition(new ChangeImageTransform());
        aboutButton = (ButtonRectangle) findViewById(R.id.aboutButton);
        settingsButton = (ButtonRectangle) findViewById(R.id.settingsButton);
        startButton = (ButtonRectangle) findViewById(R.id.startButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MenuActivity.this,"About:", "This app gives 100% truthful facts about Chuck Norris. Enjoy!");
                dialog.show();
                ButtonFlat acceptButton = dialog.getButtonAccept();
                acceptButton.setText("OK");
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
