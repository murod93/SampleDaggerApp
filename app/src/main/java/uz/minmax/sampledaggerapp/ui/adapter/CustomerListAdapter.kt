package uz.minmax.sampledaggerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.data.models.Customer

class CustomerListAdapter(
    private val listener:ICustomerClickListener,
    private val users:List<Customer>
) : RecyclerView.Adapter<CustomerListAdapter.ViewHolder>() {

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflateView = parent.inflate(R.layout.customer_list_item, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(users[position])
    }

    inner class ViewHolder(v:View): RecyclerView.ViewHolder(v) {

        private val nameView by lazy { v.findViewById(R.id.name_view) as TextView }
        private val descriptionView by lazy { v.findViewById(R.id.description_view) as TextView }

        fun bindItem(user: Customer){
            nameView.text = user.name
            descriptionView.text = user.job

            itemView.setOnClickListener {
                listener.onClickListener(it, user)
            }
        }
    }

    interface ICustomerClickListener{
        fun onClickListener(view:View, customer:Customer?)
    }
}