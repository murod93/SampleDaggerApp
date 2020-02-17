package uz.minmax.sampledaggerapp.data.local.repository

import androidx.lifecycle.LiveData
import uz.minmax.sampledaggerapp.data.models.Customer

interface CustomerRepository {
    suspend fun getAll(): List<Customer>
//    suspend fun insert(customer: Customer)
//    suspend fun insert(vararg customer: Customer)
//    suspend fun delete(customer: Customer)
////    suspend fun deleteAll()
//    suspend fun update(customer: Customer)
}