package com.wolfhackers.counsellink;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wolfhackers.counsellink.R;

import java.util.ArrayList;

public class MattersHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView list;
    boolean flag=false;

    ArrayList<Matter> matters=new ArrayList<>();
    ArrayList<Matter> temp=new ArrayList<>();
    LinearLayout home_button,matters_button,calendar_button,add_matters_button;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        SearchManager searchManager = (SearchManager)getApplicationContext().getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
        }
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                Intent in=new Intent(getApplicationContext(),Matters.class);
                in.putExtra("add",false);
                startActivity(in);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            startActivity(new Intent(getApplicationContext(),Home.class));

        } else if (id == R.id.nav_add_matter) {

            startActivity(new Intent(getApplicationContext(),AddMatter.class));

        } else if (id == R.id.nav_view_matters) {

        } else if (id == R.id.nav_create_event) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if(id==R.id.nav_logout)
        {

        }
        else if(id==R.id.nav_exit)
        {
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matters_home);
        home_button=(LinearLayout)findViewById(R.id.home_button_layout);
        matters_button=(LinearLayout)findViewById(R.id.matters_button_layout);
        calendar_button=(LinearLayout)findViewById(R.id.calendar_button_layout);
        add_matters_button=(LinearLayout)findViewById(R.id.add_matter_button_layout);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });
      /*  matters_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MattersHome.class));
            }
        });*/
        calendar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CalendarActivity.class)); //to be changed
            }
        });
        add_matters_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddMatter.class));
            }
        });
        ArrayList<Note> notes=new ArrayList<>();
        notes.add(new Note("Meeting With Client", "Meet client at my office tomorrow at 6PM to discuss the matter."));
        matters.add(new Matter(
                "Wrongful Termination - Horner Simpson",
                "Martin & Jones",
                "Oct, 10 2016",
                "$13500",
                "$15000",
                "In-Progress",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        matters.add(new Matter(
                "Employee Sexual Harassment- Donald Trump",
                "Martin & Jones",
                "Oct, 10 2016",
                "$13000",
                "$16000",
                "Completed",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        matters.add(new Matter(
                "Medical Record Request - Hillary Clinton",
                "Martin & Jones",
                "Oct, 05 2016",
                "$13000",
                "$16000",
                "Not-Started",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        matters.add(new Matter(
                "Trademark Filing- LexisNexis/ Rise to Code",
                "Martin & Jones",
                "Oct, 01 2016",
                "$22000",
                "$28000",
                "Completed",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        matters.add(new Matter(
                "Trademark Filing- LexisNexis/ Rise to Code",
                "Martin & Jones",
                "Oct, 01 2016",
                "$22000",
                "$28000",
                "Completed",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        matters.add(new Matter(
                "Malpractice- Joe Smith vs Dr. Bob Kelso",
                "Martin & Jones",
                "Sept, 17 2016",
                "$17000",
                "$20000",
                "In-Progress",
                "Harvey Dent",
                "dent.harvey@martin&jones.com",
                notes
        ));
        temp=matters;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter=new MessageAdapter(this);
        list.setAdapter(messageAdapter);
        list.setHasFixedSize(true);
    }
    MessageAdapter messageAdapter;
    public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {
        private Activity host;
        private final LayoutInflater inflater;

        public MessageAdapter(Activity activity) {
            host = activity;
            inflater = LayoutInflater.from(host);
        }

        @Override
        public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MessageHolder(inflater.inflate(R.layout.matters_list_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(final MessageHolder holder, final int position) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),ViewMatter.class));
                }
            });
            int pos=position;
            if(flag)
            {
                pos=2;
                flag=false;

            }

            if(matters.get(pos).status.equalsIgnoreCase("Completed"))
            {
                avatar.setBackgroundResource(R.drawable.ic_completed_24dp);
            }
            else if(matters.get(pos).status.equalsIgnoreCase("In-Progress"))
            {
                avatar.setBackgroundResource(R.drawable.ic_ongoing_24dp);
            }
            else
            {
                avatar.setBackgroundResource(R.drawable.ic_pending_24dp);
            }

            title.setText(matters.get(pos).title);
            subtitle.setText(matters.get(pos).law_name);
            date.setText(matters.get(pos).date);
        }

        @Override
        public int getItemCount() {
            if(flag)
                return 1;
            return matters.size();
        }
    }
    View avatar;
    TextView title,date;
    TextView subtitle;

    class MessageHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {



        public MessageHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            title = (TextView)itemView.findViewById(R.id.title_text);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle);
            date = (TextView)itemView.findViewById(R.id.type);

            itemView.setOnCreateContextMenuListener(this);


        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0, v.getId(), 0, "Edit");
            menu.add(0, v.getId(), 0, "Delete");

        }

    }
    class Matter
    {
        String title,law_name,date,budget_app,budget_act,status,contact_name,contact_email;
        ArrayList<Note> notes=new ArrayList<>();
        public Matter(String title,String law_name,String date,String budget_app,String budget_act, String status,String contact_name, String contact_email,ArrayList<Note> notes)
        {
            this.title=title;
            this.law_name=law_name;
            this.date=date;
            this.budget_app=budget_app;
            this.budget_act=budget_act;
            this.status=status;
            this.contact_name=contact_name;
            this.contact_email=contact_email;
            this.notes=notes;
        }
    }
    class Note
    {
        String title,note;
        public Note(String title,String note)
        {
            this.title=title;
            this.note=note;
        }
    }
}
