package com.example.vladik.a07_01_18_home_work;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItem;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    private MenuItem logOutItem, addItem;
    private ProgressBar my_progress;
    private String email, pass, fileName;
    private String new_name, new_phone, new_email, new_description;

    private android.widget.ListView myList;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Log.d("MY_TASK", "CREATED ACTIVITY");
        Intent intent = getIntent();
        if(intent != null){
            email = intent.getExtras().getString("EMAIL");
            pass = intent.getExtras().getString("PASS");
            fileName = email+pass;
        }
        adapter = new MyAdapter();
        //myList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.list_menu, menu);
            logOutItem = menu.findItem(R.id.done_item);
            addItem = menu.findItem(R.id.add_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.done_item){Toast.makeText(this, "LogOut", Toast.LENGTH_LONG).show();}
        if(item.getItemId() == R.id.add_item){
            Intent intent = new Intent(this, AddPerson.class);
            startActivityForResult(intent, 1);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                data = getIntent();
                new_name = data.getExtras().getString("NAME");
                new_phone = data.getExtras().getString("PHONE");
                new_email = data.getExtras().getString("EMAIL");
                new_description = data.getExtras().getString("DSCRP");

                Person p = new Person(new_name, new_phone, new_email, new_description);
                adapter.addPerson(p);

            }
        }
    }

    class MyTask extends AsyncTask<Void, ArrayList<Person>, Void>{

        @Override
        protected void onPreExecute() {
            my_progress.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }

    class MyAdapter extends BaseAdapter{
        private ArrayList<Person> users;

        public MyAdapter(){
            users = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public Object getItem(int i) {
            return users.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.my_row, viewGroup, false);
            TextView name_txt = view.findViewById(R.id.name_txt);
            TextView phone_txt = view.findViewById(R.id.phone_txt);
            TextView email_txt = view.findViewById(R.id.email_txt);
            TextView dscr_txt = view.findViewById(R.id.description_txt);

            name_txt.setText(users.get(i).getName());
            phone_txt.setText(users.get(i).getPhone());
            email_txt.setText(users.get(i).getEmail());
            dscr_txt.setText(users.get(i).getDescription());

            return view;
        }
        public void addPerson(Person p){
            users.add(0, p);
            notifyDataSetChanged();
        }
    }
}
