package com.lozano.alquiler.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Embeddable
class DetalleAlquilerId implements java.io.Serializable{
    private Long idAlquiler;
    private Long IdPelicula;
}
@Entity
@Table(name = "detalle_alquiler")
public class DetalleAlquiler {
    @EmbeddedId
    private DetalleAlquilerId id = new DetalleAlquilerId();

    @ManyToOne
    @MapsId("idAlquiler")
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @Min(value=1, message="La cantidad debe ser mayor a 0")
    private int cantidad;

    public DetalleAlquilerId getId() {
        return id;
    }

    public void setId(DetalleAlquilerId id) {
        this.id = id;
    }

    public Alquiler getAlquiler(){
        return alquiler()
    }

    public void setAlquiler(Alquiler alquiler){
        this.alquiler = alquiler;
    }

    public Pelicula getPelicula(){
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula){
        this.pelicula = pelicula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
