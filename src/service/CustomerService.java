package service;

import java.util.List;

import dao.CustomerDao;
import domain.Customer;

public class CustomerService {
	/**
	 * ±£´æ¿Í»§
	 * @param c
	 */
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}
	public List<Customer> findAll(){
		return new CustomerDao().findAll();
	} 
}
