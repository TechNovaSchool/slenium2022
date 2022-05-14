package configurationExample;

public class Singelton {

    private Singelton(){

    }

    private static String example;

    public static String getExample(){
        if(example == null) {
            System.out.println("My singelton setup");
            example = "my ex value";
        }
        else {
            System.out.println("My example already has a value");
        }
        return example;
    }

}
