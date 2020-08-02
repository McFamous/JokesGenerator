package com.example.jokesgenerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokesViewHolder> {

    private ArrayList<String> jokes = new ArrayList<>();

    public void setItems(ArrayList<String> newJokes) {
        jokes.addAll(newJokes);
        notifyDataSetChanged();//для то чтобы адаптер понял, что пора перерисовать элементы на экране
    }

    public void clearItems() {
        jokes.clear();
        notifyDataSetChanged();//для то чтобы адаптер понял, что пора перерисовать элементы на экране
    }


    @NonNull
    @Override
    public JokesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item_list,parent, false);
        return new JokesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokesViewHolder holder, int position) {
        holder.joke.setText(jokes.get(position));
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    class JokesViewHolder extends RecyclerView.ViewHolder{

        private TextView joke;

        public JokesViewHolder(@NonNull View itemView) {
            super(itemView);
            joke = itemView.findViewById(R.id.text_of_joke);
        }
    }
}