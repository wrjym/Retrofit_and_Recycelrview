package com.yongmac.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Intro extends AppCompatActivity {

    private RecyclerView mBananaRecyclerView;
    private BananaAdapter mBananaAdapter;
    private List<MemberDTO> mBananaArray;
    private LinearLayoutManager mLayoutManager;
    RequestInterface requestInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mBananaRecyclerView = (RecyclerView) findViewById(R.id.main_recycview); //리사이클뷰 연결
        mBananaArray = new ArrayList<MemberDTO>(); // MemberDTO class를 ArrayList로 만들기 //추후에 Retrofit을 통한 값을 받기 위해서 생성


        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
        loadJSON();
        mBananaAdapter = new BananaAdapter(mBananaArray, getApplicationContext());
        mBananaRecyclerView.setAdapter(mBananaAdapter);
        mBananaRecyclerView.setLayoutManager(mLayoutManager);
        mBananaRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    //Retrofit 사용할때 쓰는 함수
    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-52-26-144-160.us-west-2.compute.amazonaws.com:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestInterface = retrofit.create(RequestInterface.class);
        Call<MebersList> call = requestInterface.getJSON(); //List 안에다 값 넣기
        call.enqueue(new Callback<MebersList>() {
            @Override
            public void onResponse(Call<MebersList> call, Response<MebersList> response) {
                if (response.isSuccess()) {
                    List<MemberDTO> memberDTOs = response.body().getMemberDTOs(); //리스트에 사이트에 있는 값 받아오기
                    mBananaRecyclerView.setAdapter(new BananaAdapter(memberDTOs, getApplicationContext())); //어뎁터에 값 삽입
                }
            }

            @Override
            public void onFailure(Call<MebersList> call, Throwable t) {
//실행되지 않을때
            }
        });
    }


    //interface 값 Get방식
    public interface RequestInterface {
        @GET("/ordinary")
        Call<MebersList> getJSON();
    }

}

