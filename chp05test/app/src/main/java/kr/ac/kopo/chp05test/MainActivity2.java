package kr.ac.kopo.chp05test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText edittext;
    Button btn;
    TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edittext = findViewById(R.id.edit_input);
        btn = findViewById(R.id.btn_output);
        tview=findViewById(R.id.text_result);

        btn.setOnClickListener(dee);
    }
    View.OnClickListener dee = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String input = edittext.getText().toString();
            tview.setText(input);
        }
    };
}