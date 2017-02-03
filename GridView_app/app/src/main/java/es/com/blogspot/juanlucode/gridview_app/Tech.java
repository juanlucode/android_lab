package es.com.blogspot.juanlucode.gridview_app;

/**
 * Created by juanluis on 3/02/17.
 */

public final class Tech {

    public Tech(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    private String name;
    private String field;


}
