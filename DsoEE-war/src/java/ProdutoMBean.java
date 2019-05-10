/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Produto;
import Entidades.ProdutoFachada;
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
    
    private Produto produto = new Produto();  // Guarda os dados do formulário

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String cadastrarProduto() {          // Chama o método do bean de sessão
        produtoFachada.cadastrarProduto(produto);
        produto = new Produto();
        return "index";
    }
}
