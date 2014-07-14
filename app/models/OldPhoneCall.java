package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class OldPhoneCall extends Model {
	public String phone;
    public String delay;
    public Date created;
    
    public OldPhoneCall(String phone, String delay) {
        this.phone = phone;
        this.delay = delay;
        this.created = new Date();
    }
    
    public OldPhoneCall(String phone, String delay, Date created) {
        this.phone = phone;
        this.delay = delay;
        this.created = created;
    }
}
