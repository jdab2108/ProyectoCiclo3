package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Empresa;
import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpresa;
import com.example.DlloSoftGrupo4.servicios.ServicioMovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServiciosImpMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/Empresa")
@RestController
//@Controller
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

    // consulta de movimiento dinero con nit y movimientoDinero
    @GetMapping("/{nit}/MovimientoDinero")
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("nit") Integer nit){
        return  smd.obtenerPorEmpresa(nit);
    }

    // controlador para mostrar el formulario de empleado


//    @GetMapping("MovimientoDinero")
//    public String formularioregistromovimientos(Model modelo){
//        modelo.addAttribute("movimientosinsertar",new MovimientoDinero());
//        return "frmnuevomovdinero";
//    }

//    @PostMapping("MovimientoDinero/guardar")
 //       public String insertarmovimientos(MovimientoDinero movdinero){
//        smd.guardarMovimientos(movdinero);
//        return "redirect:/MovimientoDinero";
//}


}