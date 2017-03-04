/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.corazon.dtos;

import co.edu.uniandes.sisteam.corazon.entities.ExamenEntity;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santiago
 */
@XmlRootElement
public class ExamenDTO {
    
    private Long id;
    private Date fecha;
    private String descripcion;

    public ExamenDTO() {
    }
    
    public ExamenDTO(ExamenEntity entity){
        if(entity!=null){
            this.id = entity.getId();
            this.fecha = entity.getFecha();
            this.descripcion = entity.getDescripcion();
        }
    }
    
    public ExamenEntity toEntity(){
        ExamenEntity entity = new ExamenEntity();
        entity.setId(id);
        entity.setDescripcion(descripcion);
        entity.setFecha(fecha);
        
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
