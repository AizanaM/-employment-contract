package kg.megalab.employmentproject.service;

import kg.megalab.employmentproject.model.dto.PositionDto;
import kg.megalab.employmentproject.model.entity.Position;
import kg.megalab.employmentproject.model.request.CreatePositionRequest;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {

    PositionDto create (CreatePositionRequest request);
    PositionDto update (PositionDto positionDto);
    PositionDto find (Long id);
    PositionDto delete(Long id);
    void save(Position position);
}
