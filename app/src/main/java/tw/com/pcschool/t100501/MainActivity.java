package tw.com.pcschool.t100501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tw.com.pcschool.t100501.data.Person;
import tw.com.pcschool.t100501.data.PersonDAO;
import tw.com.pcschool.t100501.data.PersonDAOFileImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonDAO impl = new PersonDAOFileImpl(MainActivity.this);
        impl.add(new Person("Bob", "123", "bb123"));

    }
}
