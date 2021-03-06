/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.sisteam.corazon.ejbs;

import co.edu.uniandes.sisteam.corazon.api.IMarcapasosLogic;
import co.edu.uniandes.sisteam.corazon.entities.HistoriaClinicaEntity;
import co.edu.uniandes.sisteam.corazon.entities.MarcapasosRealEntity;
import co.edu.uniandes.sisteam.corazon.entities.PacienteEntity;
import co.edu.uniandes.sisteam.corazon.exceptions.BusinessLogicException;
import co.edu.uniandes.sisteam.corazon.persistence.MarcapasosPersistence;
import co.edu.uniandes.sisteam.corazon.persistence.PacientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author BarraganJeronimo
 */
@Stateless
public class MarcapasosLogic implements IMarcapasosLogic {

    @Inject
    private MarcapasosPersistence marcapasosPersistence;

    @Inject
    private PacientePersistence pacientePersistence;

    @Override
    public MarcapasosRealEntity getMarcapasosPaciente(Long idPaciente) {
        return marcapasosPersistence.getMarcapasosPaciente(idPaciente);
    }

    @Override
    public MarcapasosRealEntity createMarcapasos(MarcapasosRealEntity entity, Long idPaciente) throws BusinessLogicException {

        PacienteEntity existe = pacientePersistence.find(idPaciente);
        if (existe == null) {
            throw new BusinessLogicException("No exite cliente con esa identificacion: " + idPaciente);
        } else {
            existe.setMarcapasos(entity);
            entity.setPaciente(existe);
            marcapasosPersistence.create(entity);
            pacientePersistence.update(existe);
        }
        return entity;
    }

    @Override
    public MarcapasosRealEntity updateMarcapasos(MarcapasosRealEntity entity, Long idPaciente) throws BusinessLogicException 
    {
        PacienteEntity existe = pacientePersistence.find(idPaciente);
        if (existe == null) {
            throw new BusinessLogicException("No exite cliente con esa identificacion: " + idPaciente);
        } else {
            existe.setMarcapasos(entity);
            entity.setPaciente(existe);
            marcapasosPersistence.update(entity);
            pacientePersistence.update(existe);
        }
        return entity;
      
    }

}
