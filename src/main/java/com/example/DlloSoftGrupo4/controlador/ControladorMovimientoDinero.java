package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServicioMovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServiciosImpMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Map;

@RequestMapping("/MovimientoDinero")
@RestController

public class ControladorMovimientoDinero {


    @Autowired
    private ServicioMovimientoDinero smd;

    @GetMapping
    public List<MovimientoDinero> listar()  {
        return smd.listarMovimientoDinero();
    }


    @PostMapping
    public MovimientoDinero insertar(@RequestBody MovimientoDinero movDinero ){
        return  smd.guardarMovimientos(movDinero);
    }


    @PutMapping
    public MovimientoDinero actualizar(@RequestBody MovimientoDinero movDinero) {
        return smd.actualizarMovimientos(movDinero);
    }

    @DeleteMapping("/{id}")
    public void eliminarporId(@PathVariable("id") Integer id){
        smd.eliminarMovimientos(id);
    }

    @PatchMapping("/{id}")
    public MovimientoDinero actualizarpor(@PathVariable("id") Integer id, @RequestBody Map<Object,Object> objectMap){
        return smd.actualizarporID(id,objectMap);
    }


}