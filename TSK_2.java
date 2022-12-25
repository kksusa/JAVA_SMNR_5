import java.util.HashMap;
import java.util.ArrayList;

public class TSK_2
{
    static Object[] BubbleReverseSorting(Object[] array1, Object[] array2)
    {
        boolean check = false;
        Object temp1, temp2;
        while(!check)
        {
            check = true;
            for (int i = 0; i < array1.length-1; i++)
            {
                if((int)(array1[i]) < (int)(array1[i+1]))
                {
                    check = false;
                    temp1 = array1[i];
                    array1[i] = array1[i+1];
                    array1[i+1] = temp1;
                    temp2 = array2[i];
                    array2[i] = array2[i+1];
                    array2[i+1] = temp2;
                }
            }
        }
        return array2;
    }
    public static void main(String[] args)
    {
        String[] employees = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
    "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
    "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
    "Петр Петин", "Иван Ежов"};
        String[][] employeesInArray = new String[employees.length][];
        for (int i = 0; i < employees.length; i++)
        {
            employeesInArray[i] = employees[i].split(" ");
        }
        HashMap<String, Integer> names = new HashMap<>();
        for (int i = 0; i < employees.length; i++)
        {
            int count = 0;
            String temp = employeesInArray[i][0];
            if (names.containsKey(temp))
            {
                continue;
            }
            else
            {
                for (int j = 0; j < employees.length; j++)
                {
                    if (employeesInArray[j][0].equals(temp)) count++;
                }
                names.put(temp, count);
            }
        }
        Object[] FN = names.keySet().toArray();
        Object[] amount = new ArrayList<>(names.values()).toArray();
        for (int i = 0; i < FN.length; i++)
        {
            System.out.printf("Имя \"%s\" встречается %d раз(а).\n", FN[i], amount[i]);
        }
        Object [] result = BubbleReverseSorting(amount, FN);
        System.out.println("\nСортировка инициалов в порядке убывания:\n");
        for (int i = 0; i < result.length; i++)
        {
            Object tempName = result[i];
            for (int j = 0; j < employeesInArray.length; j++)
            {
                if (employeesInArray[j][0] == (tempName.toString()))
                {
                    System.out.println(employees[j]);
                }
            }
        }
    }   
}
