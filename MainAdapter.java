package aligoldsmith.com;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Activity activity;
    JSONArray jsonArray;
    public MainAdapter(Activity activity,JSONArray jsonArray){
        this.activity=activity;
        this.jsonArray=jsonArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {

            JSONObject object=jsonArray.getJSONObject(position);
            String sRating= object.getString("rating");
            holder.tvRating.setText(sRating);
            holder.ratingBar.setRating(Float.parseFloat(sRating));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {

        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRating;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRating = itemView.findViewById(R.id.tv_rating);
            ratingBar=itemView.findViewById(R.id.rating_bar);
        }
    }
}
