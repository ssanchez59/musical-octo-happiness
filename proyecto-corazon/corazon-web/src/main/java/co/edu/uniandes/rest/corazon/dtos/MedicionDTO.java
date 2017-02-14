package co.edu.uniandes.rest.corazon.dtos;

import co.edu.uniandes.sisteam.corazon.entities.MedicionEntity;
import java.sql.Date;

/*
 * MedicionDTO
 * Objeto de transferencia de datos de Mediciones.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */

/**
 * Objeto de transferencia de datos de Ciudades.
 * @author Asistente
 */
public class MedicionDTO {
    
    private Long id;
    private String dictamen;
    private Date fecha;
    private Double frecuenciaCardiaca;
    private Double presionSanguinea;
    private int nivelEstres;
    
    
    /**
     * Constructor por defecto
     */
    public MedicionDTO() {
	}

    public MedicionDTO(Long id, String dictamen, Date fecha, Double frecuenciaCardiaca, Double presionSanguinea, int nivelEstres) {
        this.id = id;
        this.dictamen = dictamen;
        this.fecha = fecha;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionSanguinea = presionSanguinea;
        this.nivelEstres = nivelEstres;
    }
    
    public MedicionDTO(MedicionEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.fecha = entity.getFecha();
            this.dictamen = entity.getDictamen();
            this.frecuenciaCardiaca = entity.getFrecuenciaCardiaca();
            this.presionSanguinea = entity.getPresionSanguinea();
            this.nivelEstres = entity.getNivelEstres();

        }
    }
    
     /**
     * Convierte un objeto MedicionDTO a MedicionEntity.
     *
     * @return Nueva objeto MedicionEntity.
     * 
     */
    public MedicionEntity toEntity() {
        MedicionEntity entity = new MedicionEntity();
        entity.setId(this.getId());
        entity.setDictamen(this.getDictamen());
        entity.setFecha(this.getFecha());
        entity.setFrecuenciaCardiaca(this.getFrecuenciaCardiaca());
        entity.setPresionSanguinea(this.getPresionSanguinea());
        entity.setNivelEstres(this.getNivelEstres());
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictamen() {
        return dictamen;
    }

    public void setDictamen(String dictamen) {
        this.dictamen = dictamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Double getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(Double presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

}