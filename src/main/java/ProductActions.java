import java.util.Scanner;

public class ProductActions {

    static Scanner read = new Scanner(System.in);
    int numChoiceMenu, numChoiceGroup; 
    String name, specs, gaming;
    public void menuElements() {
        System.out.println("Выберите группу товара:");
        System.out.println("1. Готовые ПК"); // PC 
        System.out.println("2. Клавиатуры и мыши"); // KeyboardMouse
        System.out.println("3. Аксессуары"); // Accessories
        System.out.println("4. Мониторы"); // Screens
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
                    
                    case 1: { addPC(); break;             }
                    case 2: { addKeyboardMouse(); break;  }
                    case 3: { addAccessories(); break;    }
                    case 4: { addScreen(); break;         }
                    case 5: { addSpareParts(); break;     }
                    default:{ break;                      }
                    
                }
                mainMenu();
                break;
            //Удаление
            case 2:
            menuElements(); numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {
                    
                    case 1: { removePC(); break;             }
                    case 2: { removeKeyboardMouse(); break;  }
                    case 3: { removeAccessories(); break;    }
                    case 4: { removeScreen(); break;         }
                    case 5: { removeSpareParts(); break;     }
                    default:{ break;                         }

                }
                mainMenu();
                break;
            //Изменение параметров
            case 3:
            menuElements();  numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {

                    case 1: { changePC(); break;             }
                    case 2: { changeKeyboardMouse(); break;  }
                    case 3: { changeAccessories(); break;    }
                    case 4: { changeScreen(); break;         }
                    case 5: { changeSpareParts(); break;     }
                    default:{ break;                         }

                }
                mainMenu();
                break;
            case 4:
            menuElements(); numChoiceGroup = read.nextInt();
                switch (numChoiceGroup) {

                    case 1: { displayPC(); break;              }
                    case 2: { displayKeyboardMouse(); break;   }
                    case 3: { displayAccessories(); break;     }
                    case 4: { displayScreen(); break;          }
                    case 5: { displaySpareParts(); break;      }
                    default:{ break;                           } 

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

        String specs = read.nextLine(); 
        System.out.println("Введите параметры товара: ");
        
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
        System.out.println("Добавлен монитор:\n" + Screen);
    }

    public void addSpareParts() {
        parametersInput();
        SpareParts SpareParts = new SpareParts(name, specs, gaming);
        SpareParts.spareParts.add(SpareParts);
        System.out.println("Добавлена запчасть или расходник:\n" + SpareParts);
    }
    
    public void removePC() {
        System.out.println("| Удаление ПК |\n");
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
        System.out.println("| Удаление клавиатуры или мыши |");
        parametersInput();
        read.skip("");
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {

                System.out.println("Удалена клавиатура или мышь:" + obj);
                KeyboardMouse.KeyboardMouses.remove(obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
        
    }

    public void removeAccessories() {
        read.nextLine();
        
        System.out.println("| Удаление аксессуара |");
        parametersInput();
        read.skip("");
        for (Accessories obj : Accessories.Accessoriess) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                
                System.out.println("Удалён аксессуар:" + obj);
                Accessories.Accessoriess.remove(obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void removeScreen() {
        read.nextLine();
        
        System.out.println("| Удаление монитора |");
        parametersInput();
        read.skip("");
        for (Screen obj : Screen.Screens) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                
                System.out.println("Удалён монитор:" + obj);
                Screen.Screens.remove(obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void removeSpareParts() {
        read.nextLine();
        
        System.out.println("| Удаление запчастей или расходников ");
        parametersInput();
        read.skip("");
        for (SpareParts obj : SpareParts.spareParts) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                
                System.out.println("Удалена запчасть или расходник:" + obj);
                SpareParts.spareParts.remove(obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void changePC() {
        read.nextLine();
        
        parametersInput();
        for (PC obj : PC.pcs) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                
                System.out.println("Введите новое название товара: ");
                obj.setName(read.nextLine());
                System.out.println("Введите новые параметры товара: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Игровой товар?: ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Товар изменён: " + obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void changeKeyboardMouse() {
        read.nextLine();
        
        parametersInput();
        String gaming = read.nextLine();
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                
                System.out.println("Введите новое название товара: ");
                obj.setName(read.nextLine());
                System.out.println("Введите новые параметры товара: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Игровой товар?: ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Товар изменён: " + obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void changeAccessories() {
        read.nextLine();
        parametersInput();
        String gaming = read.nextLine();
        for (Accessories obj : Accessories.Accessoriess) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                System.out.println("Введите новое название товара: ");
                obj.setName(read.nextLine());
                System.out.println("Введите новые параметры товара: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Игровой товар?: ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Товар изменён: " + obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void changeScreen() {
        read.nextLine();
        parametersInput();
        String gaming = read.nextLine();
        for (Screen obj : Screen.Screens) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                System.out.println("Введите новое название товара: ");
                obj.setName(read.nextLine());
                System.out.println("Введите новые параметры товара: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Игровой товар?: ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Товар изменён: " + obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
    }

    public void changeSpareParts() {
        read.nextLine();  
        parametersInput();
        String gaming = read.nextLine();
        for (SpareParts obj : SpareParts.spareParts) {
            if (obj.getName() == name && obj.getSpecs() == specs && obj.getGaming() == gaming) {
                System.out.println("Введите новое название товара: ");
                obj.setName(read.nextLine());
                System.out.println("Введите новые параметры товара: ");
                obj.setSpecs(read.nextLine());
                System.out.println("Игровой товар?: ");
                obj.setGamingToString(read.nextLine());
                System.out.println("Товар изменён: " + obj);
                break;
            }
            else System.out.println("Товар не найден");
        }
        
    }

    public void displayPC() {
        System.out.println("Готовые ПК: ");
        for (PC obj : PC.pcs) {
            System.out.println(obj);
        }
        if (PC.pcs.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayKeyboardMouse() {
        System.out.println("Клавиатуры и мыши: ");
        for (KeyboardMouse obj : KeyboardMouse.KeyboardMouses) {
            System.out.println(obj);
        }
        if (KeyboardMouse.KeyboardMouses.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayAccessories() {
        System.out.println("Аксессуары: ");
        for (Accessories obj : Accessories.Accessoriess) {
            System.out.println(obj);
        }
        if (Accessories.Accessoriess.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayScreen() {
        System.out.println("Мониторы: ");
        for (Screen obj : Screen.Screens) {
            System.out.println(obj);
        }
        if (Screen.Screens.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displaySpareParts() {
        System.out.println("Запчасти и расходники: ");
        for (SpareParts obj : SpareParts.spareParts) {
            System.out.println(obj);
        }
        if (SpareParts.spareParts.isEmpty()) System.out.println("Отсутствуют");
    }

    public void displayAll() {
        System.out.println("Все товары: ");
        displayPC();
        displayKeyboardMouse();
        displayAccessories();
        displayScreen();
        displaySpareParts();
    }
}
