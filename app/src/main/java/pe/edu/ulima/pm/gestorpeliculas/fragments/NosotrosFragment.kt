package pe.edu.ulima.pm.gestorpeliculas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.gestorpeliculas.R

class NosotrosFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nosotros, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val regresar = view.findViewById<Button>(R.id.buttonsomos)

        regresar.setOnClickListener{
            val atrasfragment= this.parentFragmentManager
            atrasfragment.popBackStack()
        }
    }
}