package example.com.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by softbunch on 6/18/16.
 */
public class SingleFortDetails extends AppCompatActivity {

    ImageView imgFort, imgBack;
    TextView txtIntroduction, txtHistory, txtHeading, txt_history_name;
    int fort_Image = 0;
    String fort_Name = "";
    String fort_Introduction = "";
    String fort_History = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_details);

        txtIntroduction = (TextView) findViewById(R.id.txt_introduction);
        txtHistory = (TextView) findViewById(R.id.txt_history);
        txt_history_name = (TextView) findViewById(R.id.txt_history_name);
        txtHeading = (TextView) findViewById(R.id.txt_heading);
        imgFort = (ImageView) findViewById(R.id.img_fort);
        imgBack = (ImageView) findViewById(R.id.img_back);

        try {
            Bundle bundle = this.getIntent().getExtras();
            fort_Image = bundle.getInt("FORTIMAGE");
            fort_Name = bundle.getString("FORTNAME");
            fort_Introduction = bundle.getString("FORTINTRO");
            fort_History = bundle.getString("FORTHIST");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            txtHeading.setText(fort_Name);
            txtIntroduction.setText(fort_Introduction);
            imgFort.setImageResource(fort_Image);

            if (fort_History.equals("") || fort_History.equals("null")) {
                txt_history_name.setVisibility(View.GONE);
            } else {
                txt_history_name.setVisibility(View.VISIBLE);
                txtHistory.setText(fort_History);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        finishAfterTransition();
                    } else {
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
