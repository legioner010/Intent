package sh.dfm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "id";

    EditText etRDara;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etRDara = (EditText) findViewById(R.id.edRData);
        btnOK = (Button) findViewById(R.id.btnSendRData);
        btnOK.setOnClickListener(this);


        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText(message);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("rData", etRDara.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
