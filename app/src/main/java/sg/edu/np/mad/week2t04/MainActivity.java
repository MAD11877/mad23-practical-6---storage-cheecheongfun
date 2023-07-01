package sg.edu.np.mad.week2t04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User user;

    MyDBHandler myDBHandler = new MyDBHandler(this,null,null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");
        //user1 = new User("MAD "+generateRanNum(), "[Text]");
        TextView boldtext = findViewById(R.id.textView2);
        TextView normtext = findViewById(R.id.textView3);

        Intent intent = getIntent();
        user = intent.getParcelableExtra("User");


        boldtext.setText(user.name);
        normtext.setText(user.description);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE,"On Pause!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume!");

        Button followButton = findViewById(R.id.button);
        if (user.followed == true){
            followButton.setText("Unfollow");
        }
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.followed == false){
                    user.followed = true;
                    followButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    myDBHandler.updateUser(user);
                }
                else{
                    user.followed = false;
                    followButton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    myDBHandler.updateUser(user);
                }
                Log.v(TITLE,"Button A is pressed");
            }
        });

        Button messageButton = findViewById(R.id.button2);
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(myIntent1);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy!");
    }
}