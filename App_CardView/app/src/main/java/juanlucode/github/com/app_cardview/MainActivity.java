package juanlucode.github.com.app_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoTextView = (TextView) findViewById(R.id.textoTextView);

        textoTextView.setText("Hola, sr. programador...");
    }
}
