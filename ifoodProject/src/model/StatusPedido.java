package model;

import java.time.LocalDateTime;

public class StatusPedido {
    private Status status;
    private LocalDateTime horarioStatus;

    public StatusPedido(Status status) {
		super();
		this.status = status;
		this.horarioStatus = LocalDateTime.now();
	}
    

	public StatusPedido(Status status, LocalDateTime horarioStatus) {
		super();
		this.status = status;
		this.horarioStatus = horarioStatus;
	}

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