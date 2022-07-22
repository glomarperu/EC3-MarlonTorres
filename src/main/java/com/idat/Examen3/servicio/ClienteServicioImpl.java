package com.idat.Examen3.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen3.dto.ClienteDTOrequest;
import com.idat.Examen3.dto.ClienteDTOresponse;
import com.idat.Examen3.modelo.Cliente;
import com.idat.Examen3.repositorio.ClienteRepo;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepo repositorio;
	
	@Override
	public void guardarCliente(ClienteDTOrequest cliente) {
		
		Cliente obj = new Cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setCliente(cliente.getClienteDTO());
		obj.setCelular(cliente.getCelularDTO());

		repositorio.save(obj);
	}

	@Override
	public void editarCliente(ClienteDTOrequest cliente) {
		Cliente obj = new Cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setCliente(cliente.getClienteDTO());
		obj.setCelular(cliente.getCelularDTO());

		repositorio.saveAndFlush(obj);

	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);;

	}

	@Override
	public List<ClienteDTOresponse> listarClientes() {

		List<ClienteDTOresponse> lista = new ArrayList<ClienteDTOresponse>();
		ClienteDTOresponse obj = null;
		
		for(Cliente cliente : repositorio.findAll()) {
			obj = new ClienteDTOresponse();
			obj.setIdClienteDTO(cliente.getIdCliente());
			obj.setClienteDTO(cliente.getCliente());
			obj.setCelularDTO(cliente.getCelular());
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public ClienteDTOresponse obtenerClienteId(Integer id) {
		Cliente cliente =  repositorio.findById(id).orElse(null);
		
		ClienteDTOresponse obj = new ClienteDTOresponse();
		obj.setIdClienteDTO(cliente.getIdCliente());
		obj.setClienteDTO(cliente.getCliente());
		obj.setCelularDTO(cliente.getCelular());
		
		return obj;
	}

}
