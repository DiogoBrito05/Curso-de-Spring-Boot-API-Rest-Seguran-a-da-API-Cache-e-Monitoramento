package br.com.alura.forum.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String nomePerfil;

    public Long getId() {
		return id;
	}


    public String getNomePerfil() {
		return nomePerfil;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public void setNomePefil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}


    @Override
    public String getAuthority() {
        return nomePerfil;
    }
}
