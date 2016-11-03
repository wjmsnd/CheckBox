package com.example.lee_pc.checkbox;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Button allcheck;
    private Button hide;
    private Button fanxuan;
    private ListViewAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        allcheck = (Button) findViewById(R.id.allcheck);
        hide = (Button) findViewById(R.id.hide);
        fanxuan = (Button) findViewById(R.id.fanxuan);

        adapter = new ListViewAdapter(this);

        lv.setAdapter(adapter);

        allcheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                boolean flag = true;

                for (int i = 0; i < adapter.getSelect().size(); i++) {
                    adapter.getSelect().set(i, flag);

                }
                adapter.notifyDataSetChanged();
            }
        });


        fanxuan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!adapter.getSelect().contains(true)) {

                } else {
                    for (int i = 0; i < adapter.getSelect().size(); i++) {
                        if (adapter.getSelect().get(i)) {
                            adapter.getSelect().set(i, false);
                        } else {
                            adapter.getSelect().set(i, true);
                        }
                    }

                    adapter.notifyDataSetChanged();
                }

            }
        });
    }


}
