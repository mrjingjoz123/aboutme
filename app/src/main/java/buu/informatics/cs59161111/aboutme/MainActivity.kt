package buu.informatics.cs59161111.aboutme


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.cs59161111.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val myName:MyName = MyName("Puvisz T Weang")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
           doneButton.setOnClickListener {
                addNickname(it)
            }

           nicknameText.setOnClickListener {
                updateNickname (it)
            }
           this.myName = this@MainActivity.myName
        }


    }
    private fun addNickname(view: View) {
        binding.apply {

            myName?.nickname =  nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            doneButton.visibility = View.GONE
            invalidateAll()

            //Hide Keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }



//        val doneButton = findViewById<Button>(R.id.done_button)
//        doneButton.visibility = View.GONE


    }
    private fun updateNickname (view: View) {
        binding.apply {
            nicknameText.visibility = View.GONE
            nicknameEdit.visibility = View.VISIBLE

            nameText.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }
    }
}
