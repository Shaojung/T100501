package tw.com.pcschool.t100501.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
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
        ArrayList<Person> mylist = (ArrayList) getList();
        mylist.add(p);
        Type listOfTestObject = new TypeToken<List<Person>>(){}.getType();
        Gson gson = new Gson();
        String s = gson.toJson(mylist, listOfTestObject);
        Log.d("ADD", s);


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
            catch (Exception e) { }
        }

        return mylist;
    }

    @Override
    public void update(Person p) {

    }


}
