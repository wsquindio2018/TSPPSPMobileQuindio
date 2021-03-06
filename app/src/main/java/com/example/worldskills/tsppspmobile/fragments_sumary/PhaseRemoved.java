package com.example.worldskills.tsppspmobile.fragments_sumary;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PhaseRemoved.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PhaseRemoved#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhaseRemoved extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    TextView tiempoPlan,tiempoDld,tiempoCode,tiempoCompile,tiempoUt,tiempoPm;
    TextView porcentajePlan,porcentajeDld,porcentajeCode,porcentajeCompile,porcentajeUt,porcentajePm;
    public PhaseRemoved() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhaseRemoved.
     */
    // TODO: Rename and change types and number of parameters
    public static PhaseRemoved newInstance(String param1, String param2) {
        PhaseRemoved fragment = new PhaseRemoved();
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
        View vista = inflater.inflate(R.layout.fragment_time_in_phase, container, false);

        //campios donde se muestra el tiempo transcurrido en cada fase

        tiempoPlan = vista.findViewById(R.id.planTiempo);
        tiempoDld = vista.findViewById(R.id.dldTiempo);
        tiempoCode = vista.findViewById(R.id.codeTiempo);
        tiempoCompile = vista.findViewById(R.id.compileTiempo);
        tiempoUt = vista.findViewById(R.id.utTiempo);
        tiempoPm = vista.findViewById(R.id.pmTiempo);

        porcentajePlan = vista.findViewById(R.id.planProcentaje);
        porcentajeDld = vista.findViewById(R.id.dldProcentaje);
        porcentajeCode = vista.findViewById(R.id.codeProcentaje);
        porcentajeCompile = vista.findViewById(R.id.compileProcentaje);
        porcentajeUt = vista.findViewById(R.id.utProcentaje);
        porcentajePm = vista.findViewById(R.id.pmProcentaje);


        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
