package com.rohantaneja.tictactoe_mvvm.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.rohantaneja.tictactoe_mvvm.R;

/**
 * Created by rohantaneja on 09/04/18.
 */

public class GameBeginDialogFragment extends DialogFragment {

    private LinearLayout rootView;
    private MainActivity activity;

    private TextInputEditText player1NameEditText;
    private TextInputEditText player2NameEditText;

    public static GameBeginDialogFragment newInstance(MainActivity activity) {
        GameBeginDialogFragment dialogFragment = new GameBeginDialogFragment();
        dialogFragment.activity = activity;
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        rootView = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.game_begin_dialog, rootView);
        player1NameEditText = rootView.findViewById(R.id.player_1_name_edit_text);
        player2NameEditText = rootView.findViewById(R.id.player_2_name_edit_text);

        final AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setView(rootView)
                .setTitle("Enter player names")
                .setCancelable(false)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onDoneClicked();
                    }
                })
                .create();

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                onDialogShow(alertDialog);
            }
        });

        return alertDialog;
    }

    private void onDialogShow(AlertDialog alertDialog) {
    }

    private void onDoneClicked() {
    }
}
