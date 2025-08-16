package ind.shop.testapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import ind.shop.testapp.databinding.ActivityMainBinding
import ind.shop.testapp.databinding.ActivityTestPageBinding
import ind.shop.testapp.databinding.FailBinding
import ind.shop.testapp.databinding.FullMarksBinding
import ind.shop.testapp.databinding.PassBinding

class TestPage : AppCompatActivity() {
    lateinit var dialog: Dialog
    companion object{
        const val submitkey="ind.shop.testapp.TestPage.submitkey1"
    }
    lateinit var binding: ActivityTestPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityTestPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val answers=arrayOf("Kotlin","Android Studio","ViewBinding",".SVG",".APK")
        var count=0

        binding.ans1.setOnClickListener {
            val options1=arrayOf("Java","Kotlin","C++")
            val builder1= AlertDialog.Builder(this)
            builder1.setTitle(binding.question1.text )
            builder1.setSingleChoiceItems(options1,-1) { dialog, which ->
                if (options1[which] == answers[0]) {
                    count++

                }

            }
                .setPositiveButton("Confirm"){dialog,which ->
                    dialog.dismiss()
                }


            builder1.show()
            binding.ans1.isEnabled=false

        }
        binding.ans2.setOnClickListener {
            val options2=arrayOf("Android Studio","Visual Studio Code","PyCharm")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle(binding.question2.text)
            builder2.setSingleChoiceItems(options2,-1){dialog,which->
                Snackbar.make(binding.root, "You selected: ${options2[which]}",
                    Snackbar.LENGTH_SHORT).show()
                if(options2[which] == answers[1]){
                    count++

                }

            }
                .setPositiveButton("Confirm"){dialog,which ->
                    dialog.dismiss()
                }
            builder2.show()
            binding.ans2.isEnabled=false
        }

        binding.ans3.setOnClickListener {
            val options3=arrayOf("It Can't Be Replaced","Nothing","ViewBinding")
            val builder3= AlertDialog.Builder(this)
            builder3.setTitle(binding.question3.text)
            builder3.setSingleChoiceItems(options3,-1){dialog,which->
                Snackbar.make(binding.root, "You selected: ${options3[which]}", Snackbar.LENGTH_SHORT).show()
                if(options3[which] == answers[2]) {
                    count++
                }
            }
                .setPositiveButton("Confirm"){dialog,which ->
                    dialog.dismiss()
                }
            builder3.show()
            binding.ans3.isEnabled=false
        }

        binding.ans4.setOnClickListener {
            val options4=arrayOf(".SVG",".PNG",".JPG")
            val builder4= AlertDialog.Builder(this)
            builder4.setTitle(binding.question4.text)
            builder4.setSingleChoiceItems(options4,-1){dialog,which->
                Snackbar.make(binding.root, "You selected: ${options4[which]}", Snackbar.LENGTH_SHORT).show()
                if(options4[which] == answers[3]) {
                    count++
                }

            }
                .setPositiveButton("Confirm"){dialog,which ->
                    dialog.dismiss()
                }
            builder4.show()
            binding.ans4.isEnabled=false
        }

        binding.ans5.setOnClickListener {
            val options5=arrayOf(".docx",".APK",".txt")
            val builder5= AlertDialog.Builder(this)
            builder5.setTitle(binding.question5.text)
            builder5.setSingleChoiceItems(options5,-1){dialog,which->
                Snackbar.make(binding.root, "You selected: ${options5[which]}", Snackbar.LENGTH_SHORT).show()
                if(options5[which] == answers[4]){
                    count++
                    }

            }
                .setPositiveButton("Confirm"){dialog,which ->
                    dialog.dismiss()
                }
            builder5.show()
            binding.ans5.isEnabled=false
        }

        binding.submitButton.setOnClickListener {
            var result=""
            if (count<=2){
                val dialogBinding = FailBinding.inflate(layoutInflater)
                dialog= Dialog(this)
                dialog.setContentView(dialogBinding.root)
                dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.dialog_style))
                dialog.window?.setLayout(1000,900)
                 result="You Failed Your Score Is $count/5"
                dialogBinding.resulttext.text="$result"
               dialogBinding.confirmButton.setOnClickListener {
                  val intent1= Intent(applicationContext,MainActivity::class.java)
                   startActivity(intent1)
                   dialog.dismiss()
                }
               dialog.show()

            }
            if (count>2){
                val dialogBinding = PassBinding.inflate(layoutInflater)
                dialog= Dialog(this)
                dialog.setContentView(dialogBinding.root)
                dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.dialog_style))
                dialog.window?.setLayout(1050,900)
                 result="You Passed Your Score Is $count/5"
                dialogBinding.resulttext.text="$result"
                dialogBinding.confirmButton.setOnClickListener {
                    val intent=Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                }
                dialog.show()
            }
            if (count>=5){
                result="You Topped Your Score Is $count/5"
                val dialogBinding= FullMarksBinding.inflate(layoutInflater)
                dialog= Dialog(this)
                dialog.setContentView(dialogBinding.root)
                dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.dialog_style))
                dialog.window?.setLayout(1000,900)
                dialogBinding.resulttext.text="$result"
                dialogBinding.confirmButton.setOnClickListener {
                    val intent= Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                }
                dialog.show()

            }

        }










    }

}