import javax.xml.bind.annotation.*;
import java.util.*;

//Абстрактный класс животные
@XmlRootElement
public abstract class Animals {
    static Scanner read = new Scanner(System.in);
    private String name;
    private String specs;
    public boolean gaming;
    private String gamingToString;

    //Конструктор c параметрами
    public Animals(String name, String specs, String gamingToString) {
        this.name = name;
        this.specs = specs;
        this.gamingToString = gamingToString;
        try {
            if (gamingToString.equals("Да") || gamingToString.equals("да")) this.gaming = true;
            else if (gamingToString.equals("Нет") || gamingToString.equals("нет")) this.gaming = false;
            else throw new IllegalArgumentException("Неправильно введено хищничество");
        } catch (IllegalArgumentException e) {
            System.out.println("Введённый параметр хищничества не соответствует да/нет");
            System.out.println("Измените параметр с помощью команды меню №3");
        }
    }

    //Конструктор без параметров
    public Animals() {
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
            if (gamingToString.equals("Да") || gamingToString.equals("да")) {
                this.gamingToString = gamingToString;
                this.gaming = true;
            } else if (gamingToString.equals("Нет") || gamingToString.equals("нет")) {
                this.gamingToString = gamingToString;
                this.gaming = false;
            } else throw new IllegalArgumentException("Введён неправильный аргумент хищничества");

        } catch (IllegalArgumentException e) {
            System.out.println("Введён неправильный аргумент хищничества");
            System.out.println("Введите хищничество заново (да/нет)");
            setGamingToString(read.nextLine());
        }

    }
    public void productException (String name, String[] brandList) {
        try {
        if (Arrays.stream(brandList).anyMatch(name::contains)) {
            throw new IllegalArgumentException("Товар или его характеристики введены неверно, попробуйте ещё раз с помощью команды меню №3");
        }
        }
        catch (IllegalArgumentException e) {}

    }; 
    @Override
    public String toString() {
        return "Название товара: " + name + "\n Характеристики товара: " + specs + "\n Игровой товар: " + gamingToString;
    }
}


//Птицы
@XmlRootElement
class PC extends Animals {

    public static List<PC> pcs = new ArrayList<>();
    String[] pcBrandList = {"AMD", "NVIDIA", "INTEL"};
    //Конструктор с параметрами
    public PC(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(specs, pcBrandList);
    }

    //Конструктор без параметров
    public PC() {
        super("", "", "Нет");
    }
}
 
//Млекопитающие
@XmlRootElement
class KeyboardMouse extends Animals {
    public static List<KeyboardMouse> KeyboardMouses = new ArrayList<>();
    String[] kbmBrandList = {"Razer", "Logitech", "Ducky", "Varmilo", "Steelseries", "HyperX"}; 
    //Конструктор c параметрами
    public KeyboardMouse(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, kbmBrandList);
    }

    //Конструктор без параметров
    public KeyboardMouse() {
        super("", "", "Нет");
    }
}


@XmlRootElement
class Accessories extends Animals {
    public static List<Accessories> Accessoriess = new ArrayList<>();
    String[] accessoriesList = {"DUALSHOCK 4", "Ковёр для мыши XL", "Ковёр для мыши XXL", "Настольная лампа для USB", "USB-A -- USB-C Кабель"};


    public Accessories(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, accessoriesList);
    }


    public Accessories() {
        super("", "", "Нет");
    }
}

//Земноводные
@XmlRootElement
class Screen extends Animals {
    public static List<Screen> Screens = new ArrayList<>();
    String[] screenBrandList = {"SAMSUNG", "LG", "DEXP", "AOC", "AORUS"};

    public Screen(String name, String specs, String gaming) throws IllegalArgumentException {
        super(name, specs, gaming);
        productException(name, screenBrandList);
    }


    public Screen() {
        super("", "", "Нет");
    }

}

//Рыбы
@XmlRootElement
class SpareParts extends Animals {
    public static List<SpareParts> spareParts = new ArrayList<>();
    String[] sparePartsBrandList = {"Gateron", "Zealios", "Akko", "Krytox", "GD900", "Arctic", "Noctua"}; 


    public SpareParts(String name, String specs, String gaming) {
        super(name, specs, gaming);
        productException(name, sparePartsBrandList);
        }


    //Конструктор без параметров
    public SpareParts() {
        super("", "", "Нет");
    }
}