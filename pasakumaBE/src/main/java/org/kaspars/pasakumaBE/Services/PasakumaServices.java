package org.kaspars.pasakumaBE.Services;

import java.util.List;
import java.util.Optional;

import org.kaspars.pasakumaBE.model.PasakumaModel;
import org.kaspars.pasakumaBE.repository.PasakumaRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class PasakumaServices {
    private final PasakumaRepository pasakumaRepository;

    public List<PasakumaModel> getVisusPasakumi() {
        return pasakumaRepository.findAll();
    }

    public Long createPasakums(PasakumaModel saglabatsPasakums) {
        return pasakumaRepository.save(saglabatsPasakums).getId();
    }

    public boolean deletePasakums(Long id) {
        if (pasakumaRepository.existsById(id)) {
            pasakumaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updatePasakums(Long id, PasakumaModel atjaunotsPasakums) {
        Optional<PasakumaModel> existingPasakumsOpt = pasakumaRepository.findById(id);
        if (existingPasakumsOpt.isPresent()) {
            PasakumaModel existingPasakums = existingPasakumsOpt.get();
            existingPasakums.setPasakumaNosaukums(atjaunotsPasakums.getPasakumaNosaukums());
            existingPasakums.setPasakumaDatums(atjaunotsPasakums.getPasakumaDatums());
            existingPasakums.setPasakumaVieta(atjaunotsPasakums.getPasakumaVieta());
            existingPasakums.setPasakumaApraksts(atjaunotsPasakums.getPasakumaApraksts());
            existingPasakums.setPasakumaLaiks(atjaunotsPasakums.getPasakumaLaiks());
            existingPasakums.setDalibniekuSkaits(atjaunotsPasakums.getDalibniekuSkaits());
            pasakumaRepository.save(existingPasakums);
            return true;
        }
        return false;
    }
}
