package com.drivemech.Ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drivemech.Data.Overview
import com.drivemech.Data.Service
import com.drivemech.R
import com.drivemech.Ui.Adapter.OverviewAdapter
import com.drivemech.Ui.Adapter.ServiceAdapter
import com.drivemech.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var gridRecycler: RecyclerView
    private lateinit var serviceRecycler: RecyclerView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        gridRecycler = findViewById(R.id.gridRecycler)
        serviceRecycler = findViewById(R.id.serviceRecycler)
        bottomNav = findViewById(R.id.bottom_navigation)
        fab = findViewById(R.id.fab)

        setupOverviewGrid()
        setupServiceList()
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.nav_orders -> Toast.makeText(this, "Orders", Toast.LENGTH_SHORT).show()
                R.id.nav_employee -> Toast.makeText(this, "Employee", Toast.LENGTH_SHORT).show()
                R.id.nav_menu -> Toast.makeText(this, "Menu", Toast.LENGTH_SHORT).show()
            }
            true
        }

        fab.setOnClickListener {
            Toast.makeText(this, "In Progress..", Toast.LENGTH_SHORT).show()
        }

     binding.txtweely.setOnClickListener {
         Toast.makeText(this, "In Progress..", Toast.LENGTH_SHORT).show()
     }

     binding.txtviewall.setOnClickListener {
         Toast.makeText(this, "In Progress..", Toast.LENGTH_SHORT).show()
     }


    }
        private fun setupOverviewGrid() {
            val overviewItems = listOf(
                Overview("Under Servicing", "10", R.drawable.vector),
                Overview("Next Day Delivery", "5", R.drawable.employee),
                Overview("Test Drive", "5", R.drawable.driving),
                Overview("Ready For Delivery", "5", R.drawable.truck),
                Overview("Gate Pass Issued", "5", R.drawable.parking),
                Overview("Cancelled", "2", R.drawable.close)
            )

            gridRecycler.layoutManager = GridLayoutManager(this, 2)
            gridRecycler.adapter = OverviewAdapter(overviewItems)
        }

        private fun setupServiceList() {
            val serviceItems = listOf(
                Service(
                    "123456789",
                    "Ramesh Babu",
                    "Baleno-2020",
                    "Periodic Service",
                    "Oct 13, 2024",
                    "3:00 PM - 5:00 PM"
                ),
                Service("987654321", "John Doe", "Swift-2021", "Engine Check", "Oct 14, 2024", "11:00 AM - 12:00 PM")
            )

            serviceRecycler.layoutManager = LinearLayoutManager(this)
            serviceRecycler.adapter = ServiceAdapter(serviceItems)
        }
    }