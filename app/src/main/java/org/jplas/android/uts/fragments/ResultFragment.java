package org.jplas.android.uts.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jplas.android.uts.R;
import org.jplas.android.uts.util.Biodata2;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
//    private String information;

    public ResultFragment() {
        // Required empty public constructor
    }

//    public void setInformation(String information) {
//        this.information = information;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_result, container, false);
//        TextView informationText = view.findViewById(R.id.text_information);
//        informationText.setText(information);
//        Button tryAgainButton = view.findViewById(R.id.button_try_again);
//        tryAgainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mListener != null) {
//                    mListener.onTryAgainButtonClicked("Biodata");
//                }
//            }
//        });
//        return  view;
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView information = view.findViewById(R.id.text_information);
        Bundle data = this.getArguments();

        Biodata2 biodata = data.getParcelable("biodata");
        String text = biodata.getNama()+", anda perlu membayar sejumlah Rp."+biodata.getIndex();
        information.setText(text);
        Button tryAgainButton = view.findViewById(R.id.button_try_again);
        Fragment home = new HomeFragment();
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                .getSupportFragmentManager().beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, home);
                fragmentTransaction.commit();
            }
        });
        return view;

    }
//
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void onTryAgainButtonClicked(String biodata);
    }
}
