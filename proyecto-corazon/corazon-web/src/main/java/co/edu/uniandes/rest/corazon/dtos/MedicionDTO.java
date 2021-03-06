package co.edu.uniandes.rest.corazon.dtos;

import co.edu.uniandes.sisteam.corazon.entities.MedicionEntity;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MedicionDTO
 * Objeto de transferencia de datos de Mediciones.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */

/**
 * Objeto de transferencia de datos de Ciudades.
 * @author Asistente
 */
@XmlRootElement
public class MedicionDTO {
    
    private Long id;
    private Date fecha;
    private Double frecuenciaCardiaca;
    private Double presionSanguinea;
    private int nivelEstres;
    private String dictamen;

    /**
     * Constructor por defecto
     */
    public MedicionDTO() {
	}

    public MedicionDTO(Long id, String dictamen, Date fecha, Double frecuenciaCardiaca, Double presionSanguinea, int nivelEstres,Long pacienteId) {
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
            this.frecuenciaCardiaca = entity.getFrecuenciaCardiaca();
            this.presionSanguinea = entity.getPresionSanguinea();
            this.nivelEstres = entity.getNivelEstres();
            this.dictamen = entity.getDictamen();

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
        entity.setFecha(this.getFecha());
        entity.setFrecuenciaCardiaca(this.getFrecuenciaCardiaca());
        entity.setPresionSanguinea(this.getPresionSanguinea());
        entity.setNivelEstres(this.getNivelEstres());
        entity.setDictamen(this.getDictamen());
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

    public String getDictamen() {
        return dictamen;
    }

    public void setDictamen(String dictamen) {
        this.dictamen = dictamen;
    }
    
    
}
