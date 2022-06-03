package pe.edu.ulima.pm.gestorpeliculas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.gestorpeliculas.R
import pe.edu.ulima.pm.gestorpeliculas.Pelicula

class listarpeliculas(private val mlistapeliculas: List<Pelicula>, private val mOnItemClickListener: (pelicula : Pelicula)-> Unit) : RecyclerView.Adapter<listarpeliculas.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val peliculasdatos: View =view.findViewById(R.id.peliculas)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate( R.layout.itempelicula, parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val nombre_pelicula= viewHolder.peliculasdatos.findViewById<TextView>(R.id.peliculaname)
        val horario_pelicula= viewHolder.peliculasdatos.findViewById<TextView>(R.id.peliculahora)
        nombre_pelicula.text= mlistapeliculas[position].nombre
        horario_pelicula.text = mlistapeliculas[position].hora

        viewHolder.itemView.setOnClickListener{
            mOnItemClickListener(mlistapeliculas[position])
        }

    }

    override fun getItemCount() = mlistapeliculas.size

}

