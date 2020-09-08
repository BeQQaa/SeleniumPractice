package settings;

public class Data {
    public String getRandNumber() {
        return String.valueOf((int) Math.floor(10 + Math.random() * 9989));
    }
}
