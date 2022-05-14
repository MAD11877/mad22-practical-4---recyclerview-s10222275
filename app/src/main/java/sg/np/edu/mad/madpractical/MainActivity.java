package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent receivingEnd = getIntent();
        User u1 = (User) receivingEnd.getSerializableExtra("User");

        TextView v = findViewById(R.id.textView2);
        TextView username = findViewById(R.id.username);

        v.setText("Description "+u1.getDescription());
        username.setText("Name"+u1.getName());
        Button button = findViewById(R.id.button6);
        Button Msgbutton = findViewById(R.id.button5);
        if (u1.getFollowed() == false) {
            button.setText("Follow");
        } else {
            button.setText("Unfollow");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(button,u1);//Changes status of button
                String status="";
                if (u1.getFollowed() == false) {
                    status="Unfollowed";
                } else {
                    status="Followed";
                }
                Toast toast=Toast.makeText(getApplicationContext(),status,Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        Msgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MessageGroup = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(MessageGroup);

            }
        });
    }
    public void OnClick(Button button,User u1){
        boolean followstatus = u1.getFollowed();
        if (followstatus == false) {
            button.setText("Unfollow");
            u1.setFollowed(true);
        } else {
            button.setText("Follow");
            u1.setFollowed(false);
        }
        Log.e( "OnClick: ", String.valueOf(u1.getFollowed()));

    }


}