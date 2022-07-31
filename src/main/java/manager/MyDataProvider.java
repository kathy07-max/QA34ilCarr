package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object []> dataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"katermax07@mail.ru","Rr020985$"});
        list.add(new Object[]{"monalisa1@gmail.com","020985$Max"});
        list.add(new Object[]{"monalisa3@gmail.com","020985$Max"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>dataRegistration()  {
        Random random = new Random();
        int i =random.nextInt(1000)+1000;
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Monna").setLastName("Lissa").setEmail("monali"+i+"@gmail.com").setPassword("020985$Max")});
        i =random.nextInt(1000)+1000;
        list.add(new Object[]{new User().setName("Monna").setLastName("Lissa").setEmail("monali"+i+"@gmail.com").setPassword("020985$Max")});
        i =random.nextInt(1000)+1000;
        list.add(new Object[]{new User().setName("Monna").setLastName("Lissa").setEmail("monali"+i+"@gmail.com").setPassword("020985$Max")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>loginCSV() throws IOException {

        List <Object[]> list= new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\97254\\DocQA34\\GitHub\\QA34ilCarr\\QA34ilCarr\\src\\test\\resources\\loginData.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addedCarCSV() throws IOException {
        Random random = new Random();
        int i =random.nextInt(1000)+1000;
        List <Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\97254\\DocQA34\\GitHub\\QA34ilCarr\\QA34ilCarr\\src\\test\\resources\\car.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{Car.builder().address(split[0]).make(split[1]).model(split[2]).
                   year(split[3]).engine(split[4]).fuel(split[5]).gear(split[6]).wD(split[7]).
                   doors(split[8]).seats(split[9]).clasS(split[10]).fuelConsumption(split[11]).
                   carRegNumber(split[12]+i).price(split[13]).distanceIncluded(split[14]).
                   features(split[15]).about(split[16]).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
