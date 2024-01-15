package com.popty.domain.home.api;

import com.popty.domain.home.dto.PlaceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Tag(name = "main", description = "메인 페이지 API")
@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class MainController {

    @Operation(summary = "get monthly posts", description = "이번달 인기 대관처")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PlaceDto.class)))
    })
    @GetMapping("/month")
    public ResponseEntity<?> getMonthlyPosts() {
        List<PlaceDto> places;
        return ResponseEntity.ok(new PlaceDto());
    }

    @Operation(summary = "get benefit posts", description = "여기는 혜택도 준다던데?")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PlaceDto.class)))
    })
    @GetMapping("/benefit")
    public ResponseEntity<?> getBenefitPosts() {
        List<PlaceDto> places;
        return ResponseEntity.ok(new PlaceDto());
    }
}
