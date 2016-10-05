package tw.com.pcschool.t100501.data;

import java.util.List;

/**
 * Created by student on 2016/10/5.
 */
public interface PersonDAO {
    public void add (Person p);
    public void delete(Person p);
    public List<Person> getList();
    public void update(Person p);
    public Person getPerson(int ID);
}
