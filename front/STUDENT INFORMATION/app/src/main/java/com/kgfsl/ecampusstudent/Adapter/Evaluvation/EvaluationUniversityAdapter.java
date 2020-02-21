package com.kgfsl.ecampusstudent.Adapter.Evaluvation;


import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kgfsl.ecampusstudent.Pojo.Evaluvation.PojoEvaluvationUniversity;
import com.kgfsl.ecampusstudent.R;

/**
 * Created by manivasagam on 02-11-2017.
 */

public class EvaluationUniversityAdapter  extends RecyclerView.Adapter<EvaluationUniversityAdapter.Holder> {
    Context ctx;
    PojoEvaluvationUniversity pojoEvaluvationUniversity;

    public EvaluationUniversityAdapter(Context context, PojoEvaluvationUniversity pojoEvaluvationInternal) {
        this.ctx = context;
        this.pojoEvaluvationUniversity = pojoEvaluvationInternal;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluation_row, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        LinearLayout.LayoutParams p2= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView textSub = new TextView(ctx);
        textSub.setLayoutParams(p2);
        p2.setMargins(10,10,10,10);
        textSub.setText(pojoEvaluvationUniversity.getData().get(position).getSub());
        holder.linearsub.addView(textSub);


        for (int i = 0; i < pojoEvaluvationUniversity.getData().get(position).getResult().size(); i++) {
            TextView textMark = new TextView(ctx);
            LinearLayout.LayoutParams p1=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
            );
            p1.setMargins(10,10,10,10);
            textMark.setLayoutParams(p1);
            if(Integer.parseInt(pojoEvaluvationUniversity.getData().get(position).getResult().get(i))<40){
                textMark.setTextColor(ctx.getResources().getColor(R.color.red));
            }
            if(Integer.parseInt(pojoEvaluvationUniversity.getData().get(position).getResult().get(i))!=0) {
                textMark.setText(String.valueOf(pojoEvaluvationUniversity.getData().get(position).getResult().get(i)));
            }else{
                textMark.setText("-");
            }


            View v = new View(ctx);
            v.setLayoutParams(new LinearLayout.LayoutParams(
                    1,
                    LinearLayoutCompat.LayoutParams.MATCH_PARENT
            ));
            v.setBackgroundColor(ctx.getResources().getColor(R.color.colorSecondaryPrimaryText));

            holder.linearmark.addView(textMark);
            holder.linearmark.addView(v);
        }

    }

    @Override
    public int getItemCount() {
        return pojoEvaluvationUniversity.getData().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout linearmark, linearsub;


        public Holder(View itemView) {
            super(itemView);
            linearmark = (LinearLayout) itemView.findViewById(R.id.linearmark);
            linearsub = (LinearLayout) itemView.findViewById(R.id.linearsub);


        }
    }
}

