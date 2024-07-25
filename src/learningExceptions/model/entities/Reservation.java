package learningExceptions.model.entities;

import learningExceptions.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if(!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public final Integer getRoomNumber() {
        return roomNumber;
    }

    public final void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public final LocalDate getCheckIn() {
        return checkIn;
    }

    public final LocalDate getCheckOut() {
        return checkOut;
    }

    public final int duration() {
        return this.checkOut.compareTo(this.checkIn);
    }

    public final void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        LocalDate now = LocalDate.now();

        if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        } else if(checkOut.isBefore(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        } else {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    @Override
    public final String toString() {
        return "Reservation: Room "
                + this.roomNumber
                + ", check-in: " + this.formatter.format(this.checkIn)
                + ", check-out: " + this.formatter.format(this.checkOut)
                + ", " + this.duration() + " nights";
    }
}
