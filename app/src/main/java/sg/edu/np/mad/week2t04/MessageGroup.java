package sg.edu.np.mad.week2t04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        final FirstFragment firstFragment = new FirstFragment();
        final SecondFragment secondFragment = new SecondFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        Button btnFragment1 = findViewById(R.id.btnFragment1);
        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment,firstFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Button btnFragment2 = findViewById(R.id.btnFragment2);
        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment,secondFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}


