package dev.gabrielbarbosa.dscommerce.controlers;

import dev.gabrielbarbosa.dscommerce.dto.ProductDTO;
import dev.gabrielbarbosa.dscommerce.dto.UserDTO;
import dev.gabrielbarbosa.dscommerce.services.ProductService;
import dev.gabrielbarbosa.dscommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe() {
        UserDTO me = userService.getMe();
        return ResponseEntity.ok(me);
    }


}
