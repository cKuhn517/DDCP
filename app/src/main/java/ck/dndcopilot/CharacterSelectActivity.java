package ck.dndcopilot;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelectActivity extends AppCompatActivity {

    public final static String MSG_CHAR_NAME = "ck.DnDCoPilot.MESSAGE";
    CharListDBOpenHelper charDb;
    //EditText editName, editID;
    //Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        charDb = new CharListDBOpenHelper(this);

        //populateListView();

        updateListView();

/*
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
*/

    }

    private void updateListView() {
        //generate list
        ArrayList<String> list = charDb.listChars();
        //instantiate custom adapter
        MyCustomAdapter adapter = new MyCustomAdapter(list, this);
        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listView_clist);
        lView.setAdapter(adapter);
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
        Button button = (Button) findViewById(R.id.button_clist_sort);
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
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CharacterSelectActivity.this);
        alertDialog.setTitle("Add New Character");
        alertDialog.setMessage("Enter Name");

        final EditText input = new EditText(CharacterSelectActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Done",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String newName = input.getText().toString();
                        if (newName.length() != 0) {
                            boolean isInserted = charDb.insertData(newName);
                            if (isInserted) {
                                Toast.makeText(CharacterSelectActivity.this, "Character Added", Toast.LENGTH_SHORT).show();
                                updateListView();
                            }
                            else
                                Toast.makeText(CharacterSelectActivity.this, "Failed to add character", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(CharacterSelectActivity.this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }

/*
    public void cList_Delete(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CharacterSelectActivity.this);
        alertDialog.setTitle("Delete Character");
        alertDialog.setMessage("Enter ID");

        final EditText input = new EditText(CharacterSelectActivity.this);
        input.setInputType(2);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String id = input.getText().toString();
                        if (id.length() != 0) {
                            int isDeleted = charDb.deleteData(id);
                            if (isDeleted > 0) {
                                Toast.makeText(CharacterSelectActivity.this, "Character deleted", Toast.LENGTH_SHORT).show();
                                updateListView();
                            }
                            else
                                Toast.makeText(CharacterSelectActivity.this, "Failed to delete character", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(CharacterSelectActivity.this, "ID cannot be blank", Toast.LENGTH_SHORT).show();
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }


    public void ldUlfgarr(View v) {
        Intent intent = new Intent(this, CharacterHome.class);
        String message = "Ulfgarr";
        intent.putExtra(MSG_CHAR_NAME, message);
        startActivity(intent);

    }

    private void populateListView() {
        Cursor cursor = charDb.getAllRows();
        cursor.moveToFirst();
        String[] fromFieldNames = new String[] {CharListDBOpenHelper.COL_CHAR_ID.toString(), CharListDBOpenHelper.COL_CHAR_NAME};
        int[] toViewIDs = new int[] {R.id.textView_clist_listview_id, R.id.textView_clist_listview_name};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_char_select,
                cursor, fromFieldNames, toViewIDs, 0);
        ListView charList = (ListView) findViewById(R.id.listView_clist);
        charList.setAdapter(myCursorAdapter);
    }


    public void deleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRow = charDb.deleteData(editID.getText().toString());
                        if (deletedRow > 0) {
                            Toast.makeText(CharacterSelectActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                            updateListView();
                        }else
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
                        if (isUpdate)
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
                            String st1 = "ID : " + res.getString(charDb.COLN_CHAR_ID) + "\n";
                            String st2 = "Name : " + res.getString(charDb.COLN_CHAR_NAME) + "\n\n";
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
*/


    public class MyCustomAdapter extends BaseAdapter implements ListAdapter {

        private ArrayList<String> list = new ArrayList<>();
        private Context context;

        public MyCustomAdapter(ArrayList<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int pos) {
            return list.get(pos);
        }


        @Override
        public long getItemId(int pos) {
            return 0;//list.get(pos).getId();
            //just return 0 if your list items do not have an Id variable.
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listview_char_select, null);
            }

            //Handle TextView and display string from your list
            TextView listItemText = (TextView)view.findViewById(R.id.textView_clist_listview_name);
            listItemText.setText(list.get(position));
            TextView listItemPos = (TextView) view.findViewById(R.id.textView_clist_listview_id);
            listItemPos.setText(Integer.toString(position));

            //Handle buttons and add onClickListeners
            Button deleteBtn = (Button)view.findViewById(R.id.button_clist_listview_delete);
            Button ldBtn = (Button)view.findViewById(R.id.button_clist_listview_load);

            deleteBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (charDb.deletePosition(position)) {
                        Toast.makeText(CharacterSelectActivity.this, "Character deleted", Toast.LENGTH_SHORT).show();
                        list.remove(position); //or some other task
                        notifyDataSetChanged();
                    }else
                        Toast.makeText(CharacterSelectActivity.this, "Delete failed", Toast.LENGTH_SHORT).show();

                }
            });
            ldBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CharacterSelectActivity.this, CharacterHome.class);
                    String message = list.get(position);
                    intent.putExtra(MSG_CHAR_NAME, message);
                    startActivity(intent);
                }
            });

            return view;
        }
    }

}
