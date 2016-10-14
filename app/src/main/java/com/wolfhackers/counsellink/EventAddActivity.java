package com.wolfhackers.counsellink;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wolfhackers.counsellink.R;
import com.wolfhackers.counsellink.model.CalendarEvent;

import java.util.Calendar;

/**
 * Created by Omkar on 10/10/2016.
 */
public class EventAddActivity extends AppCompatActivity implements com.borax12.materialdaterangepicker.date.DatePickerDialog.OnDateSetListener{

    EditText editEventName;
    EditText editRemindBefore;
    String selectedStartDate;
    String selectedEndDate;
    String selectedDueDate;
    BetterSpinner spinEventType;
    BetterSpinner spinEventStatus;
    BetterSpinner spinEventPriority;
    BetterSpinner spinMatterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        editEventName = (EditText) findViewById(R.id.editEventName);

        editRemindBefore = (EditText) findViewById(R.id.editRemindBefore);

        spinEventType = (BetterSpinner) findViewById(R.id.spinEventType);

        spinMatterName = (BetterSpinner) findViewById(R.id.spinEventMatterName);

        {
            String[] list = getResources().getStringArray(R.array.event_types);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, list);

            spinEventType.setAdapter(adapter);
        }

        {
            String[] list = getResources().getStringArray(R.array.matters);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, list);

            spinMatterName.setAdapter(adapter);
        }

        spinEventStatus = (BetterSpinner) findViewById(R.id.spinEventStatus);

        {
            String[] list = getResources().getStringArray(R.array.event_status);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, list);

            spinEventStatus.setAdapter(adapter);
        }

        spinEventPriority = (BetterSpinner) findViewById(R.id.spinEventPriority);

        {
            String[] list = getResources().getStringArray(R.array.event_priority);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, list);

            spinEventPriority.setAdapter(adapter);
        }

        spinMatterName = (BetterSpinner) findViewById(R.id.spinEventMatterName);

        findViewById(R.id.btnStartDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                com.borax12.materialdaterangepicker.date.DatePickerDialog dpd = com.borax12.materialdaterangepicker.date.DatePickerDialog.newInstance(
                        EventAddActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "DatePickerRangedialog");

            }
        });

        findViewById(R.id.btnDueDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Calendar now = Calendar.getInstance();
//                com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
//                        EventAddActivity.this,
//                        now.get(Calendar.YEAR),
//                        now.get(Calendar.MONTH),
//                        now.get(Calendar.DAY_OF_MONTH)
//                );
//                dpd.show(getFragmentManager(), "DatePickerWdullaerDialog");
                showDialog(999);
            }
        });

        findViewById(R.id.btnCreateEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
//        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
//                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            Calendar now = Calendar.getInstance();
            return new DatePickerDialog(this, R.style.DialogTheme, myDateListener, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            int year = arg1;
            int month = arg2+1;
            int day = arg3;
//            String monthString = new DateFormatSymbols().getMonths()[month];
            StringBuilder date = new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year);
//            Toast.makeText(EventAddActivity.this, "Date Selected: "+date.toString(), Toast.LENGTH_SHORT).show();
        }
    };

    private void addEvent() {

        //TODO validation
        CalendarEvent event = new CalendarEvent();

        String eventName = editEventName.getText().toString();

//        String remindBeforeText = editRemindBefore.getText().toString();
//        int remindBefore = Integer.parseInt(remindBeforeText);
//
//        String type = spinEventType.getText().toString();
//
//        String priority = spinEventPriority.getText().toString();
//
//        String status = spinEventStatus.getText().toString();
//
//        String assignee = spinEventAssignee.getText().toString();
//
//        String matterName = spinMatterName.getText().toString();

        event.setSubject(eventName);

//        event.setAssignee(assignee);
//
//        event.setType(type);
//
//        event.setRemindBefore(remindBefore);
//
//        event.setPriority(priority);

        event.setStartDate(selectedStartDate);

        event.setEndDate(selectedEndDate);

        event.setDueDate(selectedDueDate);

//        event.setStatus(status);

        event.save();

        Toast.makeText(this, "Event : "+eventName+" added successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(EventAddActivity.this, CalendarActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDateSet(com.borax12.materialdaterangepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth,int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
//        String date = "You picked the following date: From- "+dayOfMonth+"/"+(++monthOfYear)+"/"+year+" To "+dayOfMonthEnd+"/"+(++monthOfYearEnd)+"/"+yearEnd;
//        String monthOfYearString = new DateFormatSymbols().getMonths()[monthOfYear];
//        String monthOfYearEndString = new DateFormatSymbols().getMonths()[monthOfYearEnd];
        selectedStartDate = monthOfYear+" "+dayOfMonth+" "+"12:00";
        selectedEndDate = monthOfYearEnd+" "+dayOfMonthEnd+" "+"12:00";
//        Toast.makeText(this, "Date Selected: "+selectedStartDate+" End Date: "+selectedEndDate, Toast.LENGTH_SHORT).show();
    }

}
