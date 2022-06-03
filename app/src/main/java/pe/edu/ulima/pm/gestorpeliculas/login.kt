package pe.edu.ulima.pm.gestorpeliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import pe.edu.ulima.pm.gestorpeliculas.fragments.CarteleraFragment

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bntsiguiente  = findViewById<Button>(R.id.btnsiguiente)
        val nameuser = findViewById<EditText>(R.id.txtname)

        bntsiguiente!!.setOnClickListener { v: View ->
            val username  : String = nameuser!!.text.toString()
            intent.setClass(this,MainActivity::class.java)
            val user = Bundle()
            user.putString("Datos",username)
            intent.putExtras(user)

            startActivity(intent)

        }
    }
}