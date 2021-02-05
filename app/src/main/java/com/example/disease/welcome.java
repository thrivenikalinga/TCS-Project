package com.example.disease;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


class welcome extends Activity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        Button b=(Button)this.findViewById(R.id.click_btn);
        b.setOnClickListener(this);

    }
    public void onClick(View v){
        TextView resp=(TextView)this.findViewById(R.id.response);
        EditText name=(EditText)this.findViewById(R.id.user_name);
        String str="welcome" + name.getText().toString() + "  ";
        resp.setText(str);


    }
}