package ind.shop.testapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ind.shop.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.exitButton.setOnClickListener{
            val builder1= AlertDialog.Builder(this)
            builder1.setTitle("Want To Exit")
            builder1.setMessage("Do You Really Want To Exit")
            builder1.setPositiveButton("Yes"){dialog, which->
                finish()
            }
                .setNegativeButton("No"){ dialog , which ->
                    dialog.dismiss()
                }
            builder1.show()
        }

        binding.yes.setOnClickListener{
            val intent= Intent(applicationContext, TestPage::class.java)
            startActivity(intent)
        }

        binding.no.setOnClickListener {
            finish()

        }



    }
}