package com.macchli.checklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayList mainTaskList = new ArrayList();
    ArrayAdapter mainArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView) findViewById(R.id.main_textview);

        mainEditText = (EditText) findViewById(R.id.main_edittext);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mainListView = (ListView) findViewById(R.id.main_listview);
        mainArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mainTaskList);
        mainListView.setAdapter(mainArrayAdapter);
        mainListView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view){
        mainTaskList.add(mainEditText.getText().toString());
        mainEditText.setText("");
        mainArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        itemClicked(position);
    }

    private void itemClicked(final int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to want to delete the item?");

        alert.setPositiveButton("Yes, Delete!", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                mainTaskList.remove(position);
                mainArrayAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Item successfully deleted!", Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {}
        });

        alert.show();
    }
}
