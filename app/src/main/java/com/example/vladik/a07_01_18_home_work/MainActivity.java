package com.example.vladik.a07_01_18_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MenuItem login;
    private EditText email, pass;
    private String emailStr, passStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_input);
        pass = findViewById(R.id.password_input);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        login = menu.findItem(R.id.login_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.login_item){
            emailStr = email.getText().toString();
            passStr = pass.getText().toString();
            Intent intent = new Intent(this, ListView.class);
            intent.putExtra("EMAIL", emailStr);
            intent.putExtra("PASS", passStr);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
