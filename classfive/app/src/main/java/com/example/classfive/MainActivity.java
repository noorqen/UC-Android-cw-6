package com.example.classfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1. array list of <[class name]> then what you want to name it
    ArrayList<Movies>MovieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. identify the phones by ClassName phone# = new ClassName("name of obj", int/double, the image id)
        Movies m1 = new Movies("Monsters Inc." , 1, 36 , R.drawable.monster);
        Movies m2 = new Movies("Luca" , 1, 35 , R.drawable.luca);
        Movies m3 = new Movies("Tangled" , 1, 40 , R.drawable.tangled);
        Movies m4 = new Movies("Wall-E" , 1, 38 , R.drawable.walle);
        Movies m5 = new Movies("Ratatouille" , 1, 51 , R.drawable.rat);
        Movies m6 = new Movies("The Incredibles" , 1, 55 , R.drawable.incredibles);

        //3. name of list.add the identified phones
        MovieList.add(m1);
        MovieList.add(m2);
        MovieList.add(m3);
        MovieList.add(m4);
        MovieList.add(m5);
        MovieList.add(m6);

        //4. identified the recycler
        //set the recycler size as fixed
        //
        //rope the recycler with the manager above
        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        //5. after ItemAdapter class, [class name] [name it]= ---(listname, context of this class this)
        //recycler.setAdapter(name it^);
        ItemAdapter adapter = new ItemAdapter(MovieList, this);
        recycler.setAdapter(adapter);
    }
}
//XML FILES:
//row item: to display a list of item with the same card design, create new layout resource file
//add cardview as the main layout view and edit with the desired features to use it in code [row_item]
//example,, see [ItemAdapter.java]
//tip: edit the background color before adding the RecyclerView in activity_mail.xml