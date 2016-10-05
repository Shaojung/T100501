package tw.com.pcschool.t100501.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Person> mylist = new ArrayList();

        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();
        File file = new File(context.getFilesDir().getAbsolutePath(),
                "person.txt");
        try {
            fr = new FileReader(file);
            while (fr.read(buffer)!= -1) {
                sb.append(new String(buffer));
            }
            Gson gson = new Gson();
            mylist = gson.fromJson(sb.toString(), new TypeToken<List<Person>>(){}.getType());
        }
        catch (IOException e) { }
        finally {
            try {
                fr.close(); // 關閉檔案
            }
            catch (IOException e) { }
        }

        return mylist;
    }

    @Override
    public void update(Person p) {

    }
}
