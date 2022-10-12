import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class home extends customber{
    int in,rem,per;
    home(){
        this.rem=0;
    }
    home(int in,int rem,int per,customber obj1){
        super(obj1);
        this.in=in;
        this.rem=rem;
        this.per=per;
    }
    void reduce(){
        this.rem=this.rem-(this.rem/this.per);
    }
    void inte(){
        int i=(this.rem/100)*this.in;
        this.rem=this.rem+i;
    }
    void addhome(home obj1){
        List<home> listhome=gethome();
        listhome.add((home) obj1);
        String filename="home.bin";
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (home obj : listhome) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    List<home> gethome() {
        List<home> listhome = new ArrayList<home>();
        String filename = "home.bin";
        try {
            FileInputStream fio = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fio);
            Object o;
            while (true) {
                try {
                    o = ois.readObject();
                    if (o instanceof home) {
                        listhome.add((home) o);
                    } else {
                        System.out.println("error");
                    }
                } catch (EOFException e1) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return listhome;
    }
}
