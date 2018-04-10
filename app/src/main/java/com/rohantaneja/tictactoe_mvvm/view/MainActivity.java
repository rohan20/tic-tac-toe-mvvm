package com.rohantaneja.tictactoe_mvvm.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rohantaneja.tictactoe_mvvm.R;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void update(Observable observable, Object winnerName) {

    }

    public void onPlayersSet(String player1Name, String player2Name) {
        Toast.makeText(this, "Player 1: " + player1Name + "\nPlayer 2:" + player2Name, Toast.LENGTH_SHORT).show();
    }
}
