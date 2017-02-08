package juanlucode.github.com.myrecyclerview;

/**
 * Created by juanluis on 8/02/17.
 */

public final class Site {
    private String name;
    private String address;


    public Site(String name, String address){
        setName(name);
        setAddress(address);
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
}
