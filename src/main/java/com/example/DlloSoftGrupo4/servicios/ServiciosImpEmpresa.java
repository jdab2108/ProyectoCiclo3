package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.Empresa;
import com.example.DlloSoftGrupo4.repositorio.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServiciosImpEmpresa implements ServicioEmpresa {

    @Autowired
    private RepositorioEmpresa repositorioEmpresa;

    @Override
    public List<Empresa> ListarEmpresa() {
        return repositorioEmpresa.findAll();
    }

    @Override
    public Empresa consultarEmpresaPorId(Integer nitEmpresa) {
        return repositorioEmpresa.findById(nitEmpresa).get();
    }

    @Override
    public Empresa guardarEmpresas(Empresa empresa) {
        return repositorioEmpresa.save(empresa);
    }

    @Override
    public Empresa actualizarEmpresas(Empresa empresa) {
        return repositorioEmpresa.save(empresa);
    }


    @Override
    public void eliminarEmpresas(Integer documento) {
        repositorioEmpresa.deleteById(documento);
    }

    @Override
    public Empresa actualizarPorId(Integer docNit, Map<Object, Object> objectMap) {
        Empresa empresa= repositorioEmpresa.findById(docNit).get();
        objectMap.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Empresa.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, empresa, value);

        });
        return repositorioEmpresa.save(empresa);
    }
}
