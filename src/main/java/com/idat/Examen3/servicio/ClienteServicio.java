package com.idat.Examen3.servicio;

import java.util.List;

import com.idat.Examen3.dto.ClienteDTOrequest;
import com.idat.Examen3.dto.ClienteDTOresponse;

public interface ClienteServicio {
	
	public void guardarCliente(ClienteDTOrequest cliente);
	public void editarCliente(ClienteDTOrequest cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteDTOresponse> listarClientes();
	public ClienteDTOresponse obtenerClienteId(Integer id);
}
