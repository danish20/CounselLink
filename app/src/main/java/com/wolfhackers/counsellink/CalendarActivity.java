package com.wolfhackers.counsellink;

import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
import com.wolfhackers.counsellink.model.CalendarEvent;
import com.wolfhackers.counsellink.R;
import com.wolfhackers.counsellink.model.CalendarEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Omkar on 10/10/2016.
 */
public class CalendarActivity extends BaseCalendarActivity {

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        CalendarEvent.deleteAll(CalendarEvent.class);
        Iterator<CalendarEvent> iterator = CalendarEvent.findAll(CalendarEvent.class);
        CalendarEvent calEvent=null;
        int i = 0;
        while(iterator.hasNext())
        {
            i++;
            calEvent = iterator.next();
            if(calEvent!=null)
            {
                WeekViewEvent event = calEvent.toWeekViewEvent();
                if(event!=null)
                {
                    switch(i)
                    {
                        case 1 : event.setColor(getResources().getColor(R.color.event_color_01));
                                break;
                        case 2: event.setColor(getResources().getColor(R.color.event_color_02));
                                break;
                        case 3: event.setColor(getResources().getColor(R.color.event_color_03));
                                break;
                        case 4: event.setColor(getResources().getColor(R.color.event_color_04));
                                break;
                        default: event.setColor(getResources().getColor(R.color.event_color_01));
                    }
                    Calendar startTime = event.getStartTime();
//                    startTime.set(Calendar.DAY_OF_MONTH, 14);
                    startTime.set(Calendar.HOUR_OF_DAY, 3);
                    startTime.set(Calendar.MINUTE, 0);
                    startTime.set(Calendar.MONTH, newMonth-1);
                    startTime.set(Calendar.YEAR, newYear);
                    Calendar endTime = (Calendar) startTime.clone();
                    endTime.add(Calendar.HOUR_OF_DAY, 5);
                    event.setStartTime(startTime);
                    event.setEndTime(endTime);
                    event.setLocation(null);
//                    event.setId(15);
//                    WeekViewEvent event1 = new WeekViewEvent(7, event.getName(),null, startTime, endTime, true);
                    events.add(event);
                }
            }
        }

        Calendar startTime = Calendar.getInstance();
//        startTime.set(Calendar.HOUR_OF_DAY, 3);
//        startTime.set(Calendar.MINUTE, 0);
//        startTime.set(Calendar.MONTH, newMonth-1);
//        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
//        endTime.add(Calendar.HOUR, 1);
//        endTime.set(Calendar.MONTH, newMonth-1);
        WeekViewEvent event = new WeekViewEvent(1, getEventTitle(startTime), startTime, endTime);
//        event.setColor(getResources().getColor(R.color.event_color_01));
//        events.add(event);
//
        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(10, "Preliminary Hearing - Joe Smith vs Dr. Bob Kelso", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);
//
//        startTime = Calendar.getInstance();
//        startTime.set(Calendar.HOUR_OF_DAY, 4);
//        startTime.set(Calendar.MINUTE, 20);
//        startTime.set(Calendar.MONTH, newMonth-1);
//        startTime.set(Calendar.YEAR, newYear);
//        endTime = (Calendar) startTime.clone();
//        endTime.set(Calendar.HOUR_OF_DAY, 5);
//        endTime.set(Calendar.MINUTE, 0);
//        event = new WeekViewEvent(10, "Send Temporary Invoice", startTime, endTime);
//        event.setColor(getResources().getColor(R.color.event_color_03));
//        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(2, "Send Final Invoice - Hilary Clinton", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);
//
//        startTime = Calendar.getInstance();
//        startTime.set(Calendar.HOUR_OF_DAY, 5);
//        startTime.set(Calendar.MINUTE, 0);
//        startTime.set(Calendar.MONTH, newMonth-1);
//        startTime.set(Calendar.YEAR, newYear);
//        startTime.add(Calendar.DATE, 1);
//        endTime = (Calendar) startTime.clone();
//        endTime.add(Calendar.HOUR_OF_DAY, 3);
//        endTime.set(Calendar.MONTH, newMonth - 1);
//        event = new WeekViewEvent(3, "Post Hearing Meet", startTime, endTime);
//        event.setColor(getResources().getColor(R.color.event_color_03));
//        events.add(event);
//
        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 16);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(4, "Client Feedback Meeting - Homer Simpson", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 12);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(7, "Discovery Deadline - Homer Simpson",null, startTime, endTime, true);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, "Meet with Counsel - Donald Trump", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        return events;
    }

    private void showCalendar(CalendarEvent calEvent) {
        Toast.makeText(this, "Event: "+calEvent.getSubject()+", time : "+calEvent.getStartDate(), Toast.LENGTH_SHORT).show();
    }

}
