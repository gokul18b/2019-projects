package com.kgfsl.ecampusstudent.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgfsl.ecampusstudent.Adapter.Evaluvation.EvaluationUniversityAdapter;
import com.kgfsl.ecampusstudent.Adapter.Evaluvation.EvaluvationInternalAdapter;
import com.kgfsl.ecampusstudent.Pojo.Evaluvation.PojoEvaluvationInternal;
import com.kgfsl.ecampusstudent.Pojo.Evaluvation.PojoEvaluvationUniversity;
import com.kgfsl.ecampusstudent.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class EvaluvationFragment extends Fragment {
    View v;
    @InjectView(R.id.recyclerview)
    RecyclerView recyclerView;
    @InjectView(R.id.linearsub)
    LinearLayout linearSub;
    @InjectView(R.id.linearmark)
    LinearLayout linearmark;


    public EvaluvationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_evaluvation, container, false);
        ButterKnife.inject(this, v);
        Init();

        return v;
    }

    private void Init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Internal();
        //University();
    }

    private void University() {
        String json = "{\"noe\":5,\"exname\":[\"Credits\",\"Letter Grade\",\"Grade Point\",\"Eval Month\",\"M II\"],\"data\":[{\"sub\":\"COMPUTER PRACTICE LABORATORY\",\"result\":[\"3\",\"D\",\"6\",\"68\",\"Apr-2016\"]},{\"sub\":\"COMPUTER PROGRAMMING\",\"result\":[\"4\",\"A\",\"3\",\"87\",\"Apr-2016\"]},{\"sub\":\"ENGINEERING CHEMISTRY I\",\"result\":[\"4\",\"A\",\"4\",\"68\",\"Apr-2016\"]},{\"sub\":\"ENGINEERING GRAPHICS\",\"result\":[\"4\",\"D\",\"4\",\"45\",\"Apr-2016\"]},{\"sub\":\"ENGINEERING PHYSICS - I\",\"result\":[\"5\",\"B\",\"6\",\"68\",\"Apr-2016\"]},{\"sub\":\"ENGINEERING PRACICE LAB\",\"result\":[\"7\",\"F\",\"3\",\"23\",\"Apr-2016\"]},{\"sub\":\"MATHEMATICS I\",\"result\":[\"6\",\"D\",\"6\",\"56\",\"Apr-2016\"]},{\"sub\":\"PHYSICS AND CHEMISTRY LABORATORY – I\",\"result\":[\"3\",\"A\",\"3\",\"65\",\"Apr-2016\"]}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PojoEvaluvationUniversity pojoEvaluvationUniversity = objectMapper.readValue(json, PojoEvaluvationUniversity.class);
            EvaluationUniversityAdapter evaluationUniversityAdapter = new EvaluationUniversityAdapter(v.getContext(), pojoEvaluvationUniversity);

            recyclerView.setAdapter(evaluationUniversityAdapter);

        } catch (Exception e) {
            Toast.makeText(v.getContext(),String.valueOf(e),Toast.LENGTH_SHORT).show();

        }
    }

    private void Internal() {
        String json = "{\"noe\":5,\"exname\":[\"I\",\"II\",\"III\",\"IV\",\"V\"],\"data\":[{\"sub\":\"COMPUTER PRACTICE LABORATORY\",\"result\":[\"90\",\"87\",\"0\",\"68\",\"74\"]},{\"sub\":\"COMPUTER PROGRAMMING\",\"result\":[\"0\",\"87\",\"0\",\"68\",\"74\"]},{\"sub\":\"ENGINEERING CHEMISTRY I\",\"result\":[\"90\",\"87\",\"0\",\"68\",\"74\"]},{\"sub\":\"ENGINEERING GRAPHICS\",\"result\":[\"45\",\"37\",\"29\",\"65\",\"47\"]},{\"sub\":\"ENGINEERING PHYSICS - I\",\"result\":[\"90\",\"87\",\"0\",\"68\",\"74\"]},{\"sub\":\"ENGINEERING PRACICE LAB\",\"result\":[\"78\",\"42\",\"39\",\"64\",\"70\"]},{\"sub\":\"MATHEMATICS I\",\"result\":[\"58\",\"45\",\"45\",\"65\",\"87\"]},{\"sub\":\"PHYSICS AND CHEMISTRY LABORATORY – I\",\"result\":[\"52\",\"26\",\"53\",\"41\",\"47\"]}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            PojoEvaluvationInternal pojoEvaluvationInternal = objectMapper.readValue(json, PojoEvaluvationInternal.class);
            setHeader(pojoEvaluvationInternal);
            EvaluvationInternalAdapter evaluvationInternalAdapter = new EvaluvationInternalAdapter(v.getContext(), pojoEvaluvationInternal);
            recyclerView.setAdapter(evaluvationInternalAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void setHeader(PojoEvaluvationInternal pojoEvaluvationInternal) {
        LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView textSub = new TextView(v.getContext());
        p2.setMargins(10, 10, 10, 10);
        textSub.setLayoutParams(p2);

        textSub.setTextColor(v.getResources().getColor(R.color.colorAccent));
        textSub.setText("Subject");
        linearSub.addView(textSub);

        for (int i = 0; i < pojoEvaluvationInternal.getExname().size(); i++) {
            LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
            );
            p1.setMargins(10, 10, 10, 10);

            TextView textMark = new TextView(v.getContext());
            textMark.setLayoutParams(p1);
            linearmark.setGravity(Gravity.CENTER);
            textMark.setText(pojoEvaluvationInternal.getExname().get(i));
            textMark.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textMark.setTextColor(v.getResources().getColor(R.color.colorAccent));

            View view = new View(v.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    1,
                    LinearLayoutCompat.LayoutParams.MATCH_PARENT
            ));
            view.setBackgroundColor(v.getContext().getResources().getColor(R.color.colorSecondaryPrimaryText));

            linearmark.addView(textMark);
            linearmark.addView(view);

        }

    }

}

