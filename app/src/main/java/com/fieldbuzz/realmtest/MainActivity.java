package com.fieldbuzz.realmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private RealmConfiguration config;
    private Realm realm;
    String view;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.txt);
        config=new RealmConfiguration.Builder(getApplication()).deleteRealmIfMigrationNeeded().build();
        realm=Realm.getDefaultInstance();

        basicCRUD(realm);

        RealmResults<Books> book=realm.where(Books.class).equalTo("title", "New").findAll();
        tv.setId(R.id.txt);
    }

    private void basicCRUD(Realm realm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Books books= realm.createObject(Books.class);
                books.setId(1);
                books.setTitle("New Book");

            }
        });
    }
}
