package com.popty.domain.reservation.domain;

import com.popty.domain.reservation.dto.ReservationDto;
import com.popty.global.common.converter.IntegerArrayConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long reservationId;         // 예약 번호
    String userId;
    Long spaceId;
    LocalDate startDay;
    LocalDate finishDay;
    Timestamp startTime;
    Timestamp finishTime;
    String eventTarget; // 이벤트 대상
    int perks;          // 특전
    boolean dessert;
    boolean combo;      // 세트
    boolean luckd;      // 럭키드로우

    @Convert(converter = IntegerArrayConverter.class)
    List<Integer> benefits; // 선택한 혜택 인덱스
    int confirmed;      // 0 : 대기, 1 : 확정, 2 : 취소(거절?), 3 : 완료

    public static Reservation toEntity(ReservationDto dto, String userId, Long spaceId) {
        return Reservation.builder()
                .userId(userId)
                .spaceId(spaceId)
                .startDay(dto.getStartDay())
                .finishDay(dto.getFinishDay())
                .startTime(dto.getStartTime())
                .finishTime(dto.getFinishTime())
                .eventTarget(dto.getEventTarget())
                .perks(dto.getPerks())
                .dessert(dto.isDessert())
                .combo(dto.isCombo())
                .luckd(dto.isLuckd())
                .benefits(dto.getBenefits())
                .confirmed(0)
                .build();
    }
}
