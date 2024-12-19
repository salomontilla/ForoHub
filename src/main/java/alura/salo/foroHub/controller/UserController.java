package alura.salo.foroHub.controller;

import alura.salo.foroHub.infra.security.TokenService;
import alura.salo.foroHub.model.JWTResponseDTO;
import alura.salo.foroHub.model.user.UserDTO;
import alura.salo.foroHub.model.user.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity <JWTResponseDTO> autenticarUsuario(@RequestBody @Valid UserDTO userDTO) {
        Authentication token = new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password());//se crea un token con el nombre y la clave del usuario
        var authUser = authenticationManager.authenticate(token);
        String JWToken = tokenService.generateToken((UserModel) authUser.getPrincipal());
        return ResponseEntity.ok(new JWTResponseDTO(JWToken));
    }
}
