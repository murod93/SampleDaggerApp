package uz.minmax.sampledaggerapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.minmax.sampledaggerapp.data.models.Customer

@Dao
abstract class CustomerDao: BaseDao<Customer> {
    @Query("select * from customer_table order by name ASC")
    abstract fun getCustomers(): LiveData<List<Customer>>

    @Insert
    abstract fun insertAll(customers:List<Customer>)
}