package ck.dndcopilot;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CharacterSelectActivity extends AppCompatActivity {

    public final static String MSG_CHAR_NAME = "ck.DnDCoPilot.MESSAGE";
    CharListDBOpenHelper charDb;
    EditText editName, editID;
    Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        charDb = new CharListDBOpenHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editID = (EditText) findViewById(R.id.editText_ID);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnViewAll = (Button) findViewById(R.id.button_view_all);
        btnUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
        AddData();
        viewAll();
        updateData();
        deleteData();

    }

    public void deleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRow = charDb.deleteData(editID.getText().toString());
                        if (deletedRow > 0)
                            Toast.makeText(CharacterSelectActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CharacterSelectActivity.this, "Data Not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void updateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = charDb.updateData(editID.getText().toString(), editName.getText().toString());
                        if(isUpdate)
                            Toast.makeText(CharacterSelectActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CharacterSelectActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = charDb.insertData(editName.getText().toString());
                        if (isInserted)
                            Toast.makeText(CharacterSelectActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CharacterSelectActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = charDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            // res getString uses the index of the column (the order created, starting at 0
                            String st1 = "ID : "   + res.getString(0) + "\n";
                            String st2 = "Name : " + res.getString(1) + "\n\n";
                            buffer.append(st1);
                            buffer.append(st2);
                        }

                        //Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_character_select, menu);
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

    //  Called when the sort button on the character list screen is clicked
    public void cList_Sort(View v) {
        Button button = (Button) findViewById(R.id.cList_Sort_Button);
        int status = Integer.parseInt(v.getTag().toString());

        if (status == 1) {
            button.setText("Sort: A-Z");
            v.setTag(2);
        } else if (status == 2) {
            button.setText("Sort: Created");
            v.setTag(3);
        } else {
            button.setText("Sort: Used");
            v.setTag(1);
        }

    }

    public void cList_New(View view) {
        Button button = (Button) findViewById(R.id.cList_New_Button);

    }

    public void ldUlfgarr(View v) {
        Intent intent = new Intent(this, CharacterHome.class);
        String message = "Ulfgarr";
        intent.putExtra(MSG_CHAR_NAME, message);
        startActivity(intent);

    }
}
