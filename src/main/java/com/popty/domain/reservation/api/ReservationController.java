package com.popty.domain.reservation.api;

import com.popty.domain.home.dto.SummaryDto;
import com.popty.domain.reservation.application.ReservationService;
import com.popty.domain.reservation.dto.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "reservation", description = "예약(대관, 나의 예약) API")
@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @Operation(description = "대관 정보 저장", summary = "대관하기")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ReservationService.class)))
    @PostMapping("/reserve/{spaceId}")
    public ResponseEntity<?> reserve(@PathVariable String spaceId, String userId, @RequestBody ReservationDto dto) {
        reservationService.reserve(dto, userId, Long.parseLong(spaceId));
        return ResponseEntity.ok("예약되었습니다");
    }
}
