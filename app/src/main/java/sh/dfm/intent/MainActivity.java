package sh.dfm.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRData;
    Button btnSend;
    Button btnSendError;

    public static MainActivity link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRData = (TextView) findViewById(R.id.tvRData);
        btnSend = (Button) findViewById(R.id.btn1);
        btnSendError = (Button) findViewById(R.id.btnError);

        btnSend.setOnClickListener(this);
        btnSendError.setOnClickListener(this);
        link = this;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            EditText messageView = (EditText) findViewById(R.id.ed1);
            String message = messageView.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.EXTRA_MESSAGE, message);
            startActivityForResult(intent, 1);
        }
        if (v.getId() == R.id.btnError) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("text/error");
            //startActivity(openlinkIntent);


            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 1);

            }else{
              Toast.makeText(getApplicationContext() ,
                        getString(R.string.app_name).toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String rData = data.getStringExtra("rData");
        tvRData.setText(rData);
    }
}
