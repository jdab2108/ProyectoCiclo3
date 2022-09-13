package com.example.DlloSoftGrupo4.controlador;

import com.example.DlloSoftGrupo4.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/Empresa")
@RestController

public class ControladorEmpresa {

    @Autowired
    private com.example.DlloSoftGrupo4.servicios.ServicioEmpresa emp;

    @GetMapping
    public List<Empresa> listar(){return emp.ListarEmpresa();}

    @PostMapping
    public Empresa insertar(@RequestBody Empresa empresa){
        return emp.guardarEmpresas(empresa);
    }

    @PutMapping
    public Empresa actualizar(@RequestBody Empresa empresa){
        return emp.actualizarEmpresas(empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorNit(@PathVariable("id") Integer id){
        emp.eliminarEmpresas(id);
    }

    @PatchMapping("/{nit}")
    public Empresa actualizarPorNit(@PathVariable("nit") Integer id, @RequestBody Map<Object, Object> objectMap){
        return emp.actualizarPorId(id,objectMap);
    }

    @GetMapping("/{nit}")
    public Empresa consultarPorNit(@PathVariable("nit") Integer nit){
        return emp.consultarEmpresaPorId(nit);
    }

}