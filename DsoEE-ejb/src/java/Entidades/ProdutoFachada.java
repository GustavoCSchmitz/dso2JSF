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
public class ProdutoFachada {
    
    
    @PersistenceContext(unitName = "DsoEE-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<Entidades.Produto> getListaProdutos() {
        Query query = em.createNamedQuery("produto.findAll");
        return query.getResultList();
    }

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(id) FROM PRODUTO");
        return ((BigDecimal) query.getSingleResult()).intValue();
    }
 
    public void cadastrarProduto(Produto produto) {  // Cadastra o cliente 
        produto.setId(getMaxId()+1);
        em.persist(produto);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
