package com.example.classfive;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

//1. to import stuff from other classes [extends (RecyclerView).Adapter]
//+ [implement methods] from error bulb
public class ItemAdapter extends RecyclerView.Adapter {

    //2. add two attributes: re-identify the array list & add context
    ArrayList<Movies> MovieList=new ArrayList<>();
    Context context;

    //3. generate a Constructor with all the attributes
    public ItemAdapter(ArrayList<Movies> movieList, Context context) {
        MovieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //8. to use an external xml, id View = LayoutInflater.from --- layout.[row_item], parent, false);
        //id a view holder as the above name and return it
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //9. add the setText and setImg
        //((inner class name)holder form above line).what you named them.setText ---
        //(listname.get(position form above line).get[PhoneName()]) | (+ "") for int and double
        ((ViewHolder)holder).textname.setText(MovieList.get(position).getMovieName());
        ((ViewHolder)holder).textduration.setText(MovieList.get(position).getMovieHrs() + "hr " + MovieList.get(position).getMovieMints() + "mins");
        ((ViewHolder)holder).img.setImageResource(MovieList.get(position).getMovieImg());

        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("movie", MovieList.get(position));
                context.startActivity(intent);
            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movies removedmovie = MovieList.get(position);
                int x = position;
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MovieList.remove(position);
                                notifyDataSetChanged();

                                Snackbar.make(context, view, "1 item deleted", 3000)
                                        .setAction("undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                MovieList.add(position, removedmovie);
                                                notifyDataSetChanged();
                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        //10. return the list size
        return MovieList.size();
    }
    //4. new inner class named ViewHolder + [create constructor matching super] from error bulb
    public class ViewHolder extends RecyclerView.ViewHolder{

        //5. identify the components
        //can either do this or directly write it before the id statement attachments
        ImageView img, delete;
        TextView textname, textduration;
        //6. cannot directly id the comps, so use view
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //7. name it=above view.find--(--id of comp from row_item)
            v = itemView;
            img = v.findViewById(R.id.imageView);
            textname = v.findViewById(R.id.textViewname);
            textduration = v.findViewById(R.id.textViewduration);
            delete = v.findViewById(R.id.imagedelete);
        }
    }
}
