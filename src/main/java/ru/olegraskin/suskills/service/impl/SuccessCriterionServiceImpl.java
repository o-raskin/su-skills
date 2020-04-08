package ru.olegraskin.suskills.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.olegraskin.suskills.domain.SuccessCriterion;
import ru.olegraskin.suskills.repository.SuccessCriterionRepository;
import ru.olegraskin.suskills.service.SuccessCriterionService;
import ru.olegraskin.suskills.service.exception.SuccessCriteriaNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuccessCriterionServiceImpl implements SuccessCriterionService {

    private final SuccessCriterionRepository successCriterionRepository;

    @Override
    public SuccessCriterion update(@NonNull SuccessCriterion sc) {
        Optional<SuccessCriterion> optional = successCriterionRepository.findById(sc.getId());
        SuccessCriterion stored = optional.orElseThrow(() -> new SuccessCriteriaNotFoundException(sc.getId()));
        stored.setName(sc.getName());
        stored.setDescription(sc.getDescription());
        successCriterionRepository.save(stored);
        return stored;
    }

}