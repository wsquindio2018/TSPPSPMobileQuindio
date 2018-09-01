package com.example.worldskills.tsppspmobile.fragments_menu;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.entidades.ProjectPrincipal;
import com.example.worldskills.tsppspmobile.utilidades.Conexion;
import com.example.worldskills.tsppspmobile.utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TimeLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimeLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Variables y componentes

    Conexion conn;
    SQLiteDatabase bd;

    Spinner listaPhase;
    ArrayList arrayPhase;
    Button registrar, btnStart, btnStop;
    TextView campoDelta, campoStart, campoStop;
    EditText campoInterruption, campoComments;
    int posicion;

    String phaseR;
    String deltaR;
    String startR;
    String stopR;
    String commentsR;

    String delta1;
    String delta2;
    String interruptionR;

    boolean clic1 = false, clic2 = false;
    int tiempoTotal, datto3;

    public TimeLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeLog.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeLog newInstance(String param1, String param2) {
        TimeLog fragment = new TimeLog();
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
        View vista = inflater.inflate(R.layout.fragment_time_log, container, false);
        conn = new Conexion(getContext(), "TSP", null, 1);
        arrayPhase = new ArrayList();
        arrayPhase.add("Seleccione una fase");
        arrayPhase.add("PLAN");
        arrayPhase.add("DLD");
        arrayPhase.add("CODE");
        arrayPhase.add("COMPILE");
        arrayPhase.add("UT");
        arrayPhase.add("PM");

        campoStart = vista.findViewById(R.id.campoStartTime);
        campoStop = vista.findViewById(R.id.campoStopTime);
        campoComments = vista.findViewById(R.id.campoCommentsTime);
        campoDelta = vista.findViewById(R.id.campoDeltaTime);
        campoInterruption = vista.findViewById(R.id.campoInterruptionTime2);
        registrar = vista.findViewById(R.id.btnRegistrarTime);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturarDatos();
                registrarTime();
            }
        });
        btnStart = vista.findViewById(R.id.btnStartTime);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignar1();
                clic1 = true;
            }
        });
        btnStop = vista.findViewById(R.id.btnStopTime);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campoInterruption.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Debe llenar el campo Interrupcion", Toast.LENGTH_SHORT).show();
                } else {
                    asignar2();
                    clic2 = true;
                }
            }
        });
        listaPhase = vista.findViewById(R.id.spinnerPhase);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayPhase);
        listaPhase.setAdapter(adapter);
        listaPhase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    posicion = position;
                    phaseR = arrayPhase.get(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                phaseR = null;
            }
        });

        return vista;
    }

    private void capturarDatos() {
        startR = campoStart.getText().toString();
        stopR = campoStop.getText().toString();
        commentsR = campoComments.getText().toString();
        interruptionR = campoInterruption.getText().toString();
        deltaR = campoDelta.getText().toString();
    }

    private void asignar1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        SimpleDateFormat dat = new SimpleDateFormat("mm", Locale.getDefault());
        Date date = new Date();
        String fecha1 = dateFormat.format(date);
        delta1 = dat.format(date);
        campoStart.setText(fecha1);
    }

    private void asignar2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        SimpleDateFormat dat = new SimpleDateFormat("mm", Locale.getDefault());
        Date date = new Date();
        String fecha2 = dateFormat.format(date);
        delta2 = dat.format(date);
        campoStop.setText(fecha2);
        calcularDelta();
    }

    private void calcularDelta() {
        int dato1 = Integer.parseInt(delta1);
        int dato2 = Integer.parseInt(delta2);
        datto3 = Integer.parseInt(campoInterruption.getText().toString());
        tiempoTotal = ((dato2 - dato1)) - datto3;
        if (datto3 > tiempoTotal) {
            Toast.makeText(getContext(), "El campo interrupcion debe ser menor al tiempo de la fase", Toast.LENGTH_SHORT).show();
        } else {
            campoDelta.setText("" + tiempoTotal);
        }
    }


    private void registrarTime() {
        bd = conn.getWritableDatabase();
        if (posicion == 0 || campoInterruption.getText().toString().equals("") || clic1 == false || clic2 == false) {
            Toast.makeText(getContext(), "Verifique que los campos estan llenos", Toast.LENGTH_SHORT).show();
        } else {

            ContentValues values = new ContentValues();

            values.put(Utilidades.CAMPO_ID_TIME, ProjectPrincipal.id);
            values.put(Utilidades.CAMPO_PHASE, phaseR);
            values.put(Utilidades.CAMPO_INTERRUPTION, datto3);
            values.put(Utilidades.CAMPO_START, startR);
            values.put(Utilidades.CAMPO_STOP, stopR);
            values.put(Utilidades.CAMPO_DELTA, deltaR);
            values.put(Utilidades.CAMPO_COMMENTS, commentsR);

            bd.insert(Utilidades.TABLA_TIME_LOG, Utilidades.CAMPO_ID_TIME, values);
            Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }


    private void limpiar() {
        clic1 = false;
        clic2 = false;
        campoInterruption.setText(null);
        campoStop.setText(null);
        campoStart.setText(null);
        campoComments.setText(null);
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
