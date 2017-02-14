package co.edu.uniandes.rest.corazon.resources;

/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */


import co.edu.uniandes.rest.corazon.dtos.MedicionDTO;
import co.edu.uniandes.rest.corazon.dtos.MedicionDetailDTO;
import co.edu.uniandes.rest.corazon.dtos.PacienteDTO;
import co.edu.uniandes.sisteam.corazon.api.IMedicionLogic;
import co.edu.uniandes.sisteam.corazon.api.IPacienteLogic;
import co.edu.uniandes.sisteam.corazon.entities.MedicionEntity;
import co.edu.uniandes.sisteam.corazon.exceptions.BusinessLogicException;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/pacientes/{pacienteId: \\d+}/mediciones")
public class MedicionResource {

    @Inject
    private IMedicionLogic medicionLogic;

    @Inject
    private IPacienteLogic pacienteLogic;

    @PathParam("pacienteId")
    private Long pacienteId;

    /**
     * Convierte una lista de MedicionEntity a una lista de
     * MedicionDTO
     *
     * @param entityList Lista de MedicionEntity a convertir
     * @return Lista de MedicionDTO convertida
     *
     */
    private List<MedicionDetailDTO> listEntity2DTO(List<MedicionEntity> entityList) {
        List<MedicionDetailDTO> list = new ArrayList<>();
        for (MedicionEntity entity : entityList) {
            list.add(new MedicionDetailDTO(entity));
        }
        return list;
    }

    public void existsPaciente(Long pacienteId) {
        PacienteDTO paciente = new PacienteDTO(pacienteLogic.getPaciente(pacienteId));
        if (paciente == null) {
            throw new WebApplicationException(404);
        }
    }

    /**
     * Obtiene los datos de los Mediciones de una compañía a partir del ID de
     * la Paciente
     *
     *
     * @return Lista de MedicionDTO con los datos del Medicion
     * consultado
     *
     */
    @GET
    public List<MedicionDetailDTO> getMediciones() {
        existsPaciente(pacienteId);
        
        List<MedicionEntity> mediciones = medicionLogic.getMediciones(pacienteId);

        return listEntity2DTO(mediciones);
    }

    /**
     * Obtiene los datos de una instancia de Medicion a partir de su ID
     * asociado a un Paciente
     *
     * @param medicionId Identificador de la instancia a consultar
     * @return Instancia de MedicionDTO con los datos del Medicion
     * consultado
     *
     */
    @GET
    @Path("{medicionId: \\d+}")
    public MedicionDetailDTO getMedicion(@PathParam("medicionId") Long medicionId) {
        existsPaciente(pacienteId);
        MedicionEntity entity = medicionLogic.getMedicion(medicionId);
        if (entity.getPaciente() != null && !pacienteId.equals(entity.getPaciente().getId())) {
            throw new WebApplicationException(404);
        }
        return new MedicionDetailDTO(entity);
    }

    /**
     * Asocia un Medicion existente a un Paciente
     *
     * @param dto Objeto de MedicionDTO con los datos nuevos
     * @return Objeto de MedicionDTOcon los datos nuevos y su ID.
     *
     */
    @POST
    public MedicionDetailDTO createMedicion(MedicionDetailDTO dto) throws BusinessLogicException {
        existsPaciente(pacienteId);
        return new MedicionDetailDTO(medicionLogic.createMedicion(pacienteId, dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Medicion.
     *
     * @param medicionId Identificador de la instancia de Medicion a
     * modificar
     * @param dto Instancia de MedicionDTO con los nuevos datos.
     * @return Instancia de MedicionDTO con los datos actualizados.
     *
     */
    @PUT
    @Path("{medicionId: \\d+}")
    public MedicionDetailDTO updateMedicion(@PathParam("medicionId") Long medicionId, MedicionDetailDTO dto) {
        existsPaciente(pacienteId);
        MedicionEntity entity = dto.toEntity();
        entity.setId(medicionId);
        MedicionEntity oldEntity = medicionLogic.getMedicion(medicionId);
        return new MedicionDetailDTO(medicionLogic.updateMedicion(pacienteId, entity));
    }

    /**
     * Elimina una instancia de Medicion de la base de datos.
     *
     * @param medicionId Identificador de la instancia a eliminar.
     *
     */
    @DELETE
    @Path("{medicionId: \\d+}")
    public void deleteMedicion(@PathParam("medicionId") Long medicionId) {
        existsPaciente(pacienteId);
        medicionLogic.deleteMedicion(medicionId);
    }
    
    
    /**
     * Obtiene los datos de una instancia de Medicion a partir de su ID
     * asociado a un Paciente
     *
     * @param medicionId Identificador de la instancia a consultar
     * @return Instancia de MedicionDTO con los datos del Medicion
     * consultado
     *
     */
    @GET
    @Path("{medicionId: \\d+}/get2")
    public MedicionDTO getMedicion2(@PathParam("medicionId") Long medicionId) {
       
        MedicionEntity entity = medicionLogic.getMedicion(medicionId);
       
        return new MedicionDTO(entity);
    }

}
