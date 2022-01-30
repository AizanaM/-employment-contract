package kg.megalab.employmentproject.service.impl;


import kg.megalab.employmentproject.mapper.CharacteristicsMapper;
import kg.megalab.employmentproject.model.dto.CharacteristicsDto;
import kg.megalab.employmentproject.model.entity.Characteristics;
import kg.megalab.employmentproject.repository.CharacteristicsRepository;
import kg.megalab.employmentproject.service.CharacteristicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacteristicsServiceImpl implements CharacteristicsService {

    private final CharacteristicsRepository characteristicsRepository;


    @Override
    public CharacteristicsDto update(CharacteristicsDto characteristicsDto) {

        Characteristics characteristicsEntity = characteristicsRepository
                .findById(characteristicsDto.getId())
                .map(characteristics -> {
            characteristics.setHardSkills(characteristicsDto.getHardSkills());
            characteristics.setSoftSkills(characteristicsDto.getSoftSkills());
            return characteristicsRepository.save(characteristics);
        }).orElseThrow(() -> new RuntimeException("Not Found"));
        return CharacteristicsMapper.INSTANCE.toDto(characteristicsEntity);
    }

    @Override
    public CharacteristicsDto find(Long id) {
        return CharacteristicsMapper.INSTANCE.toDto(characteristicsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Address with id=\" + id + \" not found")));
    }

    @Override
    public void save(Characteristics characteristics) {
        characteristicsRepository.save(characteristics);
    }
}
