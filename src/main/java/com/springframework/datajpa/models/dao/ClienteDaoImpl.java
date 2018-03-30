package com.springframework.datajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springframework.datajpa.models.entity.Cliente;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		//Este if significa que se o cliente tem ID e obtido da Base de dados e seria para 
		// atualizar os dados, senão e um novo cliente para add na BD e vai vir com id null
		if(cliente.getId() != null && cliente.getId() > 0){
			em.merge(cliente);
		}else{
			em.persist(cliente);
		}
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class,id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
