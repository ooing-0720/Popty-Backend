package com.popty.domain.reservation.application;

import com.popty.domain.reservation.dao.ReservationRepository;
import com.popty.domain.reservation.domain.Reservation;
import com.popty.domain.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    @Override
    public void reserve(ReservationDto dto, String userId, Long spaceId) {
        Reservation entity = Reservation.toEntity(dto, userId, spaceId);
        reservationRepository.save(entity);
    }

    @Override
    public List<ReservationDto> checkProgress(String userId) {
        List<ReservationDto> list = new ArrayList<>();
        List<Reservation> reservations =
                reservationRepository.getReservationsByUserIdAndConfirmed(userId, 1);

        // 현재 날짜와 비교해서 finishDay가 오늘 이전인 경우 지난 대관으로 이동
        // 진행중인 경우 list에 추가
        for (Reservation reservation : reservations) {
            if(reservation.getFinishDay().isBefore(LocalDate.now().plusDays(1))) {
                reservation.setConfirmed(3);
            }
            else {
                list.add(ReservationDto.toDto(reservation));
            }
        }

        return list;
    }

    @Override
    public List<ReservationDto> checkLast(String userId) {
        List<ReservationDto> list = new ArrayList<>();
        List<Reservation> reservations =
                reservationRepository.getReservationsByUserIdAndConfirmed(userId, 3);

        for(Reservation reservation : reservations) {
            list.add(ReservationDto.toDto(reservation));
        }
        return list;
    }

    @Override
    public ReservationDto getReservationInfo(Long reservationId) {
        Reservation reservation =
                reservationRepository.getReservationByReservationId(reservationId);
        return ReservationDto.toDto(reservation);
    }
}
