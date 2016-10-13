package com.wolfhackers.counsellink.model;

import android.annotation.SuppressLint;

import com.alamkanak.weekview.WeekViewEvent;
import com.orm.SugarRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * An event model that was built for automatic serialization from json to object.
 * Created by Raquib-ul-Alam Kanak on 1/3/16.
 * Website: http://alamkanak.github.io
 */
public class CalendarEvent extends SugarRecord {

    private String mColor;

    private String subject;

    private String startDate;

    private String endDate;

    private int remindBefore;

    private String dueDate;

    private String type;

    private String priority;

    private String status;

    private String assignee;

    private String relatedMatterId;

    // You must provide an empty constructor
    public CalendarEvent() {}

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        this.mColor = color;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRemindBefore() {
        return remindBefore;
    }

    public void setRemindBefore(int remindBefore) {
        this.remindBefore = remindBefore;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getRelatedMatterId() {
        return relatedMatterId;
    }

    public void setRelatedMatterId(String relatedMatterId) {
        this.relatedMatterId = relatedMatterId;
    }

    @SuppressLint("SimpleDateFormat")
    public WeekViewEvent toWeekViewEvent(){

        WeekViewEvent weekViewEvent=null;
        try {

            weekViewEvent = new WeekViewEvent();
            // Parse time.
            Calendar startTime = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MM dd HH:mm", Locale.ENGLISH);
            startTime.setTime(sdf.parse(getStartDate()));// all done

            weekViewEvent.setStartTime(startTime);

//            if(getEndDate()!=null)
//            {
//                // Parse End Time
//                Calendar endTime = Calendar.getInstance();
//                weekViewEvent = new WeekViewEvent();
//                endTime.setTime(sdf.parse(getEndDate()));// all done
//            }
//            else
            weekViewEvent.setAllDay(true);

            weekViewEvent.setName(getSubject());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return weekViewEvent;
    }
}
