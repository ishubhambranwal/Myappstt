package com.gola.myappstt;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_grp_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_grp_Fragment extends Fragment {

    EditText ed1,ed2,ed3;
    //ImageView img;
    Button but;
    FirebaseFirestore dbroot;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Add_grp_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_grp_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_grp_Fragment newInstance(String param1, String param2) {
        Add_grp_Fragment fragment = new Add_grp_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_add_grp_, container, false);

      ed2=(EditText)view.findViewById(R.id.nam_box);
      ed3=(EditText)view.findViewById(R.id.link_box);
      ed1=(EditText)view.findViewById(R.id.categry_box);
      //img=(ImageView)view.findViewById(R.id.add_grop_btn);
      but=(Button)view.findViewById(R.id.button2);
       but.setEnabled(false);

        ed1.addTextChangedListener(textWatcher);
        ed3.addTextChangedListener(textWatcher);
        ed1.addTextChangedListener(textWatcher);

       dbroot=FirebaseFirestore.getInstance();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if (TextUtils.isEmpty(ed1.getText().toString()))
                {
                    ed1.setError("The item Group Category cannot be empty");
                }

                if (TextUtils.isEmpty(ed2.getText().toString()))
                {
                    ed2.setError("The item Group Name cannot be empty");
                }

                if (TextUtils.isEmpty(ed3.getText().toString()))
                {
                    ed3.setError("The item Group Link cannot be empty");

                }*/

                insertdata();
                Toast toast= Toast.makeText(getActivity().getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }
    private void insertdata()
    {

        Map<String,String> items=new HashMap<>();
        items.put("name",ed2.getText().toString().trim());
        items.put("email",ed3.getText().toString().trim());
        items.put("grop",ed1.getText().toString().trim());

        dbroot.collection("collct").add(items)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");

                    }
                }); }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String n = ed1.getText().toString();
            String a = ed2.getText().toString();
            String c = ed3.getText().toString();

            if (!n.isEmpty() && !a.isEmpty() && !c.isEmpty()) {
                //both are not empty
                but.setEnabled(true);


            } else {
                but.setEnabled(false);
                Toast toast= Toast.makeText(getActivity().getApplicationContext(),"\uD83D\uDE1E We Dont Accept Empty Box \uD83E\uDD2A ",Toast.LENGTH_SHORT);
                View v1 = toast.getView();
                TextView text=v1.findViewById(android.R.id.message);
                text.setBackgroundColor(Color.RED);
                text.setTextSize(20);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
    }
                };
    }
