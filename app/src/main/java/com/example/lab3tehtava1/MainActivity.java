package com.example.lab3tehtava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        findViewById (R.id.urlButton).setOnClickListener (this);






    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.urlButton){
            final TextView osoite = (TextView) findViewById (R.id.url);
            final TextView vastaus = (TextView) findViewById (R.id.textView2);


            RequestQueue queue = Volley.newRequestQueue (this );
            String url = osoite.getText ().toString ();

            StringRequest stringRequest = new StringRequest (Request.Method.GET, url, new Response.Listener<String> ( ) {
                @Override
                public void onResponse(String response) {
                    vastaus.setText ("Response is: " + response.toString ());

                }
            }, new Response.ErrorListener ( ) {
                @Override
                public void onErrorResponse(VolleyError error) {

                    vastaus.setText ("That didn't work");

                }
            });

            queue.add (stringRequest);
        }

    }
}
