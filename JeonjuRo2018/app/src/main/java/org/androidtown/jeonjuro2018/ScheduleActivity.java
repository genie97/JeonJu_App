package org.androidtown.jeonjuro2018;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hd.viewcapture.CaptureManager;
import com.hd.viewcapture.ViewCapture;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;


public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton bus_btn;
    ImageButton walk_btn;
    ImageButton share_btn;
    ImageButton camera_btn;

    TextView standard;
    private CaptureManager.OnSaveResultListener listener;
    ScrollView scroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        init();

        bus_btn.setOnClickListener(this);
        walk_btn.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        camera_btn.setOnClickListener(this);
    }

    public void init() {
        bus_btn = (ImageButton) findViewById(R.id.busBtn);
        walk_btn = (ImageButton) findViewById(R.id.walkBtn);
        share_btn = (ImageButton) findViewById(R.id.shareBtn);
        camera_btn = (ImageButton) findViewById(R.id.cameraBtn);

        standard = (TextView) findViewById(R.id.txt3);

        scroll = (ScrollView) findViewById(R.id.scheduleView);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.busBtn:
                Toast.makeText(this,"버스이용",Toast.LENGTH_SHORT).show();
                standard.setText("버스 기준");
                break;
            case R.id.walkBtn:
                Toast.makeText(this,"도보이용",Toast.LENGTH_SHORT).show();
                standard.setText("도보 기준");
                break;
            case R.id.shareBtn:
                shareKakao();
                Toast.makeText(this,"공유기능",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cameraBtn:
                questionCapture();
                break;

        }
    }

    //캡쳐하기전 다시 확인
    void questionCapture()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("일정 캡쳐하실래요?");
        builder.setMessage("확인을 누르시면 바로 캡쳐됩니다.");
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"일정캡쳐",Toast.LENGTH_SHORT).show();
                        ViewCapture.with(scroll).asJPG().setOnSaveResultListener(listener).save();
                    //scroll capture 기능
                    }
                });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //empty
            }
        });
        builder.show();
    }

    //카카오 공유기능
    public void shareKakao()
    {
        try{
            final KakaoLink kakaoLink = KakaoLink.getKakaoLink(this);
            final KakaoTalkLinkMessageBuilder KakaoBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

            KakaoBuilder.addText("카카오링크 테스트입니다");

            kakaoLink.sendMessage(KakaoBuilder,this);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

