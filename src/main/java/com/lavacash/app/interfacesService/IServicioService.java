package com.lavacash.app.interfacesService;

import com.lavacash.app.domain.ServicioJPA;
import java.util.List;
import java.util.Optional;

public interface IServicioService {
    public List<ServicioJPA> obtener ();
    public Optional<ServicioJPA> obtenerPorId (int id);
    public int guardar (ServicioJPA servicio);
    public void eliminar (int id);
}