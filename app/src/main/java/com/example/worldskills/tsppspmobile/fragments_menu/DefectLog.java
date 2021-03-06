package com.example.worldskills.tsppspmobile.fragments_menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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
 * {@link DefectLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DefectLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DefectLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Conexion conn;
    SQLiteDatabase bd;
    int posicion1, posicion2, posicion3;
    ArrayList arrayType, arrayInjected, arrayRemoved;
    Button btnDate, btnStartDefect, btnStopDefect, btnRestartDefect, btnRegistrar;
    Spinner listaType, listaInjected, listaRemoved;
    TextView campoDate, campoFixTime;
    EditText campoDefectDescription;

    String typeR;
    String phaseInjectedR;
    String phaseRemovedR;
    String dateR;
    String fixTimeR;
    String defectDescriptionR;
    CountDownTimer timer;
    int tiempoReal = 0, pausa, tiempoMinutos = 0;
    boolean start = false, restart, stop;

    public DefectLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DefectLog.
     */
    // TODO: Rename and change types and number of parameters
    public static DefectLog newInstance(String param1, String param2) {
        DefectLog fragment = new DefectLog();
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
        View vista = inflater.inflate(R.layout.fragment_defect_log, container, false);
        arrayType = new ArrayList();
        conn = new Conexion(getContext(), "TSP", null, 1);
        arrayType.add("Type");
        arrayType.add("Documentation");
        arrayType.add("Syntax");
        arrayType.add("Build");
        arrayType.add("Pakage");
        arrayType.add("Assigment");
        arrayType.add("Interface");
        arrayType.add("Checking");
        arrayType.add("Data");
        arrayType.add("Function");
        arrayType.add("System");
        arrayType.add("Environment");

        arrayInjected = new ArrayList();
        arrayInjected.add("Phase injected");
        arrayInjected.add("PLAN");
        arrayInjected.add("DLD");
        arrayInjected.add("CODE");
        arrayInjected.add("COMPILE");
        arrayInjected.add("UT");
        arrayInjected.add("PM");

        arrayRemoved = new ArrayList();
        arrayRemoved.add("Phase removed");
        arrayRemoved.add("PLAN");
        arrayRemoved.add("DLD");
        arrayRemoved.add("CODE");
        arrayRemoved.add("COMPILE");
        arrayRemoved.add("UT");
        arrayRemoved.add("PM");


        listaType = vista.findViewById(R.id.spinnerType);
        listaInjected = vista.findViewById(R.id.spinnerInjected);
        listaRemoved = vista.findViewById(R.id.spinnerRemoved);

        ArrayAdapter<CharSequence> adapterType = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayType);
        ArrayAdapter<CharSequence> adapterInjected = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayInjected);
        ArrayAdapter<CharSequence> adapterRemoved = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayRemoved);

        listaType.setAdapter(adapterType);
        listaInjected.setAdapter(adapterInjected);
        listaRemoved.setAdapter(adapterRemoved);

        listaType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    typeR = arrayType.get(position).toString();
                    posicion1 = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listaInjected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    phaseInjectedR = arrayInjected.get(position).toString();
                    posicion2 = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listaRemoved.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    phaseRemovedR = arrayRemoved.get(position).toString();
                    posicion3 = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        campoDate = vista.findViewById(R.id.campoDateDefect);
        btnDate = vista.findViewById(R.id.btnDateDefect);
        btnStartDefect = vista.findViewById(R.id.btnStartDefect);
        btnStopDefect = vista.findViewById(R.id.btnStopDefect);
        btnRegistrar = vista.findViewById(R.id.btnRegistrarDefect);
        campoFixTime = vista.findViewById(R.id.campoFixtime);
        campoDefectDescription = vista.findViewById(R.id.campoDefectDescription);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registratDefect();
            }
        });
        btnRestartDefect = vista.findViewById(R.id.btnRestartDefect);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignar();
                restart = true;
            }
        });

        btnStopDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start == true) {
                    stop = true;
                    timer.cancel();
                    pausa = tiempoReal;
                    campoFixTime.setText(" "+ tiempoReal + " Segundos");
                } else {
                    Toast.makeText(getContext(), "Inicie el tiempo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRestartDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start == true) {
                    tiempoReal = 0;
                    start = false;
                    campoFixTime.setText(" " + 0);
                    timer.cancel();
                } else {
                    Toast.makeText(getContext(), "Inicie el tiempo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStartDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start == true) {
                    if (stop == true) {
                        timer.start();
                        tiempoReal = pausa;
                        stop = false;
                    }
                } else {
                    empezarTiempo();
                    start = true;
                }
            }
        });
        return vista;
    }

    private void empezarTiempo() {
        timer = new CountDownTimer(200000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoReal++;
                campoFixTime.setText(" " + tiempoReal + " Segundos");
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

    private void registratDefect() {
        bd = conn.getWritableDatabase();
        if (posicion1 == 0 || posicion2 == 0 || posicion3 == 0 || campoDefectDescription.getText().toString().equals("") || start == false || restart == false || tiempoReal < 60) {
            Toast.makeText(getContext(), "Verifique que los campos estan llenos o que el tiempo sea mayor a 60 ", Toast.LENGTH_SHORT).show();
        } else {

            ContentValues values = new ContentValues();

            values.put(Utilidades.CAMPO_ID_TIME, ProjectPrincipal.id);
            values.put(Utilidades.CAMPO_DATE, campoDate.getText().toString());
            values.put(Utilidades.CAMPO_TYPE, typeR);
            values.put(Utilidades.CAMPO_PAHESE_INJECTED, phaseInjectedR);
            values.put(Utilidades.CAMPO_PHASE_REMOVE, phaseRemovedR);
            values.put(Utilidades.CAMPO_FIX, tiempoReal/60);
            values.put(Utilidades.CAMPO_DEFECT_DESCRIPTION, campoDefectDescription.getText().toString());

            bd.insert(Utilidades.TABLA_TIME_LOG, Utilidades.CAMPO_ID_TIME, values);
            Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    private void limpiar() {
        campoDate.setText(null);
        campoFixTime.setText("0");
        campoDefectDescription.setText(null);
    }

    private void asignar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        dateR = fecha;
        campoDate.setText(fecha);
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
