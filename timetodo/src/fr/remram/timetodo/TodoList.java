package fr.remram.timetodo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;

public class TodoList extends ListActivity {

    private TaskManager m_Database = null;

    // This is the Adapter being used to display the list's data
    SimpleCursorAdapter m_Adapter;

    // These are the Contacts rows that we will retrieve
    static final String[] PROJECTION = new String[] {
            TaskManager.TASK_NAME,
            TaskManager.TASK_PERIOD};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        m_Database = new TaskManager(this);

        // Create a progress bar to display while the list loads
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        // For the cursor adapter, specify which columns go into which views
        String[] fromColumns = {TaskManager.TASK_NAME};
        int[] toViews = {android.R.id.text1};

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        m_Adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                m_Database.getTasksCursor(),
                fromColumns,
                toViews,
                0);
        setListAdapter(m_Adapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        if(m_Database != null)
            m_Adapter.swapCursor(m_Database.getTasksCursor());
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        // TODO : task clicked
    }
}
