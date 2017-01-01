package org.esiea.kidjo_caron_chebbi.pronobet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yoann on 20/12/2016.
 */
public class BetAdapter extends RecyclerView.Adapter<BetAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Bet> betList;
    private LayoutInflater inflater;

    public BetAdapter(Context context, ArrayList<Bet> betList){

        this.context = context;
        this.betList = betList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.bet_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bet currentBet = betList.get(position);
        holder.match.setText(currentBet.teams);
        holder.odds.setText(currentBet.odds);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WinIntent = new Intent(context,Winner.class);
                context.startActivity(WinIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (betList != null) {
            return betList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView CV;
        public TextView match;
        public TextView odds;

        public ViewHolder(View itemView) {
            super(itemView);
            CV = (CardView)itemView.findViewById(R.id.CV);
            match = (TextView)itemView.findViewById(R.id.match);
            odds = (TextView)itemView.findViewById(R.id.odds);
        }
    }

}
