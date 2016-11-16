package sh.dfm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText(message);
    }

    @Override
    protected void onDestroy() {
        Log.d("SecondActivity", "activity destroy");
        super.onDestroy();
    }
}
