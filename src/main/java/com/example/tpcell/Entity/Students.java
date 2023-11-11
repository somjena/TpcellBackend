package com.example.tpcell.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
@Data
@Entity
@Table(name = "student")
public class Students {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "regd_id", nullable = false)
        private Integer reg_Id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "e_mail")
        private String eMail;
        @Column(name = "number")
        private BigInteger number;
        @Column(name = "department")
        private String department;
        @Column(name = "password")
        private String password;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getReg_Id() {
                return reg_Id;
        }

        public void setReg_Id(Integer reg_Id) {
                this.reg_Id = reg_Id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String geteMail() {
                return eMail;
        }

        public void seteMail(String eMail) {
                this.eMail = eMail;
        }

        public BigInteger getNumber() {
                return number;
        }

        public void setNumber(BigInteger number) {
                this.number = number;
        }

        public String getDepartment() {
                return department;
        }

        public void setDepartment(String department) {
                this.department = department;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
