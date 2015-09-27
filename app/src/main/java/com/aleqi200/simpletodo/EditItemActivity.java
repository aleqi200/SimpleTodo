package com.aleqi200.simpletodo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity implements Constants {

    private int position;
    private String editValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent intent = getIntent();
        setValueFromIntent(intent);
    }

    private void setValueFromIntent(Intent intent) {
        editValue = intent.getStringExtra(ITEM_VAVLUE);
        position = intent.getIntExtra(ITEM_VAVLUE, 0);
        EditText etNewItem = (EditText) findViewById(R.id.etValue);
        etNewItem.setText(editValue);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void updateValue(View view) {
        EditText etNewItem = (EditText) findViewById(R.id.etValue);
        String newValue = etNewItem.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra(ITEM_VAVLUE, newValue);
        intent.putExtra(POSITION, position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
