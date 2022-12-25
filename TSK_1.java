import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class TSK_1
{
    static long CheckNumbers(String param)
    {
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.printf(param + ": ");
            if (iScanner.hasNextLong() == true)
            {
                long number = iScanner.nextLong();
                if (number > 0 && ((int)(number/10000000000L)) == 8)  
                {
                    return number;
                }
                else
                {
                    System.out.println("Номер введен неправильно.");
                    continue;
                }
            }
            else
            {
                System.out.println("Номер введен неправильно.");
                continue;
            }
        }
    }

    static HashMap<Long, String> Add(HashMap<Long, String> innerData)
    {
        long phone = CheckNumbers("Введите номер телефона");
        if (innerData.containsKey(phone))
        {
            System.out.println("Такой номер уже есть в базе данных.");
        }
        else
        {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("Введите абонента: ");
            String human = iScanner.nextLine();
            innerData.put(phone, human);
            System.out.println("Данные записаны.");
        }
        return innerData;
    }

    static HashMap<Long, String> Delete(HashMap<Long, String> innerData)
    {
        long phone = CheckNumbers("Введите номер телефона для удаления");
        if (innerData.containsKey(phone))
        {
            innerData.remove(phone);
            System.out.printf("Номер %d удален.\n", phone);
        }
        else System.out.println("Такого номера нет.");
        return innerData;
    }

    static void List(HashMap<Long, String> innerData)
    {
        Object[] phones = innerData.keySet().toArray();
        Object[] humans = new ArrayList<>(innerData.values()).toArray();
        for (int i = 0; i < innerData.size(); i++)
        {
            System.out.printf("Номер: %d, Абонент: %s\n", phones[i], humans[i]);
        }         
    }

    public static void main(String[] args)
    {
        HashMap<Long, String> DB = new HashMap<>();
        System.out.println("Это система хрнения данных о номерах российских телефонов пользователей.\n");
        System.out.println("Для записи телефона и пользователя введите add.");
        System.out.println("Для удаления телефона и пользователя введите delete.");
        System.out.println("Для вывода списка телефонов и пользователей введите list.");
        System.out.println("Для вывода списка команд введите help.");
        System.out.println("Для выхода из программы введите exit.");
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Введите команду:");
            String cmd = iScanner.nextLine();
            if (cmd.equals("add"))
            {
                DB = Add(DB);
            }
            else if (cmd.equals("delete"))
            {
                if (DB.isEmpty()) System.out.println("База данных пуста.\nДобавьте что-нибудь через add.");
                else DB = Delete(DB);
            }
            else if (cmd.equals("list"))
            {
                if (DB.isEmpty()) System.out.println("База данных пуста.\nДобавьте что-нибудь через add.");
                else List(DB);
            }
            else if (cmd.equals("help"))
            {
                System.out.println("\nДля записи телефона и пользователя введите add;");
                System.out.println("Для удаления телефона и пользователя введите delete;");
                System.out.println("Для вывода списка телефонов и пользователей введите list;");
                System.out.println("Для выхода из программы введите exit.");
            }
            else if (cmd.equals("exit")) break;
            else
            {
                System.out.println("\nТакой команды нет.\nДля вывода возможных команд введите help.");
            }
            continue;
        }
        iScanner.close();
    }
}