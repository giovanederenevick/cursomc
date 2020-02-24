package com.giovanederenevick.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanederenevick.cursomc.domain.Cliente;
import com.giovanederenevick.cursomc.repositories.ClienteRepository;
import com.giovanederenevick.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id){
		
		Optional<Cliente> obj = clienteRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}