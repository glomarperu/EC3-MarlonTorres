package com.idat.Examen3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Examen3.modelo.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
	

}
