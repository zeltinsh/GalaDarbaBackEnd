package org.kaspars.pasakumaBE.controller;

import java.util.List;

import org.kaspars.pasakumaBE.Services.PasakumaServices;
import org.kaspars.pasakumaBE.model.PasakumaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")

public class PasakumaController {
    private final PasakumaServices pasakumaServices;

    @GetMapping("/manipasakumi")
    public List<PasakumaModel> getVisusPasakumus() {
        return pasakumaServices.getVisusPasakumi();
    }

    @PostMapping("/manipasakumi")
    public ResponseEntity<Long> postMethodName(@RequestBody PasakumaModel pasakums) {
        return ResponseEntity.ok(pasakumaServices.createPasakums(pasakums));
    }

    @DeleteMapping("/manipasakumi/{id}")
    public ResponseEntity<Void> deletePasakums(@PathVariable Long id) {
        if (pasakumaServices.deletePasakums(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/manipasakumi/{id}")
    public ResponseEntity<Void> putMethodName(@PathVariable Long id, @RequestBody PasakumaModel pasakums) {
        if (pasakumaServices.updatePasakums(id, pasakums)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
