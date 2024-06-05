package com.example.mc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mc.databinding.ActivityHomeBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Home : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

//    private lateinit var firebaseAuth: FirebaseAuth
private lateinit var user : FirebaseAuth
    private lateinit var dataRecyclerView: RecyclerView


    private lateinit var  bacaanAdapter: madapter

    private lateinit var listFilm: MutableList<DataFilm>
    private  var  mStorage: FirebaseStorage? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()
        dataRecyclerView = findViewById(R.id.filmList)

        dataRecyclerView.setHasFixedSize(true)
        dataRecyclerView.layoutManager = LinearLayoutManager(this@Home)
        binding.myDataLoaderprogressBar.visibility = View.VISIBLE

        listFilm = ArrayList()
        bacaanAdapter = madapter(this@Home,listFilm)
        dataRecyclerView.adapter = bacaanAdapter


        mStorage = FirebaseStorage.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("film")

        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener{

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Home,error.message, Toast.LENGTH_SHORT).show()
                binding.myDataLoaderprogressBar.visibility = View.VISIBLE
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                listFilm.clear()
                for (teacherSnapshot in snapshot.children){
                    val  upload = teacherSnapshot.getValue(DataFilm::class.java)
                    upload!!.key = teacherSnapshot.key
                    listFilm.add(upload)
                }
                bacaanAdapter.notifyDataSetChanged()
                binding.myDataLoaderprogressBar.visibility = View.GONE
            }

        })
        binding.Logout.setOnClickListener {
            user.signOut()

            Intent(this,  MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }

        }

    }


//        filmGambar = arrayOf(
//            R.drawable.av,
//            R.drawable.bat,
//            R.drawable.blac,
//            R.drawable.iron,
//            R.drawable.gr,
//            R.drawable.cp,
//            R.drawable.pool
//        )
//
//        filmJudul = arrayOf(
//            "Batman dan avatar",
//            "Batman dan avatar",
//            "Batman dan avatar",
//            "Batman dan avatar",
//            "Batman dan avatar",
//            "Batman dan avatar",
//            "Batman dan avatar"
//        )
//        filmDirector = arrayOf(
//            "Marvel disney ",
//            "Marvel disney ",
//            "Marvel disney ",
//            "Marvel disney ",
//            "Marvel disney ",
//            "Marvel disney ",
//            "Marvel disney "
//
//        )
//
//        filmActor = arrayOf(
//            "James Cameroon",
//            "James Cameroon",
//            "James Cameroon",
//            "James Cameroon",
//            "James Cameroon",
//            "James Cameroon",
//            "James Cameroon"
//        )
//
//        filmGender = arrayOf(
//            "Actioon comiand",
//            "Actioon comiand",
//            "Actioon comiand",
//            "Actioon comiand",
//            "Actioon comiand",
//            "Actioon comiand",
//            "Actioon comiand"
//
//        )
//
//        filmSinopsis = arrayOf(
//            getString(R.string.av),
//            getString(R.string.cp) ,
//            getString(R.string.bat) ,
//            getString(R.string.spid) ,
//            getString(R.string.gr) ,
//            getString(R.string.blac) ,
//            getString(R.string.pool)
//
//        )
//
//        filmRecyclerView = findViewById(R.id.filmList)
//        filmRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        listFilm = arrayListOf<DataFilm>()
//        getData()





    }

//    private fun getData() {
//        for (i in filmGambar.indices) {
//            val hasilFilm = DataFilm(filmGambar[i], filmJudul[i])
//            listFilm.add(hasilFilm)
//        }
//
//        var adapter = madapter(listFilm)
//        filmRecyclerView.adapter = adapter
//
//        adapter.setOnItemClickListener(object : madapter.onItemClickListener {
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@Home, Deskripsi::class.java)
//                intent.putExtra("idImage", listFilm[position].gambar)
//                intent.putExtra("idJdl", listFilm[position].judul)
//
//                intent.putExtra("idDirektor",filmDirector [position])
//                intent.putExtra("dtActor", filmActor[position])
//                intent.putExtra("idGender",filmGender [position])
//                intent.putExtra("idSynopsis",filmSinopsis [position])
//                startActivity(intent)
//
//
//            }
//
//        })
//


//    override fun onStart() {
//        super.onStart()
//        if (firebaseAuth.currentUser != null) {
//            Intent(this, MainActivity::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
//        }
//    }
