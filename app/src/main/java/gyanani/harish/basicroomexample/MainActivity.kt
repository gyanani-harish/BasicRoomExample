package gyanani.harish.basicroomexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import gyanani.harish.basicroomexample.database.AppDatabase
import gyanani.harish.basicroomexample.database.entity.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            AppDatabase.getInstance(this@MainActivity).userDao()
                .insertAll(listOf(User(findViewById<TextInputEditText>(R.id.editText).text.toString())))
            val userList = AppDatabase.getInstance(this@MainActivity).userDao().all
            if (userList.isEmpty()) {
                return@setOnClickListener
            }
            findViewById<TextView>(R.id.txtAllUsers).text = userList.map {
                it.name
            }.joinToString(separator = ", ")
        }
    }
}