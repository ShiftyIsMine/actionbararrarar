package kr.ac.kopo.widgettest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enable_click_test);
//        rgg1=findViewById(R.id.rgg);
//        rgg1.getCheckedRadioButtonId();
//        Button btnDone = findViewById(R.id.btn_done);
//
//        btnDone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String result = "";
//                if(rgg1.getCheckedRadioButtonId() == R.id.rb_M)
//                    result=getResources().getString(R.string.male);
//                else
//                    result=getResources().getString(R.string.female);
//
//                Toast toast = Toast.makeText(getApplicationContext(),result+"을 선택함",Toast.LENGTH_SHORT);
//                toast.show();
//
//            }
//        });


    }
}