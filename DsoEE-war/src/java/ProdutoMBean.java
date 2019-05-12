/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ejb.Produto;
import ejb.ProdutoFachada;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class ProdutoMBean {
    @EJB
    private ProdutoFachada produtoFachada;

    /**
     * Creates a new instance of ProdutoMBean
     */
    public ProdutoMBean() {
    }
    
    public List<Produto> getListaProdutos() {
        return produtoFachada.getListaProdutos();
    }
    
}
