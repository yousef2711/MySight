package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yousef.mysight00.R
import com.yousef.mysight00.ui.adapter.DaysAdapter
import com.yousef.mysight00.ui.adapter.TaskAdapter
import com.yousef.mysight00.ui.model.TaskModel
import java.text.SimpleDateFormat
import java.util.*

class TasksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasks, container, false)

        // 🔹 إعداد RecyclerView للأيام (أفقي)
        val rvDays = view.findViewById<RecyclerView>(R.id.recyclerViewDays)
        rvDays.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val daysList = generateDays()
        println("📆 Days List: $daysList")

        val daysAdapter = DaysAdapter(daysList) { day ->
            println("🖱️ تم الضغط على اليوم: $day")
        }
        rvDays.adapter = daysAdapter

        // 🔹 إعداد RecyclerView للمهام (رأسي)
        val rvTasks = view.findViewById<RecyclerView>(R.id.recyclerViewTasks)
        rvTasks.layoutManager = LinearLayoutManager(requireContext())

        val taskList = listOf(
            TaskModel("Design Changes", "2 Days ago", false),
            TaskModel("Fix Bugs", "3 Days ago", true),
            TaskModel("Update UI", "1 Day ago", false)
        )

        val taskAdapter = TaskAdapter(taskList)
        rvTasks.adapter = taskAdapter

        return view
    }

    // 🔹 توليد الأيام القادمة
    private fun generateDays(): List<String> {
        val calendar = Calendar.getInstance()
        val days = mutableListOf<String>()
        val format = SimpleDateFormat("d", Locale.getDefault())

        for (i in 1..7) {
            val day = format.format(calendar.time)
            println("✅ Generated Day: $day")
            days.add(day)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return days
    }
}
