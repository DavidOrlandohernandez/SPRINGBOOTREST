package com.local.credit.controller.dto;

public class PersonCustomDto {

    private Long idDto;
    private String nameDto;
    private String lastNameDto;
    private String emailDto;
    private byte ageDto;
    private Character genderDto;

    public PersonCustomDto() {

    }

    public PersonCustomDto(Long idDto, String nameDto, String lastNameDto, String emailDto, byte ageDto, Character genderDto) {
        this.idDto = idDto;
        this.nameDto = nameDto;
        this.lastNameDto = lastNameDto;
        this.emailDto = emailDto;
        this.ageDto = ageDto;
        this.genderDto = genderDto;
    }

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public byte getAgeDto() {
        return ageDto;
    }

    public void setAgeDto(byte ageDto) {
        this.ageDto = ageDto;
    }

    public Character getGenderDto() {
        return genderDto;
    }

    public void setGenderDto(Character genderDto) {
        this.genderDto = genderDto;
    }

    @Override
    public String toString() {
        return "PersonCustomDto{" +
                "idDto=" + idDto +
                ", nameDto='" + nameDto + '\'' +
                ", lastNameDto='" + lastNameDto + '\'' +
                ", emailDto='" + emailDto + '\'' +
                ", ageDto=" + ageDto +
                ", genderDto=" + genderDto +
                '}';
    }
}
