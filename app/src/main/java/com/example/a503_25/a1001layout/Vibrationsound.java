package com.example.a503_25.a1001layout;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Vibrationsound extends AppCompatActivity {

    Button btnsound1,btnsound2,btnsound3,btntoast,basicalert, btnasynk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrationsound);

        //버튼 찾아오기
        btnsound1 = (Button)findViewById(R.id.btnvibrate);
        btnsound2 = (Button)findViewById(R.id.btnsystem);
        btnsound3 = (Button)findViewById(R.id.btnusersound);
        btntoast = (Button)findViewById(R.id.btntoast);
        basicalert = (Button)findViewById(R.id.btnbasicalert);
        btnasynk = (Button)findViewById(R.id.btnasync);

        TextView tv = (TextView)findViewById(R.id.txt);
        try{
            for(int i=0; i<10; i=i+1){
                tv.setText("" + i);
                Thread.sleep(2000);
            }
        }catch(Exception e){}






        btnasynk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //대화상자 출력
                new AlertDialog.Builder(Vibrationsound.this)
                        .setMessage("엑티비티 종료").setTitle("대화상자").setIcon(R.drawable.icon).setPositiveButton("프로그램 종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();

                //토스트 출력
                Toast.makeText(Vibrationsound.this,"토스트 출력",Toast.LENGTH_SHORT).show();

                //액티비티 종료
                //finish();
            }
        });

        btnsound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //진동 만들기 - 1초동안 진동
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(3000);
            }
        });

        btnsound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),notification);
                ringtone.play();
            }
        });
        btnsound3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(Vibrationsound.this, R.raw.soccer);
                player.start();
            }
        });
        btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Vibrationsound.this,"반갑다",Toast.LENGTH_SHORT).show();

            }
        });
        basicalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메소드 체이닝을 이용한 생성과 출력
                new AlertDialog.Builder(Vibrationsound.this).setMessage("대화상자").setTitle("대화상자").setIcon(R.drawable.icon).setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Vibrationsound.this,"긍정입니다.",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("부정",null).setNeutralButton("중립",null)
                        .setCancelable(false).show();
            }
        });

    }
}
