package com.mac.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mac.newsapp.interfaces.ObservableEntity;
import com.mac.newsapp.models.AlterationEntity;
import com.mac.newsapp.models.ToastEntity;

public class MainActivity extends AppCompatActivity implements ObservableEntity {

    private EditText newsString;
    private Button sendButton;
    private TextView newsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsString = (EditText) findViewById(R.id.newsString);
        sendButton = (Button) findViewById(R.id.sendButton);
        newsText = (TextView) findViewById(R.id.news);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String news = newsString.getText().toString();
                if(!news.isEmpty()){
                    NewsBroadcaster.youGotNewsBrah(news);
                }
            }
        });

        // see console log for the output of this entity:
        NewsBroadcaster.registerForNews(new AlterationEntity());

        // see toast for the output of this entity:
        NewsBroadcaster.registerForNews(new ToastEntity(this));

        // see activity screen for the output of this entity:
        NewsBroadcaster.registerForNews(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void notify(String news) {
        newsText.setText("Surprise! You activity also registered for news. News:\n"+news);
    }
}
