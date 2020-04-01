package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView varResult;
    TextView varWinner;
    private int lama = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        varResult = findViewById(R.id.txt_result);
        varWinner = findViewById(R.id.txt_winner);

        Bundle extras = getIntent().getExtras();
        // get nilai dari match
        int homeResult = extras.getInt("homeScore");
        int awayResult = extras.getInt("awayScore");
        String txtHomeName = extras.getString("homeName");
        String txtAwayName = extras.getString("awayName");

        if(extras != null ){
            varResult.setText("Final Score : "+String.valueOf(homeResult) + " - " + String.valueOf(awayResult));
            if(homeResult > awayResult){
                varWinner.setText("Tim "+txtHomeName + " adalah pemenangnya!");
            }else if(awayResult > homeResult){
                varWinner.setText("Tim "+txtAwayName + " adalah pemenangnya!");
            }else{
                varWinner.setText("DRAW");
            }
        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(ResultActivity.this, ViewSplash2.class);
                startActivity(home);
                finish();
            }
        }, lama);

    }
}
