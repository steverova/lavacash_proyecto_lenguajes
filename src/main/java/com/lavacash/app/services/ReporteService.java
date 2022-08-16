package com.lavacash.app.services;

import com.lavacash.app.data.DataReporte;
import com.lavacash.app.domain.Reporte;
import com.lavacash.app.interfacesService.IReporteService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReporteService implements IReporteService{
    

    @Override
    public List<Reporte> obtener() {
        return new DataReporte().getSalas();
    }
}
