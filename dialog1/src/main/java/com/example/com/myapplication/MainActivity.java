package com.example.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etName, etEmail,dlgEdtName,dlgEdtEmail;
    Button button1;
    TextView toastText;
    View dialogView, toastView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력(수정)");

        etName = (EditText)findViewById(R.id.dlgEdt1);
        etEmail = (EditText)findViewById(R.id.dlgEdt2);
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);


                dlgEdtName = (EditText) dialogView.findViewById(R.id.edit1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.edit2);

                dlgEdtName.setText(etName.getText().toString());
                dlgEdtEmail.setText(etEmail.getText().toString());



                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.smile);
                dlg.setView(dialogView);


                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //dlgEdtName = (EditText) dialogView.findViewById(R.id.edit1);
                               // dlgEdtEmail = (EditText) dialogView.findViewById(R.id.edit2);

                                etName.setText(dlgEdtName.getText().toString());
                                etEmail.setText(dlgEdtEmail.getText().toString());
                            }
                        });


                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = new Toast(MainActivity.this);
                                toastView = (View) View.inflate(MainActivity.this, R.layout.toast, null);
                                toastText = (TextView) toastView.findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다.");

                                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                                int xOffset = (int) (Math.random() * display.getWidth());
                                int yOffset = (int) (Math.random() * display.getHeight());

                                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                                toast.setView(toastView);
                                toast.show();


                            }
                        }


                );

                dlg.show();






            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
