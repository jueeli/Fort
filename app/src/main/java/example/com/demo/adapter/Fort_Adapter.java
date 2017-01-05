package example.com.demo.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.demo.R;
import example.com.demo.SingleFortDetails;

/**
 * Created by softbunch on 6/18/16.
 */
public class Fort_Adapter extends RecyclerView.Adapter<Fort_Adapter.MyViewHolder> {
    Context context;

    int[] fortImg;
    String[] fortName;
    String[] fortIntroduction;
    String[] fortHistory;


    public Fort_Adapter(Context context, int[] fortImg, String[] fortName, String[] fortIntroduction, String[] fortHistory) {

        this.context = context;
        this.fortImg = fortImg;
        this.fortName = fortName;
        this.fortIntroduction = fortIntroduction;
        this.fortHistory = fortHistory;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        try {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fort_row, parent, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        try {
            holder.fortIntro.setText(fortIntroduction[position]);
            holder.fortImage.setImageResource(fortImg[position]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return fortName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fortIntro;
        ImageView fortImage;
        LinearLayout linearlayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            fortIntro = (TextView) itemView.findViewById(R.id.fort_intro);
            fortImage = (ImageView) itemView.findViewById(R.id.fort_img);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.linearlayout);


            linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    try {
                        Intent intent = new Intent(context, SingleFortDetails.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("FORTNAME", fortName[position]);
                        bundle.putString("FORTINTRO", fortIntroduction[position]);
                        bundle.putString("FORTHIST", fortHistory[position]);
                        bundle.putInt("FORTIMAGE", fortImg[position]);
                        intent.putExtras(bundle);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, linearlayout, "profile");
                            context.startActivity(intent, options.toBundle());
                        } else {
                            context.startActivity(intent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

        }
    }
}
