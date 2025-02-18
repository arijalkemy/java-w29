package com.example.Seguros_Autos.DTO;

public class VehiculoSiniestroDTO {
        private String patente;
        private String marca;
        private String modelo;

        public VehiculoSiniestroDTO(String patente, String marca, String modelo) {
            this.patente = patente;
            this.marca = marca;
            this.modelo = modelo;
        }

        // Getters and Setters
        public String getPatente() {
            return patente;
        }

        public void setPatente(String patente) {
            this.patente = patente;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }
    }


