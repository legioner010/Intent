package sh.dfm.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btn1Click(View view) {
        EditText messageView = (EditText) findViewById(R.id.ed1);
        String message= messageView.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE,message);


//   Verufy that intent will resilve to an activity
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }



//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("*/*");

      //  startActivity(intent);


    }
}
