package com.example.api.web.rest;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	CustomerService serv = new CustomerService(null);
	
	public CustomerService service;
	
	

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	@PostMapping
	public Customer saveClient(@RequestBody Customer Customer) {
		return serv.saveClient(Customer);
	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		serv.delete(id);
	 }
	
	@PutMapping ("/{id}")
	public  Customer  atualizar ( @PathVariable  Long  id ,
			@Valid  @RequestBody  Customer  customer ) {
		return (Customer) serv.atualizar(id, customer);
	}

}
