package org.esiea.kidjo_caron_chebbi.pronobet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RV = (RecyclerView)findViewById(R.id.RV);
        assert RV != null;
        RV.setHasFixedSize(true);
        LinearLayoutManager mLinearManager = new LinearLayoutManager(this);
        RV.setLayoutManager(mLinearManager);

        ArrayList<Bet> betlist = Data();
        BetAdapter adapter = new BetAdapter(this, betlist);

        RV.setAdapter(adapter);
        RV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WinIntent = new Intent(MainActivity.this, Winner.class);
            }
        });


    }

    private ArrayList<Bet> Data() {
        ArrayList<Bet> test = new ArrayList<>();
        for(int i =0; i< 25; i++){
            Bet bet = new Bet();
            if (i % 2 == 0) {
            bet.teams=i + "  PSG - OM";
            bet.odds ="1: 1,25 - N: 3,40 - 2: 9,20";
        }
            else {
                bet.teams=i + "  PSG - Nice";
                bet.odds ="1: 1,90 - N: 2,80 - 2: 3,20";
            }
            test.add(bet);
        }
        return test;
    }

}
