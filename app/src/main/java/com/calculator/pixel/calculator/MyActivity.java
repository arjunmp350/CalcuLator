package com.calculator.pixel.calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {

    private EditText Src;
    private float numbBr;
    private String operation;
    private ButtonClickListener btnclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Src = (EditText) findViewById(R.id.txtnum_inp);
        Src.setEnabled(false);

        int idList[] = {R.id.btn_no_0,R.id.btn_no_1,R.id.btn_no_2,R.id.btn_no_3,R.id.btn_no_4,R.id.btn_no_5,R.id.btn_no_6,R.id.btn_no_7,R.id.btn_no_8,
        R.id.btn_no_9,R.id.btn_sym_div,R.id.btn_sym_dot,R.id.btn_sym_eq,R.id.btn_sym_min,R.id.btn_sym_multi,R.id.btn_sym_plus,R.id.btn_clr,R.id.txtnum_inp};

        for (int id:idList) {
            View v = findViewById(id);
            v.setOnClickListener(btnclick);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }


    public void mMath(String str){
        numbBr =Float.parseFloat(Src.getText().toString());
        operation = str;
        Src.setText("0");
    }

    public  void getKeyboard(String str){
        String SrcCurrent = Src.getText().toString();
        if (SrcCurrent.equals("0"))
            SrcCurrent = " ";
        SrcCurrent += str;
        Src.setText(SrcCurrent);
    }

    public void mResult(){
        float numbAf = Float.parseFloat(Src.getText().toString());
        float result = 0 ;

        if(operation.equals("+")) {
            result = numbAf + numbBr;
        }
        if (operation.equals("-")) {
            result = numbBr - numbAf;
        }
        if (operation.equals("*")) {
            result = numbAf * numbBr;
        }
        if (operation.equals("/")) {
            result = numbBr / numbAf;
        }
        Src.setText(String.valueOf(result));

        }

    private class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_clr:
                    Src.setText("0");
                    numbBr = 0;
                    operation = "";
                    break;
                case R.id.btn_sym_plus:
                    mMath("+");
                    break;
                case R.id.btn_sym_min:
                    mMath("-");
                    break;
                case R.id.btn_sym_multi:
                    mMath("*");
                    break;
                case R.id.btn_sym_div:
                    mMath("/");
                    break;
                case R.id.btn_sym_eq:
                    mResult();
                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyboard(numb);
                    break;


            }
        }
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
