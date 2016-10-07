package tw.com.pcschool.t100501.data;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        int MAX_ID = 0;
        for (Person tp : mylist)
        {
            if (tp.ID > MAX_ID)
            {
                MAX_ID = tp.ID;
            }
        }
        p.ID = MAX_ID + 1;
        mylist.add(p);
        Type listOfTestObject = new TypeToken<List<Person>>(){}.getType();
        Gson gson = new Gson();
        String s = gson.toJson(mylist, listOfTestObject);
        Log.d("ADD", s);

        File file = new File(context.getFilesDir().getAbsolutePath(),
                "person.txt");
        FileOutputStream fOut;
        try {
            // fOut = openFileOutput(fName, MODE_PRIVATE);
            fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            osw.write(s);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Person p) {
        ArrayList<Person> mylist = (ArrayList) getList();
        for (int i=mylist.size()-1; i>=0;i--)
        {
            if (mylist.get(i).ID == p.ID)
            {
                mylist.remove(i);
                break;
            }
        }
        Type listOfTestObject = new TypeToken<List<Person>>(){}.getType();
        Gson gson = new Gson();
        String s = gson.toJson(mylist, listOfTestObject);

        File file = new File(context.getFilesDir().getAbsolutePath(),
                "person.txt");
        FileOutputStream fOut;
        try {
            // fOut = openFileOutput(fName, MODE_PRIVATE);
            fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            osw.write(s);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        ArrayList<Person> mylist = (ArrayList) getList();
        for (Person t : mylist)
        {
            if (t.ID == p.ID)
            {
                t.Name = p.Name;
                t.Tel = p.Tel;
                t.Addr = p.Addr;
                break;
            }
        }
        Type listOfTestObject = new TypeToken<List<Person>>(){}.getType();
        Gson gson = new Gson();
        String s = gson.toJson(mylist, listOfTestObject);

        File file = new File(context.getFilesDir().getAbsolutePath(),
                "person.txt");
        FileOutputStream fOut;
        try {
            // fOut = openFileOutput(fName, MODE_PRIVATE);
            fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            osw.write(s);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person getPerson(int ID) {
        ArrayList<Person> mylist = (ArrayList) getList();
        Person rt = null;
        for (Person p : mylist)
        {
            if (p.ID == ID)
            {
                rt = p;
                break;
            }
        }

        return rt;
    }


}
