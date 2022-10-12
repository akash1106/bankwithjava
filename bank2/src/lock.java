import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class lock extends customber{
    int lockno;
    String passw;
    lock(){
        this.lockno=0;
    }
    lock(int lockno,String passw,customber obj1){
        super(obj1);
        this.lockno=lockno;
        this.passw=passw;
    }
    int getlocker(int no,String pa){
        if(this.lockno==no | this.passw==pa){
            return 1;
        }
        else{
            return -1;
        }
    }
    void addlock(lock obj1){
        List<lock> listlock=getlock();
        listlock.add((lock) obj1);
        String filename="locker.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (lock obj : listlock) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<lock> getlock(){
        List<lock> listlock=new ArrayList<lock>();
        String filename="locker.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof lock) {
                        listlock.add((lock) o);
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
        return listlock;
    }
}
