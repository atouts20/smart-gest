package bj.prexed.succursaleservice.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Position implements Serializable {
    private Float lng, lat;

    public Position() {}

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }
}
