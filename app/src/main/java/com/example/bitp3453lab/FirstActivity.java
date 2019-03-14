package com.example.bitp3453lab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {

    TextView txtvmAge;
    EditText editTextName,editTextYear;
    Button btnMe;
    ImageView iv;

    Calendar calendar = Calendar.getInstance();
    int yoty = calendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtvmAge = (TextView) findViewById(R.id.txtvmAge);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextYear = (EditText) findViewById(R.id.editTextYear);
        btnMe = (Button) findViewById(R.id.btnMe);
    }

    public void fnGreet(View view)
    {
        String strName = editTextName.getText().toString();
        String strYear = editTextYear.getText().toString();

        if(strName.equalsIgnoreCase(""))
        {
            editTextName.setError("Enter in your name");
        }
        else if (strYear.equalsIgnoreCase(""))
        {
            editTextYear.setError("Enter in your birth year");
        }
        else
        {
            int Age = yoty - Integer.valueOf(strYear);
            txtvmAge.setText("Hellooo and welcome " +strName+ " You are "+Age+ " years old");
        }
    }

    public void fnThreadedActivity(View vw)
    {
        String strMsg= editTextName.getText().toString();

        if(strMsg.equalsIgnoreCase(""))
        {
            editTextName.setError("Enter in your name");
        }
        else {
            Intent intent = new Intent(this, ThreadedActivity.class);
            intent.putExtra("varStr1", strMsg);
            startActivityForResult(intent,2);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2){
            ImageView iv = (ImageView)findViewById(R.id.imgFrmActivity2);
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            txtvmAge.setText("Picture from activity 2 shown below:");
            iv.setImageBitmap(bp);
        }
    }
}
