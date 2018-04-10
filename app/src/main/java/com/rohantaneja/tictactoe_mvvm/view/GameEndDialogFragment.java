package com.rohantaneja.tictactoe_mvvm.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rohantaneja.tictactoe_mvvm.R;

/**
 * Created by rohantaneja on 09/04/18.
 */

public class GameEndDialogFragment extends DialogFragment {

    private LinearLayout rootView;
    private MainActivity activity;

    String winnerName;

    public static GameEndDialogFragment newInstance(MainActivity activity, String winnerName) {
        GameEndDialogFragment dialogFragment = new GameEndDialogFragment();
        dialogFragment.activity = activity;
        dialogFragment.winnerName = winnerName;
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        initViews();

        final AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setView(rootView)
                .setCancelable(false)
                .setPositiveButton("Done", null)
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

    private void initViews() {
        rootView = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.game_end_dialog, rootView);
        ((TextView) rootView.findViewById(R.id.winner_text_view)).setText(winnerName);
    }

    private void onDialogShow(AlertDialog alertDialog) {
        Button dialogDoneButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        dialogDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewGame();
            }
        });
    }

    private void onNewGame() {
        dismiss();
        activity.promptForPlayers();
    }

}

