package com.popty.domain.reservation.application;

import com.popty.domain.reservation.dto.ReservationDto;

import java.util.List;

public interface ReservationConfirmService {

    // 대관처에서 예약 확인
    public void confirmReservation(Long reservationId);
    public List<ReservationDto> checkReservation(Long spaceID);
}
