package model;

import java.time.LocalDateTime;

public class StatusPedido {
    private Status status;
    private LocalDateTime horarioStatus;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getHorarioStatus() {
        return horarioStatus;
    }

    public void setHorarioStatus(LocalDateTime horarioStatus) {
        this.horarioStatus = horarioStatus;
    }

    public void editarStatus(Status novoStatus) {
        setStatus(novoStatus);
        setHorarioStatus(LocalDateTime.now());
    }
    

    @Override
    public String toString() {
        return "StatusPedido{" +
                "status=" + status +
                ", horarioStatus=" + horarioStatus +
                '}';
    }
}
