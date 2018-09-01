package com.example.worldskills.tsppspmobile.entidades;

import com.example.worldskills.tsppspmobile.fragments_menu.DefectLog;
import com.example.worldskills.tsppspmobile.fragments_menu.TimeLog;
import com.example.worldskills.tsppspmobile.fragments_sumary.PhaseInjected;
import com.example.worldskills.tsppspmobile.fragments_sumary.PhaseRemoved;
import com.example.worldskills.tsppspmobile.fragments_sumary.TimeInPhase;


//interfacae donde se hace el
public interface AllFragments extends
        DefectLog.OnFragmentInteractionListener,
        TimeLog.OnFragmentInteractionListener,
        PhaseInjected.OnFragmentInteractionListener,
        PhaseRemoved.OnFragmentInteractionListener,
        TimeInPhase.OnFragmentInteractionListener{
}
