package com.example.jenis_000.practical4;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditNameDialog extends DialogFragment implements TextView.OnEditorActionListener {
        public EditText seriesname;

    public EditNameDialog(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_edit_name_dialog,container);
        seriesname = (EditText)view.findViewById(R.id.edit_series_text);
        getDialog().setTitle(" Add Series Name");

        seriesname.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        seriesname.setOnEditorActionListener(this);

        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(EditorInfo.IME_ACTION_DONE==actionId)
        {
            EditNameDialogListener activity =(EditNameDialogListener) getActivity();
            activity.onFinishEditDialog(seriesname.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }

}
