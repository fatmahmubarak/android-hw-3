package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = findViewById(R.id.textView);
        TextView age = findViewById(R.id.textView2);
        TextView job = findViewById(R.id.textView3);
        TextView phone = findViewById(R.id.textView4);
        TextView email = findViewById(R.id.textView5);
        Button but = findViewById(R.id.button);
        Button call = findViewById(R.id.dial);
        Button button = findViewById(R.id.but);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+950754554"));
                startActivity(intent);

            }
        });



        Bundle a = getIntent().getExtras();
        String m = a.getString("name");
        name.setText(m);

        String t = a.getString("age");
        age.setText(t);

        String j = a.getString("yourjop");
        job.setText(j);

        String p = a.getString("phone");
        phone.setText(p);

        String e = a.getString("email");
        email.setText(e);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity2.this , MainActivity.class);
                startActivity(n);
            }
        });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               btn_email();
           }
       });


    }


    public void btn_email() {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
                   intent.setData(Uri.parse("mailto:"));
                   intent.setType("message/rfc822");
                   intent.putExtra(Intent.EXTRA_EMAIL, "Fatmahsaleemah@gmail.com");
                   intent.putExtra(Intent.EXTRA_SUBJECT,"عنوان الرساله");
                   intent.putExtra(Intent.EXTRA_TEXT, "موضوع الرساله");
                   startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this,"عذرا لا يوجد تطبيق بريد",Toast.LENGTH_LONG).show();

        }

    }

}