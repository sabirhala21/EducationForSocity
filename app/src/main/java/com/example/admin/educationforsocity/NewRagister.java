package com.example.admin.educationforsocity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewRagister extends Activity {
    public EditText fname,lname,date,email,uname,pass;

    public Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ragister);
        fname=(EditText)findViewById(R.id.firstname);
        lname=(EditText)findViewById(R.id.lastname);
        date=(EditText)findViewById(R.id.dob);
        email=(EditText)findViewById(R.id.email);
        uname=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
    }

    public void OnRagister(View view)
    {

        String f_name=fname.getText().toString();
        String l_name=lname.getText().toString();
        String b_date=date.getText().toString();
        String u_email=email.getText().toString();
        String u_name=uname.getText().toString();
        String u_pass=pass.getText().toString();
        String type="ragister";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type, f_name, l_name, b_date, u_email, u_name, u_pass);
        fname.setText("");
        lname.setText("");
        date.setText("");
        email.setText("");
        uname.setText("");
        pass.setText("");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_ragister, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
