package com.springframework.datajpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.datajpa.models.dao.IClienteDao;
import com.springframework.datajpa.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	@Qualifier("clienteDaoJPA") //Se usa caso tengamos dos clases con la misma interfaz para no confundir
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true) //indica que el metodo es transaccional. Si era un insert/update seria sin readonly
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}	

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		return clienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.delete(id);
	}

}
