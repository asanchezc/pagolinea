package pe.farmaciasperuanas.reporte.pojo;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private List<String> localIds = new ArrayList<String>();
    private String dateDelivery;

    public List<String> getLocalIds() {
        return localIds;
    }

    public void setLocalIds(List<String> localIds) {
        this.localIds = localIds;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }
}
