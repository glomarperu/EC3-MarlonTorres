package com.idat.Examen3.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Examen3.dto.UsuarioDTOrequest;
import com.idat.Examen3.dto.UsuarioDTOresponse;
import com.idat.Examen3.seguridad.JwtUtil;
import com.idat.Examen3.seguridad.UserDetailService;

@RestController
public class UsuarioControlador {
	
	@Autowired
	private JwtUtil util;
	@Autowired
	private UserDetailService service;
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearTokenn(@RequestBody UsuarioDTOrequest dto){
		UserDetails details = service.loadUserByUsername(dto.getUsuario());
		
		return ResponseEntity.ok(new UsuarioDTOresponse(util.generateToken(details.getUsername())));
	}
}
