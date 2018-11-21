package com.example.foolishfan.user_v10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class User extends AppCompatActivity {
    private Button mReturnButton;
    private  Button enter;
    private TextView un=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_success_login);
        setContentView(R.layout.user);
        mReturnButton = (Button)findViewById(R.id.returnback);
        un=(TextView)findViewById(R.id.name);
        enter =(Button)findViewById(R.id.enter);

        Intent intent = getIntent();
       String userName= intent.getStringExtra("userName");
       un.setText(userName);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(User.this ,EnterActivity.class);
                startActivity(i);
            }
        });
    }
    public void back_to_login(View view) {
        //setContentView(R.layout.login);
        Intent intent3 = new Intent(User.this,Login.class) ;
        startActivity(intent3);
        finish();

    }


}
