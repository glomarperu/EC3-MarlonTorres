package com.idat.Examen3.servicio;

import java.util.List;

import com.idat.Examen3.dto.HospitalDTOrequest;
import com.idat.Examen3.dto.HospitalDTOresponse;

public interface HospitalServicio {
	
	public void guardarHospital(HospitalDTOrequest hospital);
	public void editarHospital(HospitalDTOrequest hospital);
	public void eliminarHospital(Integer id);
	public List<HospitalDTOresponse> listarHospitales();
	public HospitalDTOresponse obtenerHospitalId(Integer id);
}
