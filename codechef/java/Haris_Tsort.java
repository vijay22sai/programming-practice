import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.PrintWriter;
//import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
class tsort
{  static int n=0,m=0,k=0;static int inp[]=new int[100000];
    //boolean change[]=new boolean[17];
    public static void main(String []args)throws IOException{
     InputStream inputStream = System.in;
        //OutputStream outputStream = System.out;
        //InputReader in = new InputReader(inputStream);
        //OutputWriter outt = new OutputWriter(outputStream);
        Reader in=new Reader(System.in);
        Writer outt=new Writer(System.out);
        StringBuilder out=new StringBuilder();
         n=in.readInt(); 
         int a[]=new int[1000001];
         for(int i=0;i<n;i++){
            a[in.readInt()]++;
            }
           //Arrays.sort(a);
        for(int i=0;i<n;i++){
            for(int j=0;j<a[i];j++){
            outt.writeln(i);}
        }
        
        
          
 
        outt.flush();
    }
    static int recurse(int arr[],int i,int x){
        if(i==k){int sum=0;
            for(int j=0;j<arr.length;j++)
            {
                sum+=arr[j];
                
            }
            return sum;
        }
        else{
            arr[i]*=-1;
            int a=recurse(arr,i+1, x+1);
            arr[i]*=-1;
            int b=recurse(arr,i, x+1);
            return(Math.max(a,b));
        }
    }
    
 
}
class InputReader {
    
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
 
class OutputWriter {
    private final PrintWriter writer;
 
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
 
   /* public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }*/
 
    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }
 
    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }
 
    public void close() {
        writer.close();
    }
 
    } 
    class Reader
    {
    private static final int  BUFSIZE   = 0x10000;
    private final byte[]      buffer    = new byte[BUFSIZE];
    private final ByteBuffer  bb        = ByteBuffer.wrap(buffer);
    private final FileChannel channel;
 
    int                       bufSize   = -1;                     // non empty buffer
    int                       bufOffset = 0;                      // non valid buffer
 
    private FileInputStream getFileInputStream(InputStream in)
	{
	try
	    {
	    if (in instanceof BufferedInputStream)
		{
		Field field = in.getClass().getSuperclass().getDeclaredField("in");
		field.setAccessible(true);
		return (FileInputStream) field.get(in);
		}
	    }
	catch (Throwable e)
	    {
	    e.printStackTrace();
	    }
	return (FileInputStream) in;
	}
 
    Reader(InputStream in) throws IOException
	{
	this.channel = this.getFileInputStream(in).getChannel();
	}
 
    void fetchBuffer() throws IOException
	{
	bb.clear();
	bufSize = channel.read(bb);
	bufOffset = 0;
	}
 
    boolean isFinished()
	{
	return bufSize <= 0;
	}
 
    private int peek() throws IOException
	{
	if (bufOffset < bufSize)
	    return buffer[bufOffset];
	fetchBuffer();
	if (bufSize > 0)
	    return buffer[0];
	return -1;
	}
 
    private void skipSpace() throws IOException
	{
	int v = peek();
	while (v <= ' ' && v != -1)
	    {
	    bufOffset++;
	    v = peek();
	    }
	}
 
    void nextLine() throws IOException
	{
	int v = peek();
	while (v != -1 && v != '\n' && v != '\r')
	    {
	    bufOffset++;
	    v = peek();
	    }
	if (v == '\r')
	    {
	    bufOffset++;
	    v = peek();
	    if (v == '\n')
		bufOffset++;
	    }
	else if (v == '\n')
	    {
	    bufOffset++;
	    v = peek();
	    if (v == '\r')
		bufOffset++;
	    }
	}
 
    int readInt() throws IOException
	{
	skipSpace();
	int result = 0;
	int v = peek();
	while (v > ' ')
	    {
	    result = result * 10 + v - '0';
	    bufOffset++;
	    v = peek();
	    }
	return result;
	}
 
    }
 
class Writer
    {
    private static final int       BUFSIZE = 0x10000;
    private final FileOutputStream fos;
    private final byte[]           buffer  = new byte[BUFSIZE];
    private int                    offset  = 0;
 
    private FileOutputStream getFileOutputStream(PrintStream out)
	{
	try
	    {
	    Field field = out.getClass().getSuperclass().getDeclaredField("out");
	    field.setAccessible(true);
	    OutputStream os = (OutputStream) field.get(out);
	    if (os instanceof BufferedOutputStream)
		{
		BufferedOutputStream bos = (BufferedOutputStream) os;
		field = bos.getClass().getSuperclass().getDeclaredField("out");
		field.setAccessible(true);
		return (FileOutputStream) field.get(bos);
		}
	    return (FileOutputStream) field.get(out);
	    }
	catch (Throwable e)
	    {
	    e.printStackTrace();
	    }
	return null;
	}
 
    Writer(PrintStream out) throws IOException
	{
	fos = getFileOutputStream(out);
	}
 
    private static final int[]  boundaries = new int[]
	                                       { 9, 99, 999, 9999, 99999, 999999, 9999999,
	    99999999, 999999999               };
    private static final int[]  divs       = new int[]
	                                       { 1, 10, 100, 1000, 10000, 100000, 1000000,
	    10000000, 100000000               };
    private static final byte[] numbers    = "0123456789".getBytes();
 
    void writeln(int number) throws IOException
	{
	if (offset > BUFSIZE - 100)
	    flush();
	int index;
	for (index = 0; index < boundaries.length; index++)
	    if (number <= boundaries[index])
		break;
	for (; index >= 0; index--)
	    {
	    int mult = number / divs[index];
	    buffer[offset++] = numbers[mult];
	    number -= mult * divs[index];
	    }
	buffer[offset++] = '\n';
	}
 
    void flush() throws IOException
	{
	if (offset > 0)
	    {
	    fos.write(buffer, 0, offset);
	    offset = 0;
	    }
	}
    }    
