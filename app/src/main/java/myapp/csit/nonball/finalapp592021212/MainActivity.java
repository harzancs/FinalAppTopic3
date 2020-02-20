package myapp.csit.nonball.finalapp592021212;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import static myapp.csit.nonball.finalapp592021212.ProductBean.BASE_URL;

public class MainActivity extends AppCompatActivity {
    private ProductBean mProductBean;
    private EditText txt1,txt2,txt3,txt4;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProductBean = getIntent().getParcelableExtra("product_bean");

//        if (mProductBean == null) {
//            finish();
//        }

        bindWidget();
        setupEventWidget();
    }

    private void bindWidget() {
        txt1 = (EditText) findViewById(R.id.etxt1);
        txt2 = (EditText) findViewById(R.id.etxt2);
        txt3 = (EditText) findViewById(R.id.etxt3);
        txt4 = (EditText) findViewById(R.id.etxt4);
        bt = (Button) findViewById(R.id.btsave);
    }

    private void setupEventWidget() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertAsyn().execute(BASE_URL + "insert.php");
            }
        });


    }

    private class InsertAsyn extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {

                OkHttpClient _okHttpClient = new OkHttpClient();
                @SuppressLint("WrongThread") RequestBody _requestBody = new FormBody.Builder()
                        .add("id", txt1.getText().toString())
                        .add("name", txt2.getText().toString())
                        .add("major", txt3.getText().toString())
                        .add("grad", txt4.getText().toString())
                        .build();

                Request _request = new Request.Builder().url(strings[0]).post(_requestBody).build();

                _okHttpClient.newCall(_request).execute();

                return "successfully";

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {
                Toast.makeText(MainActivity.this, "insert successfully", Toast.LENGTH_SHORT).show();
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
            } else {
                Toast.makeText(MainActivity.this, "insert failure",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
