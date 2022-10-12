import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class save extends customber {
    int bal,sat,in;
    save(){
        this.bal=0;
    }
    save(int bal,int sat,int in,customber obj1){
        super(obj1);
        this.bal=bal;
        this.in=in;
        this.sat=sat;
    }
    void deposit(int amo){
        this.bal=this.bal+amo;
    }
    int withdraw(int amo){
        if (this.bal-amo-1000>0){
            this.bal=this.bal-amo;
            return amo;
        }
        else{
            return -1;
        }

    }
    int getBal(){
        return this.bal;
    }
    void inte(){
        int amo=(this.bal/100)*this.in;
        this.bal=this.bal+amo;
    }
    void addsave(save obj1){
        List<save> listsave=getsave();
        listsave.add((save) obj1);
        String filename="save.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (customber obj : listsave) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<save> getsave(){
        List<save> listsave=new ArrayList<save>();
        String filename="save.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof save) {
                        listsave.add((save) o);
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
        return listsave;
    }
}
