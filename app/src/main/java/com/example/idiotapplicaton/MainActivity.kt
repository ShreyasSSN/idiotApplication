package com.example.idiotapplicaton

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var text3: TextView
    lateinit var text4: TextView
    lateinit var text5: TextView
    lateinit var yesButton: Button
    lateinit var noButton: Button
    lateinit var toolbar : MaterialToolbar
    lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.textView1)
        text2 = findViewById(R.id.textView2)
        text3 = findViewById(R.id.textView3)
        text4 = findViewById(R.id.textView4)
        text5 = findViewById(R.id.textView5)
        toolbar = findViewById(R.id.toolBar)
        mainLayout = findViewById(R.id.mainLayout)

        toolbar.overflowIcon = AppCompatResources.getDrawable(this, R.drawable.baseline_expand_more_24)

        toolbar.setNavigationOnClickListener{
            Toast.makeText(applicationContext, "navigation Icon Clicked", Toast.LENGTH_SHORT).show()
        }
        toolbar.setOnMenuItemClickListener{item ->

            when(item.itemId){
                R.id.share -> Toast.makeText(applicationContext, "Share is clicked", Toast.LENGTH_SHORT).show()
                R.id.edit -> Toast.makeText(applicationContext, "Edit is clicked", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(applicationContext, "Settings is clicked", Toast.LENGTH_SHORT).show()
                R.id.signOut -> Toast.makeText(applicationContext, "Sign Out is clicked", Toast.LENGTH_SHORT).show()
            }

            return@setOnMenuItemClickListener true
        }


        var txtView = arrayOf(text2, text3, text4)
        yesButton = findViewById(R.id.yes)
        noButton = findViewById(R.id.no)

        var idiotString  = arrayOf("Think again", "I know \nyou are an idiot", "you \naaaarrrrreeeeee\n an idiot", "I have whole day,\n tell correctly")
        var yesString = "Hahaha, I knew it"
        noButton.setOnClickListener {
                text1.text = ""
                text2.text = ""
                text3.text = ""
                text4.text = ""
                var textN = (idiotString.indices).random()
                var viewN = (txtView.indices).random()
                txtView[viewN].text = idiotString[textN]
        }
        yesButton.setOnClickListener {
                text1.text = ""
                text2.text = ""
                text3.text = ""
                text4.text = ""
                text5.text = yesString
                noButton.isVisible = false
                Snackbar.make(mainLayout, "Hahaha, You accepted...!!!!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Close",
                    View.OnClickListener {
                        showAlertDialog()

                }).show()
        }
    }

    fun showAlertDialog(){
        var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("IDIOT")
            .setMessage("Hahaha, You are an Idiot Finally")
            .setIcon(R.drawable.round_sports_martial_arts_24)
            .setNegativeButton("Yes", DialogInterface.OnClickListener{dialogInterface, which ->

                noButton.isVisible = true
                text5.text = ""
                text1.text = "We start again, are you an Idiot.?"
            })
            .setPositiveButton("Definitely, Yes", DialogInterface.OnClickListener { dialogInterface, which ->
                noButton.isVisible = true
                text5.text = ""
                text1.text = "We start again, are you an Idiot.?"

            })
        alertDialog.create().show()
    }
}