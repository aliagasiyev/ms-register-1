package az.edu.msregister.service;

import az.edu.msregister.entity.EducationEntity;

import java.util.List;

public interface EducationService {
    EducationEntity createEducation(EducationEntity education);

    EducationEntity updateEducation(EducationEntity education);

    EducationEntity getEducationById(Long id);

    void deleteEducation(Long id);

    List<EducationEntity> getAllEducation();
}
