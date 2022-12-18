import java.util.Scanner;
import java.util.*;

public class doAnimals {

    static Scanner read = new Scanner(System.in);
    int numChoiceMenu, numChoiceGroup; 
    String name; String specs; String gaming;
    public void menuElements() {
        System.out.println("Выберите группу товара:");
        System.out.println("1. Готовые ПК"); // PC 
        System.out.println("2. Клавиатуры и мыши"); // KeyboardMouse
        System.out.println("3. Аксессуары"); // Accessories
        System.out.println("4. Мониторы"); // screen
        System.out.println("5. Запчасти и расходники для периферии"); // SpareParts
    }
    
    public void mainMenu() {

        System.out.println("\nВведите команду: ");
        System.out.println("1. Добавить товар");
        System.out.println("2. Удалить товар");
        System.out.println("3. Изменить товар");
        System.out.println("4. Отобразить наличие");
        System.out.println("5. Сохранить данные в XML");
        System.out.println("6. Получить данные из XML");
        System.out.println("7. Завершить работу c меню");
        numChoiceMenu = read.nextInt();
        switch (numChoiceMenu) {
            //Добавление
            case 1:
                menuElements(); numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {
                    
                    case 1: { addPC(); break;     }
                    case 2: { addKeyboardMouse(); break;   }
                    case 3: { addAccessories(); break;  }
                    case 4: { addScreen(); break;}
                    case 5: { addspareParts(); break;     }
                    default:{ break;                }
                    
                }
                mainMenu();
                break;
            //Удаление
            case 2:
            menuElements(); numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {
                    
                    case 1: { removePC(); break;     }
                    case 2: { removeKeyboardMouse(); break;   }
                    case 3: { removeAccessories(); break;  }
                    case 4: { removeScreen(); break;}
                    case 5: { removespareParts(); break;     }
                    default:{ break;                   }

                }
                mainMenu();
                break;
            //Изменение параметров
            case 3:
            menuElements();  numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {

                    case 1: { changePC(); break;     }
                    case 2: { changeKeyboardMouse(); break;   }
                    case 3: { changeAccessories(); break;  }
                    case 4: { changeScreen(); break;}
                    case 5: { changespareParts(); break;     }
                    default:{ break;                   }

                }
                mainMenu();
                break;
            case 4:
            menuElements(); numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {

                    case 1: { displayPC(); break;     }
                    case 2: { displayKeyboardMouse(); break;   }
                    case 3: { displayAccessories(); break;  }
                    case 4: { displayScreen(); break;}
                    case 5: { displayspareParts(); break;     }
                    default:{ break;                    } 

                }
                mainMenu();
                break;

            case 5: { Main.writeToXML(); mainMenu(); break; }
            case 6: { Main.readFromXML(); mainMenu(); break;                   }
            case 7: { System.out.println("Работа с меню завершена"); break; }
            default: { mainMenu(); break;}

        }
    }
public void parametersInput() {
    String name = read.nextLine();
    System.out.println("Введите название товара: ");

    System.out.println("Введите параметры товара: ");
    String specs = read.nextLine();
    
    System.out.println("Игровой товар?: ");
    String gamingToString = read.nextLine();
}
    public void addPC() {
        parametersInput();
        PC pc = new PC(name, specs, gaming);
        PC.pcs.add(pc);
        System.out.println("Добавлен ПК: " + pc);
    }

    public void addKeyboardMouse() {
        parametersInput();
        KeyboardMouse KeyboardMouse = new KeyboardMouse(name, specs, gaming);
        KeyboardMouse.KeyboardMouses.add(KeyboardMouse);
        System.out.println("Добавлена клавиатура или мышь: " + KeyboardMouse);
    }

    public void addAccessories() {
        parametersInput();
        Accessories Accessories = new Accessories(name, specs, gaming);
        Accessories.Accessoriess.add(Accessories);
        System.out.println("Добавлен аксессуар: " + Accessories);
    }

    public void addScreen() {
        parametersInput();
        Screen Screen = new Screen(name, specs, gaming);
        Screen.Screens.add(Screen);
        System.out.println("Добавлено земноводное (амфибия) с параметрами:\n" + Screen);
    }

    public void addspareParts() {
        parametersInput();
        SpareParts SpareParts = new SpareParts(name, specs, gaming);
        SpareParts.spareParts.add(SpareParts);
        System.out.println("Добавлена рыба с параметрами:\n" + SpareParts);
    }
    
    public void removePC() {
        System.out.println("| Удаление ПК из БД |\n");
        parametersInput();
        for (PC obj : PC.pcs) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                System.out.println("Удалён ПК:" + obj);
                PC.pcs.remove(obj);
                break;
            }
            else System.out.println("Товар не найден");

        }
    }

    public void removeKeyboardMouse() {
        read.nextLine();
        System.out.println("!!! Удаление млекопитающего !!!");
        parametersInput();
        read.skip("");
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {

                System.out.println("Удалено млекопитающее с параметрами:" + obj);
                KeyboardMouse.KeyboardMouses.remove(obj);
                break;
            }
            else System.out.println("Такое млекопитающее не найдено");
        }
        
    }

    public void removeAccessories() {
        read.nextLine();
        boolean exists = false;
        System.out.println("!!! Удаление пресмыкающегося (рептилии) !!!");
        parametersInput();
        read.skip("");
        for (Accessories obj : Accessories.Accessoriess) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Удалено пресмыкающееся (рептилия) с параметрами:" + obj);
                Accessories.Accessoriess.remove(obj);
                break;
            }
        }
        if (!exists) System.out.println("Такое пресмыкающееся (рептилия) не найдено");
    }

    public void removeScreen() {
        read.nextLine();
        boolean exists = false;
        System.out.println("!!! Удаление земноводного (амфибии) !!!");
        parametersInput();
        read.skip("");
        for (Screen obj : Screen.Screens) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Удалено земноводное (амфибия) с параметрами:" + obj);
                Screen.Screens.remove(obj);
                break;
            }
        }
        if (!exists) System.out.println("Такое земноводное (амфибия) не найдено");
    }

    public void removespareParts() {
        read.nextLine();
        boolean exists = false;
        System.out.println("!!! Удаление рыбы !!!");
        parametersInput();
        read.skip("");
        for (SpareParts obj : SpareParts.spareParts) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Удалена рыба с параметрами:" + obj);
                SpareParts.spareParts.remove(obj);
                break;
            }
        }
        if (!exists) System.out.println("Такая рыба не найдена");
    }

    public void changePC() {
        read.nextLine();
        boolean exists = false;
        parametersInput();
        for (PC obj : PC.pcs) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Введите желаемое название птицы: ");
                obj.setName(read.nextLine());
                System.out.println("Введите желаемый размер птицы: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Введите желаемую хищность птицы (да/нет): ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Параметры птицы изменены на: " + obj);
                break;
            }
        }
        if (!exists) System.out.println("Такая птица не найдена");
    }

    public void changeKeyboardMouse() {
        read.nextLine();
        boolean exists = false;
        parametersInput();
        String gaming = read.nextLine();
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Введите желаемое название млекопитающего: ");
                obj.setName(read.nextLine());
                System.out.println("Введите желаемый размер млекопитающего: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Введите желаемую хищность млекопитающего (да/нет): ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Параметры млекопитающего изменены на: " + obj);
                break;
            }
        }
        if (!exists) System.out.println("Такое млекопитающее не найдено");
    }

    public void changeAccessories() {
        read.nextLine();
        boolean exists = false;
        parametersInput();
        String gaming = read.nextLine();
        for (Accessories obj : Accessories.Accessoriess) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Введите желаемое название пресмыкающегося (рептилии): ");
                obj.setName(read.nextLine());
                System.out.println("Введите желаемый размер пресмыкающегося (рептилии): ");
                obj.setSpecs(read.nextLine());
                System.out.println("Введите желаемую хищность пресмыкающегося (рептилии) (да/нет): ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Параметры пресмыкающегося (рептилии) изменены на: " + obj);
                break;
            }
        }
        if (!exists) System.out.println("Такое пресмыкающееся (рептилия) не найдено");
    }

    public void changeScreen() {
        read.nextLine();
        boolean exists = false;
        parametersInput();
        String gaming = read.nextLine();
        for (Screen obj : Screen.Screens) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Введите желаемое название земноводного (амфибии): ");
                obj.setName(read.nextLine());
                System.out.println("Введите желаемый размер земноводного (амфибии): ");
                obj.setSpecs(read.nextLine());
                System.out.println("Введите желаемую хищность земноводного (амфибии) (да/нет): ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Параметры земноводного (амфибии) изменены на: " + obj);
                break;
            }
        }
        if (!exists) System.out.println("Такаое земноводное (амфибия) не найдено");
    }

    public void changespareParts() {
        read.nextLine();
        boolean exists = false;
        parametersInput();
        String gaming = read.nextLine();
        for (SpareParts obj : SpareParts.spareParts) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                exists = true;
                System.out.println("Введите желаемое название рыбы: ");
                obj.setName(read.nextLine());
                System.out.println("Введите желаемый размер рыбы: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Введите желаемую хищность рыбы (да/нет): ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Параметры рыбы изменены на: " + obj);
                break;
            }
        }
        if (!exists) System.out.println("Такая рыба не найдена");
    }

    public void displayPC() {
        System.out.println("Птицы: ");
        for (PC obj : PC.pcs) {
            System.out.println(obj);
        }
        if (PC.pcs.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayKeyboardMouse() {
        System.out.println("Млекопитающие: ");
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            System.out.println(obj);
        }
        if (KeyboardMouse.KeyboardMouses.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayAccessories() {
        System.out.println("Пресмыкающиеся (рептилии): ");
        for (Accessories obj : Accessories.Accessoriess) {
            System.out.println(obj);
        }
        if (Accessories.Accessoriess.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayScreen() {
        System.out.println("Земноводные (амфибии): ");
        for (Screen obj : Screen.Screens) {
            System.out.println(obj);
        }
        if (Screen.Screens.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayspareParts() {
        System.out.println("Рыбы: ");
        for (SpareParts obj : SpareParts.spareParts) {
            System.out.println(obj);
        }
        if (SpareParts.spareParts.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayAll() {
        System.out.println("Вывод всех животных: ");
        displayPC();
        displayKeyboardMouse();
        displayAccessories();
        displayScreen();
        displayspareParts();
    }
}