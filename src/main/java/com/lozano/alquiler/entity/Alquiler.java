package com.lozano.alquiler.entity;

import  jakarta.persistence.*;
import  jakarta.validation.constraints.NotNull;
import org.antlr.v4.runtime.misc.NotNull;

import  java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="alquileres")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlquiler;

    @NotNull
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name ="id_cliente")
    @NotNull(message="Debe selecionar un cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler estado;

    @NotNull
    private double total;

    @OneToMany(mappedBy = "alquiler", cascade = CascadeType.ALL)
    private List<DetalleAlquiler> detalles;

    public Long getIdAlquiler(){
        return idAlquiler;
    }

    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoAlquiler getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlquiler estado){
        this.estado = estado
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleAlquiler> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleAlquiler> detalles) {
        this.detalles = detalles;
        if (detalles !=null){
            detalles.forEach(d->d.setAlquiler(this));
        }
    }
}
