package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/Empleado")
@RestController

public class ControladorEmpleado {


    @Autowired
    private ServicioEmpleado empl;

    @GetMapping
    public List<Empleado> listar()  {
        return empl.listarEmpleados();
    }

    @PostMapping
    public Empleado insertar(@RequestBody Empleado empleado ){
        return  empl.guardarEmpleados(empleado);
    }


    @PutMapping
    public Empleado actualizar(@RequestBody Empleado empleado) {
        return empl.actualizarEmpleados(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminarporId(@PathVariable("id") Integer id){
        empl.eliminarEmpleados(id);
    }

    @PatchMapping("/{id}")
    public Empleado actualizarpor(@PathVariable("id") Integer id, @RequestBody Map<Object,Object> objectMap){
        return empl.actualizarPorId(id,objectMap);
    }

    @GetMapping("/{id}")
    public Empleado consultarPorcedula(@PathVariable("id") Integer id){
        return empl.consultarEmpleadosid(id);
    }
}
