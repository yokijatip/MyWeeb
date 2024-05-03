package eastbound.yokijatiperkasa.myweeb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import eastbound.yokijatiperkasa.myweeb.databinding.ActivityMainBinding
import eastbound.yokijatiperkasa.myweeb.explore.ExploreFragment
import eastbound.yokijatiperkasa.myweeb.home.HomeFragment
import eastbound.yokijatiperkasa.myweeb.library.LibraryFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private fun fragmentManager(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, fragment, fragment.javaClass.simpleName)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Implementasi bottom Navigation Bar menggunakan Chip Bottom Navigation Bar
        fragmentTransaction()


    }

    private fun fragmentTransaction() {
        binding.apply {
            bottomNav.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
                override fun onItemSelected(id: Int) {
                    when(id) {
                        R.id.nav_home -> {
                            fragmentManager(HomeFragment.newInstance())
                        }
                        R.id.nav_explore -> {
                            fragmentManager(ExploreFragment.newInstance())
                        }
                        R.id.nav_library -> {
                            fragmentManager(LibraryFragment.newInstance())
                        }
                    }
                }

            })
        }
        fragmentManager(HomeFragment.newInstance())
        binding.bottomNav.setItemSelected(R.id.nav_home)
    }
}