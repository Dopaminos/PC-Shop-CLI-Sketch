import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement
public abstract class Product {
    static Scanner read = new Scanner(System.in);
    private String name;
    private String specs;
    public boolean gaming;
    private String gamingToString;

    public Product(String name, String specs, String gamingToString) {
        this.name = name;
        this.specs = specs;
        this.gamingToString = gamingToString;
        try {

            if (gamingToString == "Да" || gamingToString == ("да"))
                this.gaming = true;

            else if (gamingToString == "Нет" || gamingToString == "нет")
                this.gaming = false;

            else
                throw new IllegalArgumentException(
                        "Параметр 'Игровой' введён неверно\nИзмените его с помощью команды меню №3");

        } catch (IllegalArgumentException e) {
        }
    }

    public Product() {
        this.name = "";
        this.specs = "";
        this.gaming = false;
        this.gamingToString = "Нет";
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @XmlElement
    public String getGaming() {
        return gamingToString;
    }

    public void setGamingToString(String gamingToString) throws IllegalArgumentException {
        try {

            if (gamingToString == "Да" || gamingToString == ("да"))
                this.gaming = true;

            else if (gamingToString.equals("Нет") || gamingToString.equals("нет"))
                this.gaming = false;

            else
                throw new IllegalArgumentException(
                        "Параметр 'Игровой' введён неверно\nИзмените его с помощью команды меню №3");

        } catch (IllegalArgumentException e) {
            setGamingToString(read.nextLine());
        }

    }

    public void productException(String name, String[] brandList) {
        try {
            if (Arrays.stream(brandList).anyMatch(name::contains)) {
                throw new IllegalArgumentException(
                        "Товар или его характеристики введены неверно, попробуйте ещё раз с помощью команды меню №3");
            }
        } catch (IllegalArgumentException e) {
        }

    };

    @Override
    public String toString() {
        return "Название товара: " + name + "\n Характеристики товара: " + specs + "\n Игровой товар: "
                + gamingToString;
    }
}

@XmlRootElement
class PC extends Product {

    public static List<PC> pcs = new ArrayList<>();
    String[] pcBrandList = { "ZET", "DNS", "HYPERPC", "OGO", "HP" };

    // Конструктор с параметрами
    public PC(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(specs, pcBrandList);
    }

    // Конструктор без параметров
    public PC() {
        super("", "", "Нет");
    }
}

@XmlRootElement
class KeyboardMouse extends Product {
    public static List<KeyboardMouse> KeyboardMouses = new ArrayList<>();
    String[] kbmBrandList = { "Razer", "Logitech", "Ducky", "Varmilo", "Steelseries", "HyperX" };

    // Конструктор c параметрами
    public KeyboardMouse(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, kbmBrandList);
    }

    // Конструктор без параметров
    public KeyboardMouse() {
        super("", "", "Нет");
    }
}

@XmlRootElement
class Accessories extends Product {
    public static List<Accessories> Accessoriess = new ArrayList<>();
    String[] accessoriesList = { "DUALSHOCK 4", "Ковёр для мыши XL", "Ковёр для мыши XXL", "Настольная лампа для USB",
            "USB-A -- USB-C Кабель" };

    public Accessories(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, accessoriesList);
    }

    public Accessories() {
        super("", "", "Нет");
    }
}

@XmlRootElement
class Screen extends Product {
    public static List<Screen> Screens = new ArrayList<>();
    String[] screenBrandList = { "SAMSUNG", "LG", "DEXP", "AOC", "AORUS" };

    public Screen(String name, String specs, String gaming) throws IllegalArgumentException {
        super(name, specs, gaming);
        productException(name, screenBrandList);
    }

    public Screen() {
        super("", "", "Нет");
    }

}

@XmlRootElement
class SpareParts extends Product {
    public static List<SpareParts> spareParts = new ArrayList<>();
    String[] sparePartsBrandList = { "Gateron", "Zealios", "Akko", "Krytox", "GD900", "Arctic", "Noctua" };

    public SpareParts(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, sparePartsBrandList);
    }

    public SpareParts() {
        super("", "", "Нет");
    }
}