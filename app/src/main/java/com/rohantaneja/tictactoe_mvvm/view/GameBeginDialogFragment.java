package com.rohantaneja.tictactoe_mvvm.view;

import android.app.DialogFragment;

/**
 * Created by rohantaneja on 09/04/18.
 */

public class GameBeginDialogFragment extends DialogFragment {

    private MainActivity activity;

    public static GameBeginDialogFragment newInstance(MainActivity activity) {
        GameBeginDialogFragment dialogFragment = new GameBeginDialogFragment();
        dialogFragment.activity = activity;
        return dialogFragment;
    }

}
