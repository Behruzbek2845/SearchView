package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.searchview.adapters.MyAdapter
import com.example.searchview.databinding.ActivityMainBinding
import com.example.searchview.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<User>
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadData()
        myAdapter = MyAdapter(list)
        binding.rv.adapter = myAdapter

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val l = ArrayList<User>()
                for (user in list) {
                    if (user.name.lowercase().contains(newText!!.lowercase())){
                        l.add(user)
                    }
                }
                myAdapter = MyAdapter(l)
                binding.rv.adapter = myAdapter
                return true
            }
        })
    }

    private fun loadData() {
        list = ArrayList()
        list.add(User("Ali"))
        list.add(User("Behruzbek"))
        list.add(User("Umidjon"))
        list.add(User("Zohidjon"))
    }
}