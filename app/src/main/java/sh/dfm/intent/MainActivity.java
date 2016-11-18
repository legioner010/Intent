package sh.dfm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvRData;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRData = (TextView) findViewById(R.id.tvRData);
        btnSend = (Button) findViewById(R.id.btn1);

        btnSend.setOnClickListener(this);
    }


     @Override
    public void onClick(View v) {
        EditText messageView = (EditText) findViewById(R.id.ed1);
        String message = messageView.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
        if(data == null){return;}
        String rData = data.getStringExtra("rData");
        tvRData.setText(rData);
    }
}
