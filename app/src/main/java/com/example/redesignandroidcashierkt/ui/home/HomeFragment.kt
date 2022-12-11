package com.example.redesignandroidcashierkt.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.redesignandroidcashierkt.databinding.FragmentHomeBinding
import com.example.redesignandroidcashierkt.pojo.ItemsModel
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    var arrayList: ArrayList<ItemsModel>? = null
    var list = ArrayList<ItemsModel>()
    var dialog: Dialog? = null
    var adabter: AdapterSales? = null
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {


            //  dataDoc = getIntent().getExtras().getInt("Stat",1);
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    //  Toast.makeText(ItemsActivity.this, "Swipe to delete", Toast.LENGTH_SHORT).show();
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    Snackbar.make(binding.billRecycler, "Deleted item", Snackbar.LENGTH_SHORT)
                        .setAction(list.get(viewHolder.adapterPosition).ItemName,
                            View.OnClickListener { }).show()
                    list.removeAt(viewHolder.adapterPosition)
                    adabter.notifyDataSetChanged()
                    var xx = 0.0
                    for (x in list.indices) {
                        xx = xx + list.get(x).balanc()
                    }
                    // Double  sa =  Double.valueOf(Totals.getText().toString().trim());
                    // Double xz=sa+s;
                    // Totals.setText(xz+"");
                    binding.Totals.setText(xx.toString() + "")
                    adabter.notifyItemInserted(list.size - 1)
                binding.billRecycler.scrollToPosition(list.size)
                    binding.billRecycler.setAdapter(adabter)
                }
            }).attachToRecyclerView( binding.billRecycler)
           binding.SearcheCode.setOnClickListener(View.OnClickListener {
                getItem(
                    textview.getText().toString()
                )
            })






        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}