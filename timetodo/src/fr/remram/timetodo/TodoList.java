package fr.remram.timetodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import fr.remram.timetodo.data.DataManager;

public class TodoList extends Activity {

    private DataManager database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        database = new DataManager(this);

        String[] debug_items = {"Some task", "Other task", "And the last one"};
        ArrayAdapter debug_adapter = new ArrayAdapter<String>(
                this,
                R.layout.task_list_entry,
                debug_items);

        ListView task_list = (ListView)findViewById(
                R.id.view_task_list);
        Log.v("TodoList", "task_list: " + task_list);
        task_list.setAdapter(debug_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle item selection
        switch(item.getItemId())
        {
        case R.id.action_new_task:
            {
                Intent add_task = new Intent(this, AddTask.class);
                startActivity(add_task);
                return true;
            }
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}
