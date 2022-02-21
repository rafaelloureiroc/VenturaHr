package br.edu.infnet.VenturaHr.repository;
import java.util.ArrayList;
import java.util.List;
import br.edu.infnet.VenturaHr.model.Usuario;


public class UsuarioRepository {
	private static List <Usuario> lista = new ArrayList<>();
	  public static void adicionaUsuario(Usuario usuario) {
	        lista.add(usuario);
	    }

	    public static List<Usuario> pegarLista() {
	        return lista;
	    }


}