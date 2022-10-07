package preReq;

import general.MainCall;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import general.EnvGlobals;


public class TestBase {
    public TestBase(){}

    static int sysCount = 7;
    static  List<Integer> randList = new ArrayList<>();
    static  List<String> sysNames = new ArrayList<>();
    static  List<Integer> sysId = new ArrayList<>();


    public static void setup() throws SQLException {
        randList = MainCall.generalFunctions.generateRandomNumSystem(5, sysCount);
        String name = "";

//        TestPage.getSystems();
//
//        data();
//
//        for (int i=0 ; i<sysCount ; i++) {
//            name = "AutoSystem" + i;
//            sysNames.add(name + "_" + randList.get(i));

            TestPage.saveAsSystems("system", "3" ,3);
        }


    public static void data(){
        String name = "";
        int systemsSize = EnvGlobals.response.body().path("systems.size()");

        for (int i=0 ; i<systemsSize ; i++) {
            name = EnvGlobals.response.body().path("systems[" + i + "].name");

            for (int j=0 ; j<sysCount ; j++) {
                if (name.equals("AutoSystem" + j)){
                    sysId.add((Integer) EnvGlobals.response.body().path("systems["+ i +"].id"));
                    break;
                }
            }
        }
    }
}
