package br.com.stefanycampanhoni.projeto_final_web.person;

import br.com.stefanycampanhoni.projeto_final_web.ApiResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class PersonController {
    private final PersonService service;

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody PersonDto personDto,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ApiResponseHelper.toResponse(service.saveUser(personDto), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Boolean> login(@Valid @RequestBody PersonDto personDto) {
        return ApiResponseHelper.toResponse(service.login(personDto), HttpStatus.OK);
    }
}
