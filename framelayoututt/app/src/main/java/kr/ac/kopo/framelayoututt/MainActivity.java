package kr.ac.kopo.framelayoututt;

import android.content.DialogInterface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearSpring,linearSummer,linearFall,linearWinter;
    Button btn_sp,btn_su,btn_fa,btn_win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        linearSpring = findViewById(R.id.linear_spring);
        linearSummer = findViewById(R.id.linear_summer);
        linearFall = findViewById(R.id.linear_fall);
        linearWinter = findViewById(R.id.linear_winter);
        btn_sp = findViewById(R.id.btn_spring);
        btn_su = findViewById(R.id.btn_summer);
        btn_fa = findViewById(R.id.btn_fallorautumn);
        btn_win = findViewById(R.id.btn_winter);

        btn_sp.setOnClickListener(btnListener);
        btn_su.setOnClickListener(btnListener);
        btn_fa.setOnClickListener(btnListener);
        btn_win.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            linearSpring.setVisibility(View.INVISIBLE);
            linearSummer.setVisibility(View.INVISIBLE);
            linearFall.setVisibility(View.INVISIBLE);
            linearWinter.setVisibility(View.INVISIBLE);
            Button btnEvent = (Button) v;
            if(btnEvent == btn_sp){
                linearSpring.setVisibility(View.VISIBLE);
            } else if (btnEvent == btn_su) {
                linearSummer.setVisibility(View.VISIBLE);
            }else if(btnEvent == btn_fa){
                linearFall.setVisibility(View.VISIBLE);
            }else{
                linearWinter.setVisibility(View.VISIBLE);
            }
        }
    };

}