package com.example.retrofitwe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUserId;
    private Button mBtnCallApi;
    private TextView mTvFirstName;
    private TextView mTvLastName;
    private ImageView mIvAvatar;
    private TextView mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnCallApi=findViewById(R.id.btnCallApi);
        mIvAvatar=findViewById(R.id.ivAvatar);
        mTvFirstName=findViewById(R.id.tvfirstName);
        mTvLastName=findViewById(R.id.tvLastName);
        mTvEmail=findViewById(R.id.tvEmail);
        mEtUserId=findViewById(R.id.etUserId);

        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           AppService appService      =Network.getInstance().create(AppService.class);
int userId= Integer.parseInt(mEtUserId.getText().toString());
appService.getUser(userId).enqueue(new Callback<ResponseModel>() {
    @Override

    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
ResponseModel model=response.body();
String firstName =model.getData().getFirstName();
String lastName= model.getData().getLastName();
String email= model.getData().getEmail();
mTvFirstName.setText(firstName);
mTvLastName.setText(lastName);
mTvEmail.setText(email);
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {

    }
});
            }
        });

    }
}