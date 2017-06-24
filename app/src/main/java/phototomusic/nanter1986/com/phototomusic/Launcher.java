package phototomusic.nanter1986.com.phototomusic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launcher extends Activity {

    Button chordBased;
    Button melodyBased;
    Button learning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        chordBased=(Button)findViewById(R.id.chordBased);
        melodyBased=(Button)findViewById(R.id.malodyBased);
        learning=(Button)findViewById(R.id.learning);
        chordBased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChord();
            }
        });
        melodyBased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTOMelody();
            }
        });
        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTOLearning();
            }
        });
    }

    private void goTOLearning() {
        /*Intent i=new Intent(this,LearningActivity.class);
        startActivity(i);
        finish();*/
    }

    private void goTOMelody() {
        Intent i=new Intent(this,MelodyMainActivity.class);
        startActivity(i);
        finish();
    }

    private void goToChord() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
