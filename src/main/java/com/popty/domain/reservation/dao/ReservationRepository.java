package com.popty.domain.reservation.dao;

import com.popty.domain.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation getReservationByReservationId(Long reservationId);
    List<Reservation> getReservationsByUserIdAndConfirmed(String userId, int confirmed);
}
