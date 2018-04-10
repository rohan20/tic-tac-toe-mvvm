package com.rohantaneja.tictactoe_mvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rohantaneja.tictactoe_mvvm.R;
import com.rohantaneja.tictactoe_mvvm.databinding.ActivityMainBinding;
import com.rohantaneja.tictactoe_mvvm.viewmodel.GameViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private static final String GAME_BEGIN_DIALOG_TAG = "game_begin_dialog_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        promptForPlayers();
    }

    private void promptForPlayers() {
        GameBeginDialogFragment gameBeginDialogFragment = GameBeginDialogFragment.newInstance(this);
        gameBeginDialogFragment.show(getFragmentManager(), GAME_BEGIN_DIALOG_TAG);
    }

    public void onPlayersSet(String player1Name, String player2Name) {
        initDataBinding(player1Name, player2Name);
    }

    private void initDataBinding(String player1Name, String player2Name) {
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        GameViewModel gameViewModel = new GameViewModel(player1Name, player2Name);
        mainBinding.setGameViewModel(gameViewModel);
        gameViewModel.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object winnerName) {

    }

}
