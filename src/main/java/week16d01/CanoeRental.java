package week16d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CanoeRental {
    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;

    public CanoeRental(String name, CanoeType canoeType, String dateTimeString){
        this.name = name;
        this.canoeType = canoeType;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        this.startTime = LocalDateTime.parse(dateTimeString, f);
        active = true;
    }

    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
        active = false;
    }

    public double calculateRentalSum(){
        long durationMin = Duration.between(this.startTime, this.endTime).toMinutes();
        double duration = Math.ceil(durationMin / 60.0);
        double rentalSum = 5000 * duration * this.canoeType.colourPrice;
        return rentalSum;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
