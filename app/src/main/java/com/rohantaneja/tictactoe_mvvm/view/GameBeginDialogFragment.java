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

import com.rohantaneja.tictactoe_mvvm.R;

/**
 * Created by rohantaneja on 09/04/18.
 */

public class GameBeginDialogFragment extends DialogFragment {

    private LinearLayout rootView;
    private MainActivity activity;

    private TextInputLayout player1TextInputLayout;
    private TextInputLayout player2TextInputLayout;

    private TextInputEditText player1NameEditText;
    private TextInputEditText player2NameEditText;

    String player1Name;
    String player2Name;

    public static GameBeginDialogFragment newInstance(MainActivity activity) {
        GameBeginDialogFragment dialogFragment = new GameBeginDialogFragment();
        dialogFragment.activity = activity;
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        initViews();

        final AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setView(rootView)
                .setTitle("Enter player names")
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
        rootView = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.game_begin_dialog, rootView);

        player1TextInputLayout = rootView.findViewById(R.id.player_1_text_input_layout);
        player2TextInputLayout = rootView.findViewById(R.id.player_2_text_input_layout);

        player1NameEditText = rootView.findViewById(R.id.player_1_name_edit_text);
        player2NameEditText = rootView.findViewById(R.id.player_2_name_edit_text);

        addTextWatchers();
    }

    private void onDialogShow(AlertDialog alertDialog) {
        Button dialogDoneButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        dialogDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDoneClicked();
            }
        });
    }

    private void onDoneClicked() {

        if (isValidPlayerName(player1TextInputLayout, player1Name) && isValidPlayerName(player2TextInputLayout, player2Name)) {
            activity.onPlayersSet(player1Name, player2Name);
            dismiss();
        }
    }

    private boolean isValidPlayerName(TextInputLayout textInputLayout, String playerName) {

        if (TextUtils.isEmpty(playerName)) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("Player name cannot be empty");
            return false;
        }

        if (player1Name.equalsIgnoreCase(player2Name)) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("Player names cannot be same");
            return false;
        }

        textInputLayout.setErrorEnabled(false);
        textInputLayout.setError("");
        return true;
    }

    private void addTextWatchers() {

        player1NameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                player1Name = editable.toString();
            }
        });

        player2NameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                player2Name = editable.toString();
            }
        });

    }

}

