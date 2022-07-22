package com.idat.Examen3.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen3.dto.HospitalDTOrequest;
import com.idat.Examen3.dto.HospitalDTOresponse;
import com.idat.Examen3.modelo.Hospital;
import com.idat.Examen3.repositorio.HospitalRepo;

@Service
public class HospitalServicioImpl implements HospitalServicio {

	@Autowired
	public HospitalRepo repositorio;
	
	@Override
	public void guardarHospital(HospitalDTOrequest hospital) {
		Hospital obj = new Hospital();
		obj.setIdHospital(hospital.getIdHospitalDTO());
		obj.setNombre(hospital.getNombreDTO());
		obj.setDescripcion(hospital.getDescripcionDTO());
		obj.setDistrito(hospital.getDistritoDTO());
		
		repositorio.save(obj);

	}

	@Override
	public void editarHospital(HospitalDTOrequest hospital) {
		Hospital obj = new Hospital();
		obj.setIdHospital(hospital.getIdHospitalDTO());
		obj.setNombre(hospital.getNombreDTO());
		obj.setDescripcion(hospital.getDescripcionDTO());
		obj.setDistrito(hospital.getDistritoDTO());
		
		repositorio.saveAndFlush(obj);

	}

	@Override
	public void eliminarHospital(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<HospitalDTOresponse> listarHospitales() {
		List<HospitalDTOresponse> lista = new ArrayList<HospitalDTOresponse>();
		HospitalDTOresponse obj = null;
		
		for(Hospital hospital : repositorio.findAll()) {
			obj = new HospitalDTOresponse();
			obj.setIdHospitalDTO(hospital.getIdHospital());
			obj.setNombreDTO(hospital.getNombre());
			obj.setDescripcionDTO(hospital.getDescripcion());
			obj.setDistritoDTO(hospital.getDistrito());
			
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public HospitalDTOresponse obtenerHospitalId(Integer id) {
		
		Hospital hospital= repositorio.findById(id).orElse(null);
		
		HospitalDTOresponse obj = new HospitalDTOresponse();
		obj.setIdHospitalDTO(hospital.getIdHospital());
		obj.setNombreDTO(hospital.getNombre());
		obj.setDescripcionDTO(hospital.getDescripcion());
		obj.setDistritoDTO(hospital.getDistrito());		
		
		return obj;
	}

}
