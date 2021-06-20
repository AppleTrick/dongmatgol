package du_cs.dongmatgol;

/**
 * Created by yuven on 2016-06-07.
 */
public class valueset {
    private String name;
    private String group;
    private String tel;
    private int Fimage;
    private int number;

    public valueset(String name,String group,String tel,int Fimage,int number){
        this.name=name;
        this.group=group;
        this.tel=tel;
        this.Fimage=Fimage;
        this.number=number;
    }
    public int getNumber() {return this.number;}
    public String getName(){
        return this.name;
    }
    public String getGroup(){
        return this.group;
    }
    public String getTel(){
        return this.tel;
    }
    public int getFimage(){
        return this.Fimage;
    }
}

