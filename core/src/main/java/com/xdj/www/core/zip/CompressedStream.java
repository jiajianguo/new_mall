package com.xdj.www.core.zip;


import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * @author Administrator
 */
public class CompressedStream extends ServletOutputStream{
  private ServletOutputStream out;
  private GZIPOutputStream gzip;

  public CompressedStream(ServletOutputStream out)
    throws IOException
  {
    this.out = out;
    reset();
  }

  @Override
  public void close() throws IOException
  {
    this.gzip.close();
  }

  @Override
  public void flush() throws IOException
  {
    this.gzip.flush();
  }

  @Override
  public void write(byte[] b) throws IOException
  {
    write(b, 0, b.length);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException
  {
    this.gzip.write(b, off, len);
  }

  @Override
  public void write(int b) throws IOException
  {
    this.gzip.write(b);
  }

  public void reset() throws IOException {
    this.gzip = new GZIPOutputStream(this.out);
  }

  @Override
  public boolean isReady() {
    return false;
  }

  @Override
  public void setWriteListener(WriteListener writeListener) {

  }
}
