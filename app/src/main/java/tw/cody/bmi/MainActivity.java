package tw.cody.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText cm, kgw;
    private TextView figure, health, range;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = findViewById(R.id.cm);
        kgw = findViewById(R.id.kgw);
        figure = findViewById(R.id.figure);
        health = findViewById(R.id.health);
        group = findViewById(R.id.group);
        range = findViewById(R.id.range);


    }


    public void count (View view) {
        if (group.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "請選擇性別", Toast.LENGTH_SHORT).show();
        } else if (cm.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "請輸入身高", Toast.LENGTH_SHORT).show();
        } else if (kgw.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "請輸入體重", Toast.LENGTH_SHORT).show();
        }


        if (group.getCheckedRadioButtonId() != -1 && cm.getText().toString().length() != 0 && kgw.getText().toString().length() != 0) {
//        String cm1 = cm.getText().toString();
//        String kgw1 = kgw.getText().toString();
            figure.setText("");
            health.setText("");
            range.setText("");
            double cm1 = Double.parseDouble(cm.getText().toString());
            double kgw1 = Double.parseDouble(kgw.getText().toString());
//        double h = Math.pow(cm1/10,2);
            double h = cm1 / 100;
            double bmi = kgw1 / h / h;
//        double bmi1 = (double) (Math.round(bmi*1000));
            double bmi1 = Math.round(bmi * 10);
            double bmi2 = bmi1 / 10;
            Log.v("cody", "" + bmi2);
            figure.setText("" + bmi2);

            if (group.getCheckedRadioButtonId() == R.id.men) {
                if (bmi2 < 18.5) {
                    health.setText("男性,過輕");
                    range.setText("BMI<18.5");
                }
                else if (18.5 <= bmi2 && bmi2 < 24) {
                    health.setText("男性,正常");
                    range.setText("18.5<=BMI<24");
                }
                else if (24 <= bmi2 && bmi2 < 27) {
                    health.setText("男性,過重");
                    range.setText("24<=BMI<27");
                }
                else if (27 <= bmi2 && bmi2 < 30) {
                    health.setText("男性,輕度肥胖");
                    range.setText("27 <= BMI < 30");
                }
                else if (30 <= bmi2 && bmi2 < 35) {
                    health.setText("男性,中度肥胖");
                    range.setText("30 <= BMI < 35");
                }
                else if (35 <= bmi2) {
                    health.setText("男性,重度肥胖");
                    range.setText("35 <= BMI");
                }
            }else if (group.getCheckedRadioButtonId() == R.id.women) {
                    if (bmi2 < 18.5) {
                        health.setText("女性,過輕");
                        range.setText("BMI<18.5");
                    }
                    else if (18.5 <= bmi2 && bmi2 < 24) {
                        health.setText("女性,正常");
                        range.setText("18.5<=BMI<24");
                    }
                    else if (24 <= bmi2 && bmi2 < 27) {
                        health.setText("女性,過重");
                        range.setText("24<=BMI<27");
                    }
                    else if (27 <= bmi2 && bmi2 < 30) {
                        health.setText("女性,輕度肥胖");
                        range.setText("27 <= BMI < 30");
                    }
                    else if (30 <= bmi2 && bmi2 < 35) {
                        health.setText("女性,中度肥胖");
                        range.setText("30 <= BMI < 35");
                    }
                    else if (35 <= bmi2) {
                        health.setText("女性,重度肥胖");
                        range.setText("35 <= BMI");
                    }
                }
                group.clearCheck();
                cm.setText("");
                kgw.setText("");
        }
    }

    public void end(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("要離開嗎")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("no",null)
                .create();
        dialog.show();
    }
}