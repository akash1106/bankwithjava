import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class customber implements Serializable {
    int accno;
    String name,pass;
    customber(){
        this.accno=0;
    }
    customber(customber obj){
        this.accno= obj.accno;
        this.name=obj.name;
        this.pass= obj.pass;
    }
    customber(int accno,String name,String pass){
        this.accno=accno;
        this.name=name;
        this.pass=pass;
    }
    void addCustomber(customber obj1){
        List<customber> listcustombers=getcustomber();
        listcustombers.add((customber) obj1);
        String filename="account.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (customber obj : listcustombers) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<customber> getcustomber(){
        List<customber> listcustombers=new ArrayList<customber>();
        String filename="account.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof customber) {
                        listcustombers.add((customber) o);
                    } else {
                        System.out.println("error");
                    }
                } catch (EOFException | InvalidClassException e1) {
                    break;
                }
            }
        }catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return listcustombers;
    }
}
