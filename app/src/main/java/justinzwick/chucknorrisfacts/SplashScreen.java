package justinzwick.chucknorrisfacts;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.ChangeImageTransform;
import android.transition.Fade;

public class SplashScreen extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);
        getWindow().setExitTransition(new ChangeImageTransform());
        /* New Handler to start the FactActivity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the FactActivity. */
                Intent mainIntent = new Intent(SplashScreen.this,MenuActivity.class);
                SplashScreen.this.startActivity(mainIntent, ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,findViewById(R.id.logoImage),"logo").toBundle());
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}