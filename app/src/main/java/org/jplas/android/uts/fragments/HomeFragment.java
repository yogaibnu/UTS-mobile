package org.jplas.android.uts.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jplas.android.uts.R;
import org.jplas.android.uts.util.Biodata;
import org.jplas.android.uts.util.Biodata2;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        final EditText namaText  = view.findViewById(R.id.input_nama);
        final EditText umurText  = view.findViewById(R.id.input_umur);
        final RadioGroup genderGroup = view.findViewById(R.id.group_gender);

//        Button submitButton = view.findViewById(R.id.btn_submit);
        Button btnSubmit = view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (namaText.length() == 0 || umurText.length() == 0 || genderGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity(), "Mohon untuk mengisi biodata dengan lengkap", Toast.LENGTH_SHORT).show();
                }else {
                    String namaString = namaText.getText().toString();
                    String umurString = umurText.getText().toString();
                    int checkedId = genderGroup.getCheckedRadioButtonId();
                    String nama = namaString;
                    int umur = Integer.parseInt(umurString);
                    int gender = (checkedId == R.id.radio_male) ? Biodata.MALE : Biodata.FEMALE;
                    Biodata2 biodata = new Biodata2(nama, gender, umur);
//                    mListener.onSubmitClicked(biodata.getIndex());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("biodata", biodata);
                    Fragment Result = new ResultFragment();
                    Result.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getActivity()
                            .getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, Result);
                    fragmentTransaction.commit();
                }
            }
        });
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mListener != null) {
//                    String namaString = namaText.getText().toString();
//                    String umurString = umurText.getText().toString();
//                    int checkedId = genderGroup.getCheckedRadioButtonId();
//                    if ((checkedId != -1) && !TextUtils.isEmpty(namaString) && !TextUtils.isEmpty(umurString)) {
//                        String nama = namaString;
//                        int umur = Integer.parseInt(umurString);
//                        int gender = (checkedId == R.id.radio_male) ? Biodata.MALE : Biodata.FEMALE;
//                        Biodata biodata = new Biodata(nama, umur, gender);
//                        mListener.onSubmitClicked(biodata.getIndex());
//                    } else {
//                        Toast.makeText(getActivity(), "Please select gender, input your name and age", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
        return view;
    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onSubmitClicked(float index);
//    }

}
