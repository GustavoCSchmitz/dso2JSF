/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
@Stateless
@LocalBean
public class UsuarioFachada {
    
    @PersistenceContext(unitName = "DsoEE-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<Entidades.Usuario> getListaUsuarios() {
        Query query = em.createNamedQuery("usuario.findAll");
        return query.getResultList();
    }
    
    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(id) FROM USUARIO");
        return ((BigDecimal) query.getSingleResult()).intValue();
    }
 
    public void cadastrarUsuario(Usuario usuario) {  // Cadastra o cliente 
        usuario.setId(getMaxId()+1);
        em.persist(usuario);
    }
    
    public void salvarUsuario(Usuario usuario) {
        em.merge(usuario);
        em.flush();
    }
    
    public void removerUsuario(Integer usuarioId) {
        em.remove(em.find(Usuario.class, usuarioId));
    }
    
    public List getListaUsuariosPorUF(String uf) {
        if (uf == null || uf.equals("")) 
            return getListaUsuarios();
        Query query = em.createNamedQuery("usuario.findByUf");
        query.setParameter("uf", uf);
        return query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
