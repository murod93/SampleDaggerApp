package uz.minmax.sampledaggerapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import uz.minmax.sampledaggerapp.data.source.local.dao.CustomerDao
import uz.minmax.sampledaggerapp.data.models.Customer
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val customerDao: CustomerDao
): CustomerRepository {
    override suspend fun getAll(): LiveData<List<Customer>> {
        Log.e("CustomerRepository", "Customers ")
        return customerDao.getCustomers()
    }

    override suspend fun delete(customer: Customer) {
        customerDao.delete(customer)
    }

    override suspend fun insert(customer: Customer){
        Log.e("CustomerRepository", "Customer "+customer.name)
        customerDao.insert(customer)
    }

    override suspend fun update(customer: Customer){
        customerDao.update(customer)
    }
}