/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.sisteam.corazon.persistence;

import co.edu.uniandes.sisteam.corazon.entities.DiagnosticoEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santiago
 */
@Stateless
public class DiagnosticoPersistence {
    @PersistenceContext(unitName = "SisteamCorazonPU")
    protected EntityManager em;
    
    public DiagnosticoEntity find(Long id) {
        return em.find(DiagnosticoEntity.class, id);
    }

    public DiagnosticoEntity create(DiagnosticoEntity entity) {
        em.persist(entity);
        return entity;
    }

    public DiagnosticoEntity update(DiagnosticoEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        DiagnosticoEntity entity = em.find(DiagnosticoEntity.class, id);
        em.remove(entity);
    }
}