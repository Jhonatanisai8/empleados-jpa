/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleados.jpa.controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sistema.empleados.jpa.controlador.exceptions.NonexistentEntityException;
import sistema.empleados.jpa.entity.TbPersona;

/**
 *
 * @author User
 */
public class TbpersonaJpaController implements Serializable {

    public TbpersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema-empleados-jpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /*crearemos un constructor vacio*/
    public TbpersonaJpaController() {

    }

    public void create(TbPersona tbpersona) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbpersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbPersona tbpersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbpersona = em.merge(tbpersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbpersona.getIdtbpersona();
                if (findTbpersona(id) == null) {
                    throw new NonexistentEntityException("The tbpersona with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbPersona tbpersona;
            try {
                tbpersona = em.getReference(TbPersona.class, id);
                tbpersona.getIdtbpersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbpersona with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbpersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbPersona> findTbpersonaEntities() {
        return findTbpersonaEntities(true, -1, -1);
    }

    public List<TbPersona> findTbpersonaEntities(int maxResults, int firstResult) {
        return findTbpersonaEntities(false, maxResults, firstResult);
    }

    private List<TbPersona> findTbpersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbPersona.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TbPersona findTbpersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbPersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbpersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbPersona> rt = cq.from(TbPersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
