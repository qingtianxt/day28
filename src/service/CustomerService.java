package service;

import dao.CustomerDao;
import domain.Customer;

public class CustomerService {
	/**
	 * ����ͻ�
	 * @param c
	 */
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}
}
