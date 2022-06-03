package pe.edu.ulima.pm.gestorpeliculas


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.gestorpeliculas.fragments.CarteleraFragment
import pe.edu.ulima.pm.gestorpeliculas.fragments.NosotrosFragment

class MainActivity : AppCompatActivity() {
    private lateinit var  mDlaMain : DrawerLayout
    private  lateinit var mNviMain: NavigationView
    private val fragmentNosotros  = NosotrosFragment()
    private val fragmentCartelera = CarteleraFragment()
    private lateinit var usertext: TextView
    private var user: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val bundle = intent.extras
        //val dato = bundle?.getString("Datos")
        //val navigationView : NavigationView = findViewById(R.id.nviMain)
        //val headerView : View = navigationView.getHeaderView(0)
        //val navUsername : TextView = headerView.findViewById(R.id.textname)
        //navUsername.text = "aeamano"
        setContentView(R.layout.activity_main)

        mDlaMain = findViewById(R.id.dlaMain)
        mNviMain = findViewById(R.id.nviMain)
        //val headerview : View = mNviMain.getHeaderView(0)
        //val username : TextView = headerview.findViewById(R.id.textname)
        //username.text = dato.toString()

        mNviMain.setNavigationItemSelectedListener {

            it.setChecked(true)
            val ft = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.cartelera -> MostrarCartelera(ft)
                R.id.nosotros -> MostrarNosotros(ft)
            }
            ft.addToBackStack(null)
            ft.commit()
            mDlaMain.closeDrawers()
            true
        }
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentCartelera)
        ft.commit()
        user = intent.getStringExtra("Datos")
        if (user!= ""){
            val bundle= Bundle()
            bundle.putString("Datos", user)
            fragmentCartelera.arguments= bundle
            usertext = mNviMain.getHeaderView(0).findViewById(R.id.textname)
            usertext.text=user
        }

    }
    private fun MostrarCartelera(ft: FragmentTransaction){
        ft.replace(R.id.fcvSecciones, fragmentCartelera)
    }
    private fun MostrarNosotros(ft: FragmentTransaction){
        ft.replace(R.id.fcvSecciones, fragmentNosotros)
    }

}