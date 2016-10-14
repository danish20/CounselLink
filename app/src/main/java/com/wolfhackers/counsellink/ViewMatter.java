package com.wolfhackers.counsellink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.wolfhackers.counsellink.R;

import java.util.ArrayList;

public class ViewMatter extends AppCompatActivity {

    Boolean expandedEvents = false;
    Boolean notesExpanded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_matter);
        ImageView add_note = (ImageView)findViewById(R.id.add_note);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddNote.class));
            }
        });

        findViewById(R.id.btnExpandEvents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandedEvents == false)
                {
                    findViewById(R.id.linearEvents1).setVisibility(View.VISIBLE);
                    findViewById(R.id.linearEvents2).setVisibility(View.VISIBLE);
                    findViewById(R.id.linearEvents3).setVisibility(View.VISIBLE);
                    expandedEvents = true;
                    final ScrollView view  = (ScrollView) findViewById(R.id.scrollView);
                    view.post(new Runnable() {
                        @Override
                        public void run() {
                            view.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    ImageView iv = (ImageView) findViewById(R.id.btnExpandEvents);
                    iv.setImageResource(R.drawable.ic_expand_less_black_24dp);
                }
                else
                {
                    findViewById(R.id.linearEvents1).setVisibility(View.GONE);
                    findViewById(R.id.linearEvents2).setVisibility(View.GONE);
                    findViewById(R.id.linearEvents3).setVisibility(View.GONE);
                    expandedEvents = false;
                    ImageView iv = (ImageView) findViewById(R.id.btnExpandEvents);
                    iv.setImageResource(R.drawable.ic_expand_more_black_24dp);
                }
            }
        });

        findViewById(R.id.btnExpandNotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notesExpanded == false)
                {
                    findViewById(R.id.linearNotes1).setVisibility(View.VISIBLE);
                    findViewById(R.id.linearNotes2).setVisibility(View.VISIBLE);
                    findViewById(R.id.linearNotes3).setVisibility(View.VISIBLE);
                    final ScrollView view  = (ScrollView) findViewById(R.id.scrollView);
                    view.post(new Runnable() {
                        @Override
                        public void run() {
                            view.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    notesExpanded = true;
                    ImageView iv = (ImageView) findViewById(R.id.btnExpandNotes);
                    iv.setImageResource(R.drawable.ic_expand_less_black_24dp);
                }

                else
                {
                    findViewById(R.id.linearNotes1).setVisibility(View.GONE);
                    findViewById(R.id.linearNotes2).setVisibility(View.GONE);
                    findViewById(R.id.linearNotes3).setVisibility(View.GONE);
                    notesExpanded = false;
                    ImageView iv = (ImageView) findViewById(R.id.btnExpandNotes);
                    iv.setImageResource(R.drawable.ic_expand_more_black_24dp);
                }
            }
        });

    }

}
