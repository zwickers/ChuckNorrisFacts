package justinzwick.chucknorrisfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        FactBook fb = new FactBook();
    }
}
