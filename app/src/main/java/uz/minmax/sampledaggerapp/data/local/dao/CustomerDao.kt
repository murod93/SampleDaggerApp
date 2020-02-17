package uz.minmax.sampledaggerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.minmax.sampledaggerapp.data.models.Customer

@Dao
interface CustomerDao//: BaseDao<Customer> {
{
    @Query("select * from customer_table order by name ASC")
    fun getCustomers(): List<Customer>

//    @Query("delete from customer_table")
//    suspend fun deleteAll()
}