package com.gola.myappstt;

public class model
{
    String name, email,purl,detl ;

    public model(){

    }

    public model(String name, String email, String purl, String detl) {
        this.name = name;
        this.email = email;
        this.purl= purl;
        this.detl=detl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getDetl() {
        return detl;
    }

    public void setDetl(String detl) {
        this.detl = detl;
    }
}
