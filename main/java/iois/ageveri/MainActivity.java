package iois.ageveri;

import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    ArrayList<String> list;
    ListView li;
    private String[] myString;
    private static final Random rgenerator = new Random();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Strings for jokes under LV
        Resources res = getResources();
        myString = res.getStringArray(R.array.jokeArray);
        String q = myString[rgenerator.nextInt(myString.length)];
        TextView tv2 =(TextView) findViewById(R.id.textViewJoke);
        tv2.setText(q);

        list=new ArrayList<String>();

        final TextView tv = (TextView) findViewById(R.id.textView1);
        li=(ListView)findViewById(R.id.listView1);
        for(int i=0;i<=125;i++){
            list.add(""+i+" trip(s) around the sun");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                list );

        li.setAdapter(arrayAdapter);
        li.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {
                // TODO Auto-generated method stub
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                tv.setText(new StringBuilder()
                        //Build date
                        .append("Year of Birth: ")
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear - position).append(" "));

            }
        });
    }


}