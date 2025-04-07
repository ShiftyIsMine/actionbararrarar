package kr.ac.kopo.simplec;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView textResult;
    Button btnP,btnDe,btnM,btnDi,btnDiv;

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

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        btnP = findViewById(R.id.btnP);
        btnDe = findViewById(R.id.btnDe);
        btnM = findViewById(R.id.btnM);
        btnDi = findViewById(R.id.btnDi);
        btnDiv = findViewById(R.id.btnDivi);
        textResult = findViewById(R.id.text_result);

        btnP.setOnClickListener(btnListener);
        btnDe.setOnClickListener(btnListener);
        btnM.setOnClickListener(btnListener);
        btnDi.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);

//        btnP.setOnTouchListener(touchListener);
//        btnDe.setOnTouchListener(touchListener);
//        btnM.setOnTouchListener(touchListener);
//        btnDi.setOnTouchListener(touchListener);
//        btnDiv.setOnTouchListener(touchListener);

    }
//    View.OnTouchListener touchListener = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            String num1Str = edit1.getText().toString();
//            String num2Str = edit2.getText().toString();
//
//            if(num1Str.equals("")){
//                Toast.makeText(getApplicationContext(),"only number",Toast.LENGTH_SHORT).show();
//                edit1.setFocusable(true);
//            }
//            else if(num2Str.equals("")){
//                Toast.makeText(getApplicationContext(),"only number",Toast.LENGTH_SHORT).show();
//                edit2.setFocusable(true);
//            }
//
//            int num1 = Integer.parseInt(num1Str);
//            int num2 = Integer.parseInt(num2Str);
//            int result =0;
//
//
//            Button btnEvent = (Button) v;
//            if(btnEvent==btnP)
//                result = num1 + num2;
//            else if(btnEvent ==btnDe)
//                result = num1 - num2;
//            else if (btnEvent==btnM)
//                result = num1 * num2;
//            else if(btnEvent ==btnDiv)
//                if(num2==0){
//                    Toast.makeText(getApplicationContext(),"num2, don't input zero",Toast.LENGTH_SHORT).show();
//                    edit2.setText("");
//                    edit2.setFocusable(true);
//                }else {
//                    result = num1 % num2;
//                }
//            else
//            if(num2==0){
//                Toast.makeText(getApplicationContext(),"num2, don't input zero",Toast.LENGTH_SHORT).show();
//                edit2.setText("");
//                edit2.setFocusable(true);
//            }else {
//                result = num1 / num2;
//            }
//            textResult.setText("result = "+result);
//            return true;
//        }
//    };
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String num1Str = edit1.getText().toString();
            String num2Str = edit2.getText().toString();

            if(num1Str.equals("") || num2Str.equals("")){
                Toast.makeText(getApplicationContext(),"only number",Toast.LENGTH_SHORT).show();
                edit1.setFocusable(true);

            }
            else{
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result =0;


                Button btnEvent = (Button) v;
                if(btnEvent==btnP)
                    result = num1 + num2;
                else if(btnEvent ==btnDe)
                    result = num1 - num2;
                else if (btnEvent==btnM)
                    result = num1 * num2;
                else if(btnEvent ==btnDiv)
                    if(num2==0){
                        Toast.makeText(getApplicationContext(),"num2, don't input zero",Toast.LENGTH_SHORT).show();
                        edit2.setText("");
                        edit2.setFocusable(true);
                    }else {
                        result = num1 % num2;
                    }
                else
                if(num2==0){
                    Toast.makeText(getApplicationContext(),"num2, don't input zero",Toast.LENGTH_SHORT).show();
                    edit2.setText("");
                    edit2.setFocusable(true);
                }else {
                    result = num1 / num2;
                }
                textResult.setText(String.format("result : %.3f",result));
            }

        }
    };
}