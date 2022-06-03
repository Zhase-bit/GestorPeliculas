package pe.edu.ulima.pm.gestorpeliculas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.gestorpeliculas.R

class masinformacion: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.masinformacion,
            container,
            false
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titulopelicula= arguments?.getString("titulo")
        val detallepelicula= arguments?.getString("informacion")

        val titulo= view.findViewById<TextView>(R.id.peliculatitulo)
        val informacion= view.findViewById<TextView>(R.id.peliculadetalles)
        val botonregresar = view.findViewById<Button>(R.id.btnretrocederinfo)

        titulo.text= titulopelicula
        informacion.text= detallepelicula

        botonregresar.setOnClickListener {
            val retroceder = this.parentFragmentManager
            retroceder.popBackStack()
        }

    }
}