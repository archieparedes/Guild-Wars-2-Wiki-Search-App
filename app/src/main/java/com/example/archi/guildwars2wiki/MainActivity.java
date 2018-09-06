package com.example.archi.guildwars2wiki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    String userStrInput;
    EditText searchString;
    Button searchButton, redditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // search button
        searchString = (EditText) findViewById(R.id.searchString); // text entry
        searchButton = (Button) findViewById(R.id.searchButton); // button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // what do we want to do when user clicks button
                userStrInput = searchString.getText().toString(); //gets string
                goToUrl(userStrInput);

            }
        });
        // reddit button
        redditButton = (Button) findViewById(R.id.redditButton);
        redditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReddit();
            }
        });
        }

    /* // toast function
    private void showText(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }*/
    private void goToUrl(String text){
        String reformat = text;
        reformat = reformat.replaceAll(" ", "_").toLowerCase(); // replaces spaces with underscores
        reformat = reformat.replaceAll("'", "%27s").toLowerCase(); // replaces apostrophes with %27s
        String web = "https://wiki.guildwars2.com/wiki/" + reformat;
        Uri Url = Uri.parse(web);
        Intent launchBroswer = new Intent(Intent.ACTION_VIEW, Url);
        startActivity(launchBroswer);
    }
    private void goToReddit(){
        String web = "https://www.reddit.com/r/Guildwars2/";
        Uri Url = Uri.parse(web);
        Intent reddit = new Intent(Intent.ACTION_VIEW, Url);
        startActivity(reddit);

    }
}

