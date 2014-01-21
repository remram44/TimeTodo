package fr.remram.timetodo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTask extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void saveClicked(View button)
    {
        TaskManager database = new TaskManager(this);

        EditText name_view = (EditText)findViewById(R.id.add_task_name);
        String name = name_view.getText().toString();

        EditText period_view = (EditText)findViewById(R.id.add_task_period);
        // TODO : catch NumberFormatException
        int period = Integer.parseInt(period_view.getText().toString());

        database.createTask(name, period);

        finish();
    }

}
