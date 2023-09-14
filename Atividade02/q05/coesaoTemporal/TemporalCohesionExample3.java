package Atividade02.q05.coesaoTemporal;

import java.util.HashMap;
import java.util.Map;

public class TemporalCohesionExample3 {
    private Map<String, String> defaultConfigurations;

    public TemporalCohesionExample3() {
        // Método de inicialização que fornece valores padrão para configurações diferentes
        initializeDefaultConfigurations();
    }

    private void initializeDefaultConfigurations() {
        defaultConfigurations = new HashMap<>();
        defaultConfigurations.put("DatabaseHost", "localhost");
        defaultConfigurations.put("DatabasePort", "3306");
        defaultConfigurations.put("Username", "user");
        defaultConfigurations.put("Password", "password");
    }

    public void setConfiguration(String key, String value) {
        // Configurar ou modificar uma configuração
        defaultConfigurations.put(key, value);
    }

    public String getConfiguration(String key) {
        // Obter o valor de uma configuração
        return defaultConfigurations.get(key);
    }

    public void cleanup() {
        // Método de finalização que limpa as configurações antes de terminar
        defaultConfigurations.clear();
    }

    public static void main(String[] args) {
        TemporalCohesionExample3 example = new TemporalCohesionExample3();
        
        // Configurando valores personalizados
        example.setConfiguration("DatabaseHost", "db.example.com");
        example.setConfiguration("Username", "admin");

        // Obtendo e exibindo configurações
        System.out.println("Database Host: " + example.getConfiguration("DatabaseHost"));
        System.out.println("Username: " + example.getConfiguration("Username"));

        // Limpando configurações antes de encerrar
        example.cleanup();
    }
}