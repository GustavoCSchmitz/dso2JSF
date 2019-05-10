/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.ListaProduto;
import Entidades.ListaProdutoFachada;
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
public class ListaProdutoMBean {
    @EJB
    private ListaProdutoFachada listaProdutoFachada;

    /**
     * Creates a new instance of ListaProdutoMBean
     */
    public ListaProdutoMBean() {
    }
    
    public List<ListaProduto> getLista() {
        return listaProdutoFachada.getLista();
    }
    
    private ListaProduto lista = new ListaProduto();  // Guarda os dados do formulário

    public ListaProduto getListaProduto() {
        return lista;
    }

    public void setListaProduto(ListaProduto lista) {
        this.lista = lista;
    }

    public String cadastrarListaProduto() {          // Chama o método do bean de sessão
        listaProdutoFachada.cadastrarListaProduto(lista);
        lista = new ListaProduto();
        return "index";
    }
}
