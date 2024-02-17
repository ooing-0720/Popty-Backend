package com.popty.domain.reservation.dto;


import com.popty.domain.reservation.domain.Reservation;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    LocalDate startDay;
    LocalDate finishDay;
    Timestamp startTime;
    Timestamp finishTime;
    String eventTarget;
    int perks;
    boolean dessert;
    boolean combo;
    boolean luckd;
    List<Integer> benefits;

    public static ReservationDto toDto(Reservation entity) {
        return ReservationDto.builder()
                .startDay(entity.getStartDay())
                .finishDay(entity.getFinishDay())
                .startTime(entity.getStartTime())
                .finishTime(entity.getFinishTime())
                .eventTarget(entity.getEventTarget())
                .perks(entity.getPerks())
                .dessert(entity.isDessert())
                .combo(entity.isCombo())
                .luckd(entity.isLuckd())
                .benefits(entity.getBenefits())
                .build();
    }
}
