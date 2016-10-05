package tw.com.pcschool.t100501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tw.com.pcschool.t100501.data.Person;
import tw.com.pcschool.t100501.data.PersonDAO;
import tw.com.pcschool.t100501.data.PersonDAOFileImpl;

public class AddActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



    }
    public void clickSave(View v)
    {
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        PersonDAO impl = new PersonDAOFileImpl(AddActivity.this);
        impl.add(new Person(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString()));
        finish();
    }
}
