package ru.olegraskin.employee.service;

import ru.olegraskin.employee.domain.Skill;

import java.util.Set;

public interface SkillService {

    Set<Skill> getAll();

    Set<Skill> getRoots();

    Skill getById(Long id);

    Skill save(Skill skill);

    Skill update(Skill skill);

    void delete(Long id);
}
