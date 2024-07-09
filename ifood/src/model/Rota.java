package model;

public class Rota {
    private Double latitude;
    private Double longitude;
    private Double estimativaTempo;

    public Rota(Double latitude, Double longitude, Double estimativaTempo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimativaTempo = estimativaTempo;
    }

    public Rota() {
       
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getEstimativaTempo() {
        return estimativaTempo;
    }

    public void setEstimativaTempo(Double estimativaTempo) {
        this.estimativaTempo = estimativaTempo;
    }

    public void calcularRota() {
        // Implementar lógica de cálculo de rota usando uma API
        System.out.println("Calculando rota para latitude: " + latitude + ", longitude: " + longitude);
    }

    @Override
    public String toString() {
        return "Rota" +
               "\nLatitude: " + latitude +
               "\nLongitude: " + longitude +
               "\nEstimativa de Tempo: " + estimativaTempo;
    }
}

