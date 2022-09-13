package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;

import java.util.List;
import java.util.Map;

public interface ServicioMovimientoDinero {
    public List<MovimientoDinero>listarMovimientoDinero();
    public MovimientoDinero guardarMovimientos(MovimientoDinero movDinero);
    public MovimientoDinero consultarMovimientosPorID(Integer codigo);
    public MovimientoDinero actualizarMovimientos(MovimientoDinero movDinero);
    public void eliminarMovimientos(Integer codigo);
    public MovimientoDinero actualizarporID(Integer cod, Map<Object,Object> objectMap);
}
