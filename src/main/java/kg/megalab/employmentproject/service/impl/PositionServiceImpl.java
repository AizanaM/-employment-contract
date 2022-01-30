package kg.megalab.employmentproject.service.impl;

import kg.megalab.employmentproject.mapper.PositionMapper;
import kg.megalab.employmentproject.model.dto.PositionDto;
import kg.megalab.employmentproject.model.entity.Position;
import kg.megalab.employmentproject.model.request.CreatePositionRequest;
import kg.megalab.employmentproject.repository.PositionRepository;
import kg.megalab.employmentproject.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public PositionDto create(CreatePositionRequest request) {
        Position position = Position.builder()
                .positionTitle(request.getPositionTitle())
                .isActive(true)
                .build();
        positionRepository.save(position);
        return PositionMapper.INSTANCE.toDto(position);
    }

    @Override
    public PositionDto update(PositionDto positionDto) {
        Position positionEntity = positionRepository.findById(positionDto.getId()).map(position -> {
            position.setPositionTitle(positionDto.getPositionTitle());
            return positionRepository.save(position);
        }).orElseThrow(()-> new RuntimeException("Not Found"));
        return PositionMapper.INSTANCE.toDto(positionEntity);
    }

    @Override
    public PositionDto find(Long id) {
        Position position  = positionRepository
                .findById(id).
                        orElseThrow(()-> new RuntimeException("Position with id"+id+"is not found"));
        return PositionMapper.INSTANCE.toDto(position);
    }

    @Override
    public PositionDto delete(Long id) {
        return PositionMapper.INSTANCE.toDto(positionRepository.findById(id).map(position -> {
            position.setIsActive(false);
            return positionRepository.save(position);
        }).orElseThrow(()-> new RuntimeException("This position not found or already deleted")));
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);

    }
}
