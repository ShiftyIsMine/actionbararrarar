package com.example.myapplication2;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit_name,edit_age,edit_height,edit_wegiht;
    RadioGroup rg_1;
    RadioButton rbm,rbf;
    Button btn_d,btn_r;
    ImageView img;
    LinearLayout fold_layout;
    TextView result_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        edit_name = findViewById(R.id.name_et);
        edit_age = findViewById(R.id.age_et);
        edit_height = findViewById(R.id.height_et);
        edit_wegiht = findViewById(R.id.weight_et);
        btn_d = findViewById(R.id.btn_done);
        img = findViewById(R.id.image_view);
        fold_layout = findViewById(R.id.fold_layout);
        rg_1 = findViewById(R.id.rg_1);
        rbm = findViewById(R.id.male_select);
        rbf = findViewById(R.id.female_select);
        result_v = findViewById(R.id.result_view);
        btn_r = findViewById(R.id.btn_reset);

        fold_layout.setVisibility(INVISIBLE);
        btn_d.setOnClickListener(done);
        btn_r.setOnClickListener(reset);
    }
    View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            edit_age.setText("");
            edit_height.setText("");
            edit_name.setText("");
            edit_wegiht.setText("");
            rbf.setChecked(false);
            rbm.setChecked(false);
            fold_layout.setVisibility(INVISIBLE);
        }
    };
    View.OnClickListener done = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                String name = edit_name.getText().toString().trim();
                String age = edit_age.getText().toString().trim();
                String height = edit_height.getText().toString().trim();
                String weight = edit_wegiht.getText().toString().trim();

                if (name.isEmpty() || age.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(MainActivity.this, "전부 채워주세여", Toast.LENGTH_SHORT).show();
                    return;
                }
                int agei = Integer.parseInt(age);
                float heightf = Float.parseFloat(height) / 100; // Convert cm to m
                float weightf = Float.parseFloat(weight);
                boolean male = rbm.isChecked();
                //            boolean female = rbm.isChecked();

                float bmi = weightf / (heightf * heightf);
//                int result_int = Math.round(bmi);

                String cate;

                int imageResourceId;

                if (bmi < 18.5) {
                    cate = "저체중";
                    imageResourceId = R.drawable.images_2;
                } else if (bmi < 25) {
                    cate = "정상";
                    imageResourceId = R.drawable.normal;
                } else if (bmi < 30) {
                    cate = "과체중";
                    imageResourceId = R.drawable.panic;
                } else {
                    cate = "비만";
                    imageResourceId = R.drawable.images;
                }
                img.setImageResource(imageResourceId);
                fold_layout.setVisibility(View.VISIBLE);
//                fold_layout.removeAllViews();

                String gender = male ? "남" : "여";
                result_v.setText(name + "님" + "의 BMI는 " + String.format("%.2f", bmi) + "이고, " + cate + "입니다.");
                fold_layout.addView(result_v);
            }catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "나이, 키, 몸무게에 유효한 숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "오류 발생: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    };

}