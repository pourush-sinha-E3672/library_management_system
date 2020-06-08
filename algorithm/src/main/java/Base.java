/**
 * Created by pourush.sinha on 03/12/19.
 */
public abstract class Base {
    Base(){
        overrideme();
        populate();
    }

    public void populate() {
        System.out.println("in super class"+this.getClass().toString());
    }


    protected abstract void overrideme();
}
