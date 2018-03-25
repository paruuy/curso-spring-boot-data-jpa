package com.springframework.datajpa.models.dao;

import java.util.List;

import com.springframework.datajpa.models.entity.Cliente;

public interface IClienteDao {
	public List<Cliente> findAll();
}
