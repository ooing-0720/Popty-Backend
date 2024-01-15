package com.popty.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Location {
    MANGWON("망원"),
    HAPJEONG("합정"),
    SANGSU("상수"),
    HONGDAE("홍대입구"),
    YEONNAM("연남"),
    SINCHON("신촌"),
    SEONGSU("성수"),
    GEONDAE("건대입구"),
    SEOULSOUP("서울숲"),
    APGUJEONG("압구정"),
    GANGNAM("강남"),
    YONGSAN("용산"),
    HYEHWA("혜화"),
    SUWON("수원"),
    DAEJEON("대전"),
    DAEGU("대구"),
    BUSAN("부산"),
    GWANGJU("광주"),
    OVERSEAS("해외");

    private String location;
}
