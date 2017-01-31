package assignment.android.acadgild.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    Button btnShow;
    Button btnCheck;
    String data="Apple";
    String filename="Data";
    TextView tvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck=(Button)findViewById(R.id.btnCheck);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnShow=(Button)findViewById(R.id.btnShow);
        tvdata=(TextView)findViewById(R.id.txtViewData) ;
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = getApplicationContext().getFilesDir().getAbsolutePath() + "/" + filename;
                File file = new File(path);



                if ( file.exists() )
                {
                    Toast.makeText(MainActivity.this,"File exists",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"File does not exist",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(filename);//Opens a file having the filename and returns instance of FIleInputStream
                    int c;
                    String temp="";
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    tvdata.setText(temp);
                    Toast.makeText(getBaseContext(),"File read successfully",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fOut = openFileOutput(filename,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"File saved successfully",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });

    }
}
