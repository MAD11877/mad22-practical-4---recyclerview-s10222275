package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
                Random rand = new Random(); //instance of random class
                Random rand1 = new Random(); //instance of random class
                Random rand2 = new Random(); //instance of random class
                ArrayList<User> Ulist = new ArrayList<User>();
                int i =0;
                while (i < 20) {
                    int int_random = rand.nextInt();
                    int int_rand_desc=rand1.nextInt();
                    String rand_name=Integer.toString(int_random);
                    String rand_desc= Integer.toString(int_rand_desc);
                    boolean status=rand.nextBoolean();
                    int uid= rand2.nextInt();
                    User u1 = new User(rand_name,rand_desc,uid,status);
                    Ulist.add(u1);
                    i++;
                }

        RecyclerView rv = findViewById(R.id.recylcerview);
        MessageGroupsAdapter adapter = new MessageGroupsAdapter(Ulist,ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);




    }

}

