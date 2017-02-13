package juanlucode.github.com.myrecyclerview.models;

/**
 * Created by juanluis on 8/02/17.
 */

public final class Site {
    private String name;
    private String address;
    private int logo;

    public Site(){
        ;
    }

    public Site(String name, String address, int logo){
        setName(name);
        setAddress(address);
        setLogo(logo);
    }

    public String getName(){

        return this.name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getAddress(){

        return this.address;
    }

    public void setAddress(String address){

        this.address = address;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
