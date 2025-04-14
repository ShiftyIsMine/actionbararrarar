package kr.ac.kopo.showpetpics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkStart;
    LinearLayout ls;
    Button btn_1;
    RadioGroup rg;
    RadioButton rbp,rbm,rbc;
    ImageView img;
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
        checkStart = findViewById(R.id.check_start);
        ls = findViewById(R.id.linear_sub);
        rg = findViewById(R.id.rg_1);
        rbp = findViewById(R.id.rb_1);
        rbm = findViewById(R.id.rb_2);
        rbc = findViewById(R.id.rb_3);
        btn_1 = findViewById(R.id.btn_1);
        img = findViewById(R.id.img_1);

        ls.setVisibility(View.INVISIBLE);
        checkStart.setOnCheckedChangeListener(checkStartListener);
        btn_1.setOnClickListener(btn_1Listener);

    }
    CompoundButton.OnCheckedChangeListener checkStartListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                ls.setVisibility(View.VISIBLE);
            }
            else{
                ls.setVisibility(View.INVISIBLE);
            }
        }
    };
    View.OnClickListener btn_1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int selectedrbId = rg.getCheckedRadioButtonId();
            if(selectedrbId==R.id.rb_1){
                img.setImageResource(R.drawable.amlfu);
            }
            else if(selectedrbId==R.id.rb_2){
                img.setImageResource(R.drawable.cat);
            }
            else{
                img.setImageResource(R.drawable.malt);
            }
        }
    };

}