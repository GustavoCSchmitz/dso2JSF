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
public class ListaProdutoFachada {
    
    @PersistenceContext(unitName = "DsoEE-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<Entidades.ListaProduto> getLista() {
        Query query = em.createNamedQuery("lista_produto.findAll");
        return query.getResultList();
    }

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(id) FROM LISTA_PRODUTO");
        return ((BigDecimal) query.getSingleResult()).intValue();
    }
 
    public void cadastrarListaProduto(ListaProduto lista) {  // Cadastra o cliente 
        lista.setId(getMaxId()+1);
        em.persist(lista);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
