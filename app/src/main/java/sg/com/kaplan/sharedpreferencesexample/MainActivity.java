package sg.com.kaplan.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double hiscore = 0; //instance variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE); //handle, it's like a file
        hiscore = sharedPref.getFloat("highscore", 0);

        textView.setText("High score: " + hiscore); //initial display


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v = Double.parseDouble(editText.getText().toString());
                hiscore = v; //set new high score, should check if higher than existing
                textView.setText("High score: " + hiscore);

                //save to app
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("highscore", (float) hiscore);
                editor.commit();
            }
        });
    }
}
