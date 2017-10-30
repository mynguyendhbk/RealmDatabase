package edu.nguyenmy.realmdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm mRealm;
    private People mPeople;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       setData();

    }
    public void setData(){
        mRealm = Realm.getInstance(this);
        mRealm.beginTransaction();
        //tao doi tuong
        mPeople = mRealm.createObject(People.class);
        mPeople.setName("nguyen van a");
        mPeople.setAge(23);
        mRealm.commitTransaction();
    }
    public void query(View view){
        RealmResults<People> results = mRealm.where(People.class).findAll();
        for(People p: results) {
            Log.d("results: ", p.getName() + " " + p.getAge());
        }

    }
}
