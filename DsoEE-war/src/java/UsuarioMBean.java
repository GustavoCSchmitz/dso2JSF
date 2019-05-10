/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Usuario;
import Entidades.UsuarioFachada;
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
public class UsuarioMBean {
    @EJB
    private UsuarioFachada usuarioFachada;

    /**
     * Creates a new instance of UsuarioMBean
     */
    public UsuarioMBean() {
    }
    
    public List<Usuario> getListaUsuarios() {
        return usuarioFachada.getListaUsuarios();
    }
    
    private Usuario usuario = new Usuario();  // Guarda os dados do formulário

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String cadastrarUsuario() {          // Chama o método do bean de sessão
        usuarioFachada.cadastrarUsuario(usuario);
        usuario = new Usuario();
        return "index";
    }
    
    public String salvarUsuario() {
        usuarioFachada.salvarUsuario(this.usuario);
        return "index";
    }
    
    public String removerUsuario(Integer usuarioId) {
        usuarioFachada.removerUsuario(usuarioId);
        return "index";
    }
  
    private String filtroUf = "";

    public String getFiltroUf() {
        return filtroUf;
    }

    public void setFiltroUf(String filtroUf) {
        this.filtroUf = filtroUf;
    }
    
    public List getListaUsuariosPorUF() {
        return usuarioFachada.getListaUsuariosPorUF(filtroUf);
    }
}
