package com.meyourours.cito.formula;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meyourours.cito.R;
import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HPHT2Fragment extends FormulaFragment implements View.OnClickListener {

    private DatePickerDialog.Builder builder;
    private TextView datePicker, dateHpht, resultText;

    public HPHT2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hpht, container, false);

        datePicker = (TextView) rootView.findViewById(R.id.date_picker);
        dateHpht = (TextView) rootView.findViewById(R.id.text_hpht);
        resultText = (TextView) rootView.findViewById(R.id.text_result);

        builder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light){
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                DatePickerDialog dialog = (DatePickerDialog)fragment.getDialog();
                String date = dialog.getFormattedDate(SimpleDateFormat.getDateInstance());
                datePicker.setText(date);
                Calendar calc = dialog.getCalendar();
                calc.add(Calendar.DATE, 7);
                calc.add(Calendar.MONTH, 9);
                SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy");
                dateHpht.setText(format.format(calc));
                super.onPositiveActionClicked(fragment);
            }

        };

        builder.positiveAction("OK")
                .negativeAction("CANCEL");

        datePicker.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.date_picker:
                DialogFragment fragment = DialogFragment.newInstance(builder);
                fragment.show(getFragmentManager(), null);
                break;
        }
    }
}
