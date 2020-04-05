package com.example.admin.educationforsocity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    public Button button_login,ragister;
    public EditText e1,e2;
    public String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
   public void OnLogin(View view){
       String u_name=e1.getText().toString();
       String u_pass=e2.getText().toString();
       String type="login";
       BackgroundWorker backgroundWorker=new BackgroundWorker(this);
       backgroundWorker.execute(type,u_name,u_pass);
        e1.setText("");
       e2.setText("");
   }
    public void OnRagister(View view){
        startActivity(new Intent(this, NavigationMenu.class));
    }

}
