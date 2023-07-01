package sg.edu.np.mad.week2t04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityDiagnosticsManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    String title = "Main Activity";
    private List<User> userList;
    MyDBHandler myDBHandler = new MyDBHandler(this, null, null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "Create");


        userList = new ArrayList<User>();

        Random random = new Random();
        for (int i = 0; i<20; i++){
            String name = "Name"+(random.nextInt(100000));
            String description = "Description:"+(random.nextInt(100000));
            boolean followed = random.nextBoolean();
            myDBHandler.addUser(new User(name, description, (i+2), followed));

            //userList.add(new User(name, description, (i+2), followed));
        }

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "Resume");

        userList = myDBHandler.getUsers();

        RecyclerView recyclerView = findViewById(R.id.reclcyerView);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        MyAdapter myAdapter = new MyAdapter(userList,this);

        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}

