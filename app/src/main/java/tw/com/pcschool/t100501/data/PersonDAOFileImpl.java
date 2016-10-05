package tw.com.pcschool.t100501.data;

import android.content.Context;

import java.util.List;

/**
 * Created by student on 2016/10/5.
 */
public class PersonDAOFileImpl
    implements PersonDAO{
    Context context;
    public PersonDAOFileImpl(Context context)
    {
        this.context = context;
    }

    @Override
    public void add(Person p) {

    }

    @Override
    public void delete(Person p) {

    }

    @Override
    public List<Person> getList() {
        return null;
    }

    @Override
    public void update(Person p) {

    }
}
