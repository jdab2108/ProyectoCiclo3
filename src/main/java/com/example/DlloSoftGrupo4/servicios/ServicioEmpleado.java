package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Empresa;

import java.util.List;
import java.util.Map;

public interface ServicioEmpleado {

    public List<Empleado>listarEmpleados();

    public Empleado guardarEmpleados(Empleado empleado);


    public Empleado consultarEmpleadosid(Integer documentoEmpleado);

    public Empleado actualizarEmpleados(Empleado empleado);

    public void eliminarEmpleados(Integer documentoEmpleado);

    public Empleado actualizarPorId(Integer documentoEmpleado, Map<Object,Object> objectMap);

}
