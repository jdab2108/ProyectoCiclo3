package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Empresa;
import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpresa;
import com.example.DlloSoftGrupo4.servicios.ServicioMovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServiciosImpMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Map;

@RequestMapping("/Empresa")
@RestController

public class ControladorMovimientoDinero {


    @Autowired
    private ServicioMovimientoDinero smd;

    @GetMapping("/MovimientoDinero/all")
    public List<MovimientoDinero> listar()  {
        return smd.listarMovimientoDinero();
    }

    @GetMapping ("/{codigo}/MovimientoDinero")
        public MovimientoDinero consultarMovimientoporNit(@PathVariable("codigo") Integer codigo){
        return smd.consultarMovimientosPorID(codigo);
    }



    @PostMapping("/MovimientoDinero")
    public MovimientoDinero insertar(@RequestBody MovimientoDinero movDinero ){
        return  smd.guardarMovimientos(movDinero);
    }


    @PutMapping("/MovimientoDinero")
    public MovimientoDinero actualizar(@RequestBody MovimientoDinero movDinero) {
        return smd.actualizarMovimientos(movDinero);
    }

    @DeleteMapping("/{codigo}/MovimientoDinero")
    public void eliminarporId(@PathVariable("codigo") Integer codigo){
        smd.eliminarMovimientos(codigo);

    }

    @PatchMapping("/{codigo}/MovimientoDinero")
    public MovimientoDinero actualizarpor(@PathVariable("codigo") Integer codigo, @RequestBody Map<Object,Object> objectMap){
        return smd.actualizarporID(codigo,objectMap);
    }


}