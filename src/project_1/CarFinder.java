package project_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface findBlackToyota {
    public String findBlackToyota();
}

interface changeColor {
    public void setColor(String color);
}

/**
 * This class is used to find a black Toyota in five candidate cars.
 * Created by chenzhaohui
 * ID 201728018627076
 */
public class CarFinder {

    public static void main(String args[]) {
        /*实例化一个警察对象,警察对象找黑色丰田车*/
        Police mPolice = new Police();
        System.out.println("车牌号:" + mPolice.findBlackToyota());
    }
}

/**
 * 警察类
 */
class Police implements findBlackToyota {
    Map<String, Car> cars;

    public Police() {
        /*构造函式,初始化汽车库,汽车库中仅有一辆黑色丰田*/
        Volkswagen volkswagen1 = new Volkswagen(true, "Volkswagen", 3200.0, 23.3f);
        Toyota toyota1 = new Toyota(true, "Toyota", 3200.0, 14.5f);
        Toyota toyota2 = new Toyota(false, "Toyota", 0.0, 16.5f);
        Toyota toyota3 = new Toyota(true, "Toyota", 0.0, 25.3f);
        Porsche porsche1 = new Porsche(true, "Porsche", 3200.0, 23.3f);

        toyota1.setColor("白色");
        toyota2.setColor("黑色");
        toyota3.setColor("红色");

        List<String> ID = new ArrayList<String>(5);
        for (int i = 0; i < 5; i++) {
            ID.add("京A" + i + i + i + i + i);
        }

        cars = new HashMap<String, Car>();
        cars.put(ID.get(0), volkswagen1);
        cars.put(ID.get(1), toyota1);
        cars.put(ID.get(2), toyota2);
        cars.put(ID.get(3), toyota3);
        cars.put(ID.get(4), porsche1);
    }

    @Override
    public String findBlackToyota() {

        for (int i = 0; i < 5; i++) {
            Car mCandidatecar = cars.get("京A" + i + i + i + i + i);
            mCandidatecar.setID("京A" + i + i + i + i + i);
            if (!mCandidatecar.used & mCandidatecar.getBrand().equals("Toyota")) {
                String detail = new String("找到一辆价值" + mCandidatecar.getPrice() + "万元的" + mCandidatecar.getColor() + mCandidatecar.getBrand() + "车");
                System.out.println(detail);
                return mCandidatecar.getID();
            }
        }
        return "NOT FOUND!";
    }
}

/**
 * 汽车基类
 */
abstract class Car {
    boolean used; //true标识旧车
    String brand; //汽车品牌
    double mileage; //汽车里程
    float price; //汽车购买价格
    String color; //汽车颜色
    private String ID; //车牌号

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public double getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

/*丰田*/
class Toyota extends Car implements changeColor {
    public Toyota(boolean used, String brand, double mileage, float price) {
        this.used = used;
        this.brand = brand;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

/*大众*/
class Volkswagen extends Car {
    public Volkswagen(boolean used, String brand, double mileage, float price) {
        this.used = used;
        this.brand = brand;
        this.mileage = mileage;
        this.price = price;
        this.color = "白色";
    }
}

/*保时捷*/
class Porsche extends Car {
    public Porsche(boolean used, String brand, double mileage, float price) {
        this.used = used;
        this.brand = brand;
        this.mileage = mileage;
        this.price = price;
        this.color = "灰色";
    }
}
