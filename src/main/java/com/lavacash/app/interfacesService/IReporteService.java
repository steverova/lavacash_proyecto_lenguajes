package com.lavacash.app.interfacesService;

import com.lavacash.app.domain.Reporte;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IReporteService {
    
    
    public List<Reporte> obtener ();
}