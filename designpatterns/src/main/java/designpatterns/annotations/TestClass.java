package designpatterns.annotations;

/**
 * Created by pourush.sinha on 23/06/18.
 */
public class TestClass {

    @AB(name = "feature3")
    public String getTestClassMethod(String abc){

        return abc + " feature3";

    }
}
