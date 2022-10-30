package gyanani.harish.basicroomexample.observableExample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import gyanani.harish.basicroomexample.R
import gyanani.harish.basicroomexample.database.AppDatabase
import gyanani.harish.basicroomexample.database.entity.User

class LiveDataObservableActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeUserList()

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            AppDatabase.getInstance(this@LiveDataObservableActivity).userDao()
                .insertAll(listOf(User(findViewById<TextInputEditText>(R.id.editText).text.toString())))
        }
    }

    private fun observeUserList(){
        val userList = AppDatabase.getInstance(this@LiveDataObservableActivity).userDao().all
        userList.observe(this@LiveDataObservableActivity, object : Observer<List<User>> {
            override fun onChanged(userList: List<User>?) {
                Log.d("Room","LiveData")
                if (userList == null || userList.isEmpty()) {
                    return
                }
                val value = userList.joinToString(separator = ", ") {
                    it.name
                }
                Log.d("Room", "LiveData value=$value")
                findViewById<TextView>(R.id.txtAllUsers).text =
                    userList.joinToString(separator = ", ") {
                        it.name
                    }
            }

        })

    }
}