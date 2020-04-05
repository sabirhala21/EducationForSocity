package com.example.admin.educationforsocity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String uname=params[1];
        String password=params[2];
        String login_url="http://192.168.43.68//login.php";
        String ragister_url="http://192.168.43.68//ragister.php";
        if (type.equals("login")){
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("uname","UTF-8")+"="+URLEncoder.encode(uname,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {

            } catch (IOException e) {

            }

        }
        else if (type.equals("ragister")){
            try {

                String f_name=params[1];
                String l_name=params[2];
                String dob=params[3];
                String e_mail=params[4];
                String u_name=params[5];
                String pass=params[6];
                URL url=new URL(ragister_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("f_name","UTF-8")+"="+URLEncoder.encode(f_name,"UTF-8")+"&"
               +URLEncoder.encode("l_name","UTF-8")+"="+URLEncoder.encode(l_name,"UTF-8")+"&"
               +URLEncoder.encode("u_dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"
                +URLEncoder.encode("email_id","UTF-8")+"="+URLEncoder.encode(e_mail,"UTF-8")+"&"
                        +URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(u_name,"UTF-8")+"&"
                        +URLEncoder.encode("u_password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {

            } catch (IOException e) {

            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String  result) {
    alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }
}