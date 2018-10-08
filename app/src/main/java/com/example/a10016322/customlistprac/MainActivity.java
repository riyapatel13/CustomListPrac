package com.example.a10016322.customlistprac;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10016322.customlistprac.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView spinner;
    ArrayList<Pokemon> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        spinner = (ListView)(findViewById(R.id.listView));

        arrayList.add(new Pokemon("Pikachu", 9000, 100, "electric"));
        arrayList.add(new Pokemon("Togepi", 9000, 100, "fairy"));
        arrayList.add(new Pokemon("Pachirisu", 9000, 100, "electric"));
        arrayList.add(new Pokemon("Mewtwo", 9000, 100, "psychic"));
        arrayList.add(new Pokemon("Rayquasa", 9000, 100, "dragon"));


        CustomAdapter myAdapter = new CustomAdapter(this, R.layout.layout_spinner, arrayList);

        spinner.setAdapter(myAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter {
        List list;
        Context mainContext;

        public CustomAdapter(Context context, int resource, List<Pokemon> objects) {
            super(context, resource, objects);
            list = objects; //this way we can use objects from list in main method
            mainContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)mainContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //use this b/c setContentView only works in main activity
            //without ContentView, xml file will not show
            View layoutView = inflater.inflate(R.layout.layout_spinner,null);
            TextView textView = (TextView)layoutView.findViewById(R.id.textView);
            ImageView imageView = (ImageView)layoutView.findViewById(R.id.imageView);

            textView.setText(list.get(position).);
            imageView.setImageResource(R.mipmap.ic_launcher);

            return layoutView;
        }
    }

}

