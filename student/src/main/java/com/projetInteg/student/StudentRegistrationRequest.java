package com.projetInteg.student;

public record StudentRegistrationRequest(
        String firstName,
        String lastName,
        Long matricule,
        String email) {
}
