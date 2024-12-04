package br.com.stefanycampanhoni.projeto_final_web.movement;

import br.com.stefanycampanhoni.projeto_final_web.ApiResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/movements")
public class MovementController {
    private final MovementService service;

    @GetMapping
    public ResponseEntity<List<Movement>> getAll() {
        return ApiResponseHelper.toResponse(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody MovementDto movement) {
        return ApiResponseHelper.toResponse(service.create(movement), HttpStatus.CREATED);
    }
}
