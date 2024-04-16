package com.example.headhunter.Model;

/*
 * Model который используется для использования как рецепт для вакансии
 * все эти поля будут содержать вакансии которые будут публиковаться
 *
 * */
public class Data {

    String title;
    String description;
    String skills;
    String salary;
    String email;

    String id;
    String date;

    String companyName;
    String companyEmail;
    String aboutCompany;
    String companyAddress;

    public int getLogoImageResource() {
        return logoImageResource;
    }

    public void setLogoImageResource(int logoImageResource) {
        this.logoImageResource = logoImageResource;
    }

    int logoImageResource;


    public Data() {}



    public Data(String title, String description, String skills, String salary, String id, String date, String email, String companyName, String companyEmail, String aboutCompany, String companyAddress,int logoImageResource) {
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.salary = salary;
        this.id = id;
        this.date = date;
        this.email = email;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.aboutCompany = aboutCompany;
        this.companyAddress = companyAddress;
        this.logoImageResource = logoImageResource;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
