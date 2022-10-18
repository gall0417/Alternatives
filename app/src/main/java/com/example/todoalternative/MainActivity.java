package com.example.todoalternative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> todoItems;
    private ArrayAdapter<String> ItemsAdapter;
    private ListView listView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lab4listview);
        btn = findViewById(R.id.btn_add);

        btn.setOnClickListener(view -> addItem(view));

        todoItems = new ArrayList<>();
        ItemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);
        listView.setAdapter(ItemsAdapter);
        setUpListViewListener();
        
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Context context = getApplicationContext();
            Toast.makeText(context,"Item removed", Toast.LENGTH_LONG).show();

            todoItems.remove(i);
            ItemsAdapter.notifyDataSetChanged();
            return true;
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.lab4EditText);
        String todoText = input.getText().toString();

        if(!(todoText.equals("")))
        {
            ItemsAdapter.add(todoText);
            input.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Text Cannot Be Empty.", Toast.LENGTH_LONG).show();
        }
    }
}