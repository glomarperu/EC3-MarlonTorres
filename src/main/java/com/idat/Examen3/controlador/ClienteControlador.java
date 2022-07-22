package com.idat.Examen3.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Examen3.dto.ClienteDTOrequest;
import com.idat.Examen3.dto.ClienteDTOresponse;
import com.idat.Examen3.servicio.ClienteServicio;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTOresponse>> listarCliente(){
		return new ResponseEntity<List<ClienteDTOresponse>>(servicio.listarClientes(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTOrequest cliente){
		
		servicio.guardarCliente(cliente);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
		
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ClienteDTOresponse> listarCliId(@PathVariable Integer id) {
		ClienteDTOresponse c = servicio.obtenerClienteId(id);
		if(c != null)
			return new ResponseEntity<ClienteDTOresponse>(c, HttpStatus.OK);
		
		return new ResponseEntity<ClienteDTOresponse>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteDTOrequest cliente){
		ClienteDTOresponse c = servicio.obtenerClienteId(cliente.getIdClienteDTO());
		if(c != null) {
			servicio.editarCliente(cliente);
			return new ResponseEntity<Void> (HttpStatus.CREATED);
		}
		return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ClienteDTOresponse c = servicio.obtenerClienteId(id);
		
		if(c != null) {
			servicio.eliminarCliente(id);
			return new ResponseEntity<Void> (HttpStatus.CREATED);
		}
		return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
	}
}
