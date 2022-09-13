package com.example.DlloSoftGrupo4.entidades;


import javax.persistence.*;
import javax.xml.bind.SchemaOutputResolver;


@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(name = "monto_movimiento")
    private double montoMovimiento;

    @Column(nullable = false, length = 30)
    private String conceptoMovimiento;


    @ManyToOne
    @JoinColumn(name="documentoEmpleado")
    Empleado documentoEmpleado;

    @ManyToOne
    @JoinColumn(name="nit")
    Empresa nit;

    //Controladores


    public MovimientoDinero(int codigo, double montoMovimiento, String conceptoMovimiento, Empleado documentoEmpleado,Empresa nit) {
        this.codigo = codigo;
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.documentoEmpleado = documentoEmpleado;
        this.nit = nit;
    }

    public MovimientoDinero() {
    }


    // Getters y Setter


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(Empleado documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public Empresa getNit() {
        return nit;
    }

    public void setNit(Empresa nit) {
        this.nit = nit;
    }
}
