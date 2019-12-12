package com.example.demofragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MessageFragment extends Fragment {
    public interface MessageSendListener{
        public void onMesage(String message);
    }

    MessageSendListener messageSendListener;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        Button displayBtn = view.findViewById(R.id.diplayBtn);
        final EditText msgET = view.findViewById(R.id.messageET);
        final String reverse = new StringBuffer(msgET.toString()).
                reverse().toString();

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = msgET.getText().toString();
                InputMethodManager imm = (InputMethodManager) getActivity().
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                View view1 = getActivity().getCurrentFocus();
                if(view1 == null){
                    view1 = new View(getActivity());
                }
                imm.hideSoftInputFromWindow(view1.getWindowToken(), 0);
                messageSendListener.onMesage(msg);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        messageSendListener = (MessageSendListener) activity;
    }
}
