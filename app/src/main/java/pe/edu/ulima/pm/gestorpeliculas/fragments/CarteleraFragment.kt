package pe.edu.ulima.pm.gestorpeliculas.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.ulima.pm.gestorpeliculas.R
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.gestorpeliculas.Pelicula
import pe.edu.ulima.pm.gestorpeliculas.adapters.listarpeliculas
//import pe.edu.ulima.pm.gestorpeliculas.models.GestorPeliculas
import androidx.fragment.app.FragmentTransaction
import pe.edu.ulima.pm.gestorpeliculas.GestorPeliculas
class CarteleraFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartelera, container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragDetalles = masinformacion()
        fun recycle(): RecyclerView {
            val recyclerView = view.findViewById<RecyclerView> (R.id.peliculaslistas)

            val layoutManager = LinearLayoutManager(activity)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            return recyclerView
        }
        val nombre_usuario=arguments?.getString("Datos")
        val toolbarname= view.findViewById<TextView>(R.id.txtbienvenida)
        toolbarname.text="¡¡¡HOLAAAA " + nombre_usuario + "!!!"

        val listapeliculas= GestorPeliculas().obtenerPeliculas()
        val adapter = listarpeliculas(listapeliculas){
            val bundle= Bundle()
            bundle.putString("titulo", it.nombre)
            bundle.putString("informacion", it.resena)
            fragDetalles.arguments= bundle
            val ft=this.parentFragmentManager.beginTransaction()
            ft.replace(R.id.fcvSecciones,fragDetalles)
            ft.addToBackStack(null)
            ft.commit()
        }
        recycle().adapter = adapter

    }
}