package gui;

import negocio.beans.Usuario;

public class SessionController {
	    private static SessionController instance;
	    private Usuario usuarioLogado;

	    private SessionController() {
	        
	    }

	    public static SessionController getInstance() {
	        if (instance == null) {
	            instance = new SessionController();
	        }
	        return instance;
	    }

	    public Usuario getUsuarioLogado() {
	        return usuarioLogado;
	    }

	    public void setUsuarioLogado(Usuario usuarioLogado) {
	        this.usuarioLogado = usuarioLogado;
	    }

	    public void encerrarSessao() {
	        usuarioLogado = null;
	    }
}
