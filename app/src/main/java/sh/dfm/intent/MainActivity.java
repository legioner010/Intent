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

    //обяъявляем элементы
    TextView tvRData;
    Button btnSend;
    Button btnSendError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //находим элементы
        tvRData = (TextView) findViewById(R.id.tvRData);
        btnSend = (Button) findViewById(R.id.btn1);
        btnSendError = (Button) findViewById(R.id.btnError);

        //добавляем слушетелей на кнопки
        btnSend.setOnClickListener(this);
        btnSendError.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //если нажата кнопка Отправить на активити2
        if (v.getId() == R.id.btn1) {
            EditText messageView = (EditText) findViewById(R.id.ed1);
            String message = messageView.getText().toString();

            // формируем и отправляем интент на активити 2
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.EXTRA_MESSAGE, message);
            startActivityForResult(intent, 1);
        }
        // если нажата кнопка с неявным и ошибочным типом
        if (v.getId() == R.id.btnError) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("text/error");

            //проверяем если есть ли хоть 1 активити которое может принять интент
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 1);

            } else {
                //если нет то вывощдим тост
                Toast.makeText(getApplicationContext(),
                        getString(R.string.app_name).toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//проверям на нул данные полученные с 2-ого активити
        if (data == null) {
            return;
        }
        //выводим данные в  TextView
        String rData = data.getStringExtra("rData");
        tvRData.setText(rData);
    }
}
//permission добавленны в манифест