package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneInfo {
    @XmlElement
    private String phone;

    @XmlElement
    private boolean isMain;

    public PhoneInfo() {}

    public PhoneInfo(String phone, boolean isMain) {
        this.phone = phone;
        this.isMain = isMain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    @Override
    public String toString() {
        return String.format("%s - %s основной", phone, isMain ? "" : "не");
    }
}
