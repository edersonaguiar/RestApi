package com.example.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll(Pageable pageable) {
		return repository.findAllByOrderByNameAsc(pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);

	}

	@PostMapping("/id")
	public Customer saveClient(@Valid @RequestBody Customer customer) {
		return repository.save(customer);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);

	}

	@PutMapping("/{id}")
	public <Customer> Object atualizar(@PathVariable Long id, @Valid @RequestBody Customer customer) {
		Customer existente = (Customer) repository.findById(id);

		return existente;
	}
}