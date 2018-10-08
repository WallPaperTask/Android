package net.oldbigbuddha.taskwallpaper


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_check_image.*
import net.oldbigbuddha.taskwallpaper.Adapters.CheckAdapter
import net.oldbigbuddha.taskwallpaper.activities.MainActivity


/**
 * A simple [Fragment] subclass.
 * Use the [CheckImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CheckImageFragment : Fragment() {
    private lateinit var tasks: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            tasks = ArrayList()
            tasks.addAll(
                    parseToArray(it.getSharedPreferences(
                            it.packageName, Context.MODE_PRIVATE)
                            .getString(MainActivity.KEY, "[No Task]")
                    )
            )
        } ?: IllegalAccessException("Activity cannot be null")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_check_image, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_check)
        activity?.let {
            recycler.layoutManager = LinearLayoutManager(it)
            recycler.addOnItemTouchListener( DisableScroll() )
            recycler.adapter = CheckAdapter(tasks, it)
        } ?: IllegalAccessException("Activity cannot be null")

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckImageFragment.
         */
        fun newInstance(): CheckImageFragment = CheckImageFragment()
    }
}
