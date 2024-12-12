package br.com.alura.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;

@Service
public class AuntenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuário: " + username);
        Optional<Usuario> usuario = repository.findByEmail(username);
        if (usuario.isPresent()) {
            System.out.println("Usuário encontrado: " + usuario.get().getEmail());
            return usuario.get();
        }
    
        System.out.println("Usuário não encontrado.");
        throw new UsernameNotFoundException("Dados inválidos!");
    }
    

}
