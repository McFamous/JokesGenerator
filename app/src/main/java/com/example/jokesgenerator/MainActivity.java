package com.example.jokesgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;

    private RecyclerView jokesList;
    private JokesAdapter adapter;
    private EditText countJokes;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivityView();

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editBtn.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                list.clear();
                adapter.clearItems();
                if(countJokes.getText().toString().length() != 0){
                    try {
                        int count = Integer.parseInt(countJokes.getText().toString());
                        NetworkService.getInstance()
                                .getJsonJokesApi()
                                .getJokes(count)
                                .enqueue(new Callback<JokeModel>() {
                            @Override
                            public void onResponse(Call<JokeModel> call, Response<JokeModel> response) {
                                if(response.body().getType().equals("success")){
                                    ArrayList<JokeModel.Value> values = new ArrayList<>();
                                    values.addAll(response.body().getValue());
                                    for(JokeModel.Value v : values)
                                        list.add(v.getJoke());
                                    adapter.setItems(list);
                                }
                            }

                            @Override
                            public void onFailure(Call<JokeModel> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, "Enter only numbers", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initActivityView() {
        countJokes = findViewById(R.id.enter_count_jokes);
        editBtn = findViewById(R.id.go_btn);
        list = new ArrayList<>();

        jokesList = findViewById(R.id.jokes_list);
        jokesList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new JokesAdapter();
        jokesList.setAdapter(adapter);
    }
}