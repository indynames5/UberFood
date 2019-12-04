package com.example.uberfood;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<String> pic = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> rate = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);




        recyclerView = (RecyclerView) findViewById(R.id.myRecycle_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


//        String[] myDataset = {"Item 1", "Item 2", "Item 3"};

        final String TAG = "testFireStore";
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("reccomment")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                name.add(document.get("name").toString());

                                pic.add(document.get("picture").toString());

                                id.add(document.get("id").toString());

                                rate.add(document.get("rate").toString());
                            }


                            String[] Name = name.toArray(new String[0]);
                            String[] Pic = pic.toArray(new String[0]);
                            String[] Rate = rate.toArray(new String[0]);

                            mAdapter = new MyAdapter(ListActivity.this,Pic,Name,Rate);
                            recyclerView.setAdapter(mAdapter);

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


    }
}
