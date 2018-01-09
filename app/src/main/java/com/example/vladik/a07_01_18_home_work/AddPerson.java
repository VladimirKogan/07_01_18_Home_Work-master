package com.example.vladik.a07_01_18_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AddPerson extends AppCompatActivity {

    private MenuItem cancelItem, pushItem;
    private EditText nameInput, phoneInput, emailInput, descriptionInput;
    private String nameInputStr, phoneInputStr, emailInputStr, descriptionInputStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        Log.d("MY_TAG", "SHALOM!!");
        nameInput = findViewById(R.id.name_input);
        phoneInput = findViewById(R.id.phone_input);
        emailInput = findViewById(R.id.email_input);
        descriptionInput = findViewById(R.id.description_input);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        cancelItem = menu.findItem(R.id.cancel_item);
        pushItem = menu.findItem(R.id.push_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.push_item){createItem();}
        if(item.getItemId() == R.id.cancel_item){}

        return super.onOptionsItemSelected(item);
    }
    public void createItem(){
        Log.d("MY_TAG", "CREATE ITEM LOGGING");
        nameInputStr = nameInput.getText().toString();
        phoneInputStr = phoneInput.getText().toString();
        emailInputStr = emailInput.getText().toString();
        descriptionInputStr = descriptionInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("NAME", nameInputStr);
        intent.putExtra("PHONE", phoneInputStr);
        intent.putExtra("EMAIL", emailInputStr);
        intent.putExtra("DSCRP", descriptionInputStr);

        setResult(RESULT_OK, intent);
        finish();
    }

}
