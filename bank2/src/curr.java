import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class curr extends customber{
    int bal;
    curr(){
        this.bal=0;
    }
    curr(int bal,customber obj1){
        super(obj1);
        this.bal=bal;
    }
    void deposit(int amo){
        this.bal=this.bal+amo;
    }
    int getBal(){
        return this.bal;
    }
    int withdraw(int amo){
        if(this.bal-amo-2000>0){
            this.bal=this.bal-amo;
            return amo;
        }
        else{
            return -1;
        }
    }
    void addcurr(curr obj1){
        List<curr> listcurr=getcurr();
        listcurr.add((curr) obj1);
        String filename="curr.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (curr obj : listcurr) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<curr> getcurr(){
        List<curr> listcurr=new ArrayList<curr>();
        String filename="curr.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof curr) {
                        listcurr.add((curr) o);
                    } else {
                        System.out.println("error");
                    }
                } catch (EOFException e1) {
                    break;
                }
            }
        }catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return listcurr;
    }
}
