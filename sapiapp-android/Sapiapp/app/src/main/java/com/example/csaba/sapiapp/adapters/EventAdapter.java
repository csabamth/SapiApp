package com.example.csaba.sapiapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.models.Esemeny;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    public static String IMG_URL = "http://10.0.2.2/sapiapp/public/uploads/";
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    public Context context;
    public onItemClickListener eListener;
    private ArrayList<Esemeny> elist;
    private String etoken;

    public EventAdapter(Context context, ArrayList<Esemeny> eventlist, String token) {
        elist = eventlist;
        etoken = token;
        this.context = context;

    }

    public void setonItemClickListener(onItemClickListener listener) {
        eListener = listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_event_item, parent, false);
        EventViewHolder evh = new EventViewHolder(v, eListener);

        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final EventViewHolder holder, int position) {
        final Esemeny currentItem = elist.get(position);


        Call<List<Esemeny>> esemenycall = service.getEsemenyek("Bearer " + etoken);
        esemenycall.enqueue(new Callback<List<Esemeny>>() {
            @Override
            public void onResponse(Call<List<Esemeny>> call, final Response<List<Esemeny>> response) {
                holder.text_cim.setText(currentItem.getCim());
                holder.text_leiras.setText(currentItem.getLeiras().replaceAll("\n", ""));
                holder.text_leiras.setMovementMethod(new ScrollingMovementMethod());
                holder.text_esemeny_datum.setText(currentItem.getEsemeny_datum());
                Picasso.get().load(IMG_URL + currentItem.getImg_url()).into(holder.image_imgurl);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Esemeny>> call, Throwable t) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return elist.size();
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView text_cim, text_leiras, text_esemeny_datum;
        public ImageView image_imgurl;


        public EventViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            text_cim = itemView.findViewById(R.id.text_cim);
            text_leiras = itemView.findViewById(R.id.text_leiras);
            text_esemeny_datum = itemView.findViewById(R.id.text_esemeny_datum);
            image_imgurl = itemView.findViewById(R.id.image_imgurl);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

}
