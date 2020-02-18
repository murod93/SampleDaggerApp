package uz.minmax.sampledaggerapp.data.local.repository

import androidx.lifecycle.LiveData
import uz.minmax.sampledaggerapp.data.local.dao.CustomerDao
import uz.minmax.sampledaggerapp.data.models.Customer
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val customerDao: CustomerDao
):CustomerRepository{
    override suspend fun getAll(): LiveData<List<Customer>> {
        return customerDao.getCustomers()
    }

    override suspend fun insert(vararg customer: Customer) {
    }

    override suspend fun delete(customer: Customer) {
        customerDao.delete(customer)
    }

    override suspend fun insert(customer: Customer){
        customerDao.insert(customer)
    }

    override suspend fun update(customer: Customer){
        customerDao.update(customer)
    }
}