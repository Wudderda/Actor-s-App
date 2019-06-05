package com.hasan.actorsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    private TextView hello_world;
    private EditText name;
    private String SearchName;
    private LinkedList list;
    private String[]AllPeople;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize views and variables
        init();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, AllPeople);
        //Getting user input from name EditText
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled=false;
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    String input=(v.getText().toString().isEmpty()) ? "0":v.getText().toString();
                    count=list.search(list,input);
                    hello_world.setText("# of matched actors:"+count);
                    handled=true;
                }
                return handled;
            }
        });
    }
    public void init(){
        count=0;
        hello_world=(TextView) findViewById(R.id.hello_world);
        //initializing the TextView for displaying search result.
        hello_world.setText("# of matched actors:"+count);
        name=(EditText) findViewById(R.id.name);
        //Insertion of actors to the linked list
        //u can add your own actors with the following : list = list.insert(list,your_popularity,your_name);
        list = new LinkedList(null);
        list = list.insert(list,1,8.008,"George Lucas");
        list = list.insert(list, 2,6.199,"Mark Hamill");
        list = list.insert(list, 3,6.583,"Harrison Ford");
        list = list.insert(list, 4,5.837,	"Carrie Fisher");
        list = list.insert(list, 5,1.357,"Peter Wilton Cushing");
        list = list.insert(list, 6,2.179,"Anthony Daniels");
        list = list.insert(list, 7,3.898,"Andrew Stanton");
        list = list.insert(list, 8,1.286,"Lee Unkrich");
        list = list.insert(list, 9,0.6,	"Graham Walters");
        list = list.insert(list, 10,1.195,"Bob Peterson");
        list = list.insert(list, 11,1.4,"David Reynolds");
        list = list.insert(list, 12,2.562,"Alexander Gould");
        list = list.insert(list, 13,2.54,	"Albert Brooks");
        list = list.insert(list, 14,1.791,"Ellen DeGeneres");
        list = list.insert(list, 18,2.366,"Brad Garrett");
        list = list.insert(list, 19,3.311,"Allison Janney");
        list = list.insert(list, 20,2.099,"Elizabeth Perkins");
        list = list.insert(list, 22,1.38,"Barry Humphries");
        list = list.insert(list, 23,0.6,"Bill Hunter");
        list = list.insert(list, 26,1.4,"Winston Groom");
        list = list.insert(list, 27,1.019,"Eric Roth");
        list = list.insert(list, 27,0.6,"Wendy Finerman");
        list = list.insert(list, 29,0.6,	"Steve Tisch");
        list = list.insert(list, 30,1.214,	"Steve Starkey");
        list = list.insert(list, 31,10.341,	"Tom Hanks");
        list = list.insert(list, 32,4.513,"Robin Wright");
        list = list.insert(list, 33,2.07,"Gary Sinise");
        list = list.insert(list, 34,1.019,"Mykelti Williamson");
        list = list.insert(list, 35,1.551,"Sally Field");
        list = list.insert(list, 36,1.4,	"Don Burgess");
        list = list.insert(list, 37,0.996,"Alan Silvestri");
        list = list.insert(list, 38,0.6,"Arthur Schmidt");
        list = list.insert(list, 39,2.03,"Sam Mendes");
        list = list.insert(list, 40,2.932,	"Orson Welles");
        list = list.insert(list, 42,3.51,"Lars von Trier");
        list = list.insert(list, 43,0.6,	"John Fawcett");
        list = list.insert(list, 44,1.019,	"Simon Maginn");
        list = list.insert(list, 45,0.6,		"Stephen Massicotte");
        list = list.insert(list, 46,1.019,	"Simon Maginn");
        list = list.insert(list, 47,0.974,	"Björk");
        list = list.insert(list, 48,16.446,	"Sean Bean");
        list = list.insert(list, 49,4.044,	"Maria Bello");
        list = list.insert(list, 50,2.863,	"Catherine Deneuve");
        list = list.insert(list, 51,0.6,		"Richard Elfyn");

        //Array of string containing information about people in the list
        AllPeople = list.getDisplayString(list);
        //adapter to display list view of String objects
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, AllPeople);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
