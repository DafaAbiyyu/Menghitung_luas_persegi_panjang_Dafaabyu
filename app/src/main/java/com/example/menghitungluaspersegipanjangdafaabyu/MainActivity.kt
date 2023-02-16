package com.example.menghitungluaspersegipanjangdafaabyu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val panjang = findViewById<EditText>(R.id.et_panjang)
        val lebar = findViewById<EditText>(R.id.et_Tinggi)
        val hitung = findViewById<Button>(R.id.id_hitung)
        val refres = findViewById<ImageView>(R.id.refresh)
        val luas = findViewById<RadioButton>(R.id.rb_luas)
        val keliling = findViewById<RadioButton>(R.id.rb_keliling)

        val data = ArrayList<Dataangka>()
        recyclerView = findViewById(R.id.listData)

        hitung.setOnClickListener {
            val panjang  = panjang.text.toString().toInt()
            val lebar = lebar.text.toString().toInt()

            if (luas.isChecked){
                val hasil = panjang * lebar
                hasil.toString()

                val menampilkan_keAdapter = Dataangka(hasil)
                data.add(menampilkan_keAdapter)
                recyclerAdapter.notifyDataSetChanged()

            } else if (keliling.isChecked){
                val hasil = (panjang * 2) + (lebar * 2)
                hasil.toString()

                val menampilkan_keAdapter = Dataangka(hasil)
                data.add(menampilkan_keAdapter)
                recyclerAdapter.notifyDataSetChanged()

            } else {
               Toast.makeText(this," Sampean dereng milih opsi",Toast.LENGTH_SHORT).show()
            }

        }
        refres.setOnClickListener {
            panjang.setText("")
            lebar.setText("")
        }
        recyclerAdapter = AdapterPersegi(data)
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = layoutManager
    }
}