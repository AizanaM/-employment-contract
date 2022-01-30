package kg.megalab.employmentproject.service;


import kg.megalab.employmentproject.model.dto.CharacteristicsDto;
import kg.megalab.employmentproject.model.entity.Characteristics;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicsService {


    CharacteristicsDto update (CharacteristicsDto characteristicsDto);
    CharacteristicsDto find (Long id);
    void save(Characteristics characteristics);
}
