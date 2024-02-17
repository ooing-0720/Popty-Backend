package com.popty.domain.reservation.application;

import com.popty.domain.reservation.dao.ReservationRepository;
import com.popty.domain.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    // 주최자 이벤트 관련
    public void reserve(ReservationDto dto, String userId, Long spaceId);
    public List<ReservationDto> checkProgress(String userId);
    public List<ReservationDto> checkLast(String userId);
    public ReservationDto getReservationInfo(Long reservationId);
}
