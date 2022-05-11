import cn.ice0qw3.netty.rpc.transport.client.Future;
import cn.ice0qw3.netty.rpc.transport.client.ResponseFuture;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class SimpleTest {
        public static void main(String[] args) throws IOException {
            Outter outter = new Outter();
            outter.setInner(new Inner());

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(outter);
            byte[] bytes = outputStream.toByteArray();
            System.out.println(Arrays.toString(bytes));
        }
        public static class Outter implements Serializable {
            private Inner inner;

            public void setInner(Inner inner) {
                this.inner = inner;
            }

            public Inner getInner() {
                return inner;
            }
        }
        public static class Inner implements Serializable{

        }
}
