package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.Usuario;
import com.example.demo.payload.AutenticationLogin;
import com.example.demo.payload.AutenticationResponse;
import com.example.demo.security.service.MiUserDetailsService;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUsuarioServicio;
import com.example.demo.utils.JwtUtil;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class JwtController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MiUserDetailsService miUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/registrarse")
    public ResponseEntity<?> registrarse(@RequestBody Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Asignar role de user
        Role role = roleService.buscarRolePorId(3);
        usuario.setRol(role);
        usuario.setActivo(true);
        usuarioServicio.guardarUsuario(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    } // fin de la pagina de registro

    @PostMapping("/iniciar")
    public ResponseEntity<?> iniciarSesion(@RequestBody AutenticationLogin autLogin) throws Exception{
        //autLogin.getPassword();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(autLogin.getUsername(), autLogin.getPassword())
            );

        }catch (BadCredentialsException ex){
            throw new Exception("Error en el username o contraseña " + ex.getMessage());
        } // fin de try~catch

        // Obtenemos los datos del usuario de la BD para construir el token
        final UserDetails userDetails = miUserDetailsService.loadUserByUsername(autLogin.getUsername());
        final String token = jwtUtil.creatToken(userDetails);

        // Regresamos el token
        return ResponseEntity.ok(new AutenticationResponse(token));
    } // fin para iniciar sesion


    /* ~ Rutas privadas (requieren token)
    ------------------------------------------------------------------------------- */
    @GetMapping("/home")
    public String userAuthenticated(){
        return "Welcome";
    }
}
