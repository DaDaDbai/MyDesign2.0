package util;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
    private static File file;


    private MyObjectOutputStream(OutputStream out,File file) throws IOException {
        super(out);

    }

    public static MyObjectOutputStream getInstance(OutputStream out,File f) throws IOException{ //这个方法主要是解决file的传入问题
        file=f;
        return new MyObjectOutputStream(out,f);
    }




    @Override
    protected void writeStreamHeader() throws IOException {
        if(!file.exists()||(file.exists()&&file.length()==0)){
            super.writeStreamHeader();
        }

        else {
            super.reset();
        }
    }


}
