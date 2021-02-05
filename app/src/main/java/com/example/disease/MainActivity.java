package com.example.disease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.JetPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    Button btn;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView electrocardiogram,asthma,respiration,oxygenValue,bodytemperature,glucose,cough,refresh;
    List data,dataList;
    HashMap map;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn = findViewById( R.id.refresh );
        respiration = findViewById( R.id.respiration );
        oxygenValue = findViewById( R.id.oxygenValue);
        glucose=findViewById(R.id.glucose);
        bodytemperature=findViewById( R.id.bodytemperature);
        electrocardiogram=findViewById( R.id.electrocardiogram );
        asthma=findViewById( R.id.asthma );

        getData();
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        } );
    }



    void getData(){

        DocumentReference docRef=db.collection("dhani").document("w1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isComplete()) {
                    try{
                        DocumentSnapshot data=task.getResult();
                        HashMap<String,String> da= (HashMap)data.getData();
//                        listSize=dataList.size()-1;
                        Toast.makeText(MainActivity.this,"Refreshed", Toast.LENGTH_SHORT).show();
                        SystemClock.sleep(50);
                        respiration.setText(da.get("respiration").toString());
                        oxygenValue.setText( da.get( "O" ).toString() );
                        glucose.setText( da.get( "gucose" ).toString() );
                        bodytemperature.setText( da.get("bodytemperature").toString());
                        electrocardiogram.setText( da.get("electrocardiogram").toString());
                        asthma.setText( da.get("asthma").toString());



                    }catch (Exception e){
//                        Toast.makeText(MainActivity.this, "No user Found With This ID", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


}
