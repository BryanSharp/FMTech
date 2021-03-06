package com.squareup.okhttp.internal.spdy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class HpackDraft10
{
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
  private static final Header[] STATIC_HEADER_TABLE;
  
  static
  {
    int i = 0;
    Header[] arrayOfHeader = new Header[61];
    arrayOfHeader[0] = new Header(Header.TARGET_AUTHORITY, "");
    arrayOfHeader[1] = new Header(Header.TARGET_METHOD, "GET");
    arrayOfHeader[2] = new Header(Header.TARGET_METHOD, "POST");
    arrayOfHeader[3] = new Header(Header.TARGET_PATH, "/");
    arrayOfHeader[4] = new Header(Header.TARGET_PATH, "/index.html");
    arrayOfHeader[5] = new Header(Header.TARGET_SCHEME, "http");
    arrayOfHeader[6] = new Header(Header.TARGET_SCHEME, "https");
    arrayOfHeader[7] = new Header(Header.RESPONSE_STATUS, "200");
    arrayOfHeader[8] = new Header(Header.RESPONSE_STATUS, "204");
    arrayOfHeader[9] = new Header(Header.RESPONSE_STATUS, "206");
    arrayOfHeader[10] = new Header(Header.RESPONSE_STATUS, "304");
    arrayOfHeader[11] = new Header(Header.RESPONSE_STATUS, "400");
    arrayOfHeader[12] = new Header(Header.RESPONSE_STATUS, "404");
    arrayOfHeader[13] = new Header(Header.RESPONSE_STATUS, "500");
    arrayOfHeader[14] = new Header("accept-charset", "");
    arrayOfHeader[15] = new Header("accept-encoding", "gzip, deflate");
    arrayOfHeader[16] = new Header("accept-language", "");
    arrayOfHeader[17] = new Header("accept-ranges", "");
    arrayOfHeader[18] = new Header("accept", "");
    arrayOfHeader[19] = new Header("access-control-allow-origin", "");
    arrayOfHeader[20] = new Header("age", "");
    arrayOfHeader[21] = new Header("allow", "");
    arrayOfHeader[22] = new Header("authorization", "");
    arrayOfHeader[23] = new Header("cache-control", "");
    arrayOfHeader[24] = new Header("content-disposition", "");
    arrayOfHeader[25] = new Header("content-encoding", "");
    arrayOfHeader[26] = new Header("content-language", "");
    arrayOfHeader[27] = new Header("content-length", "");
    arrayOfHeader[28] = new Header("content-location", "");
    arrayOfHeader[29] = new Header("content-range", "");
    arrayOfHeader[30] = new Header("content-type", "");
    arrayOfHeader[31] = new Header("cookie", "");
    arrayOfHeader[32] = new Header("date", "");
    arrayOfHeader[33] = new Header("etag", "");
    arrayOfHeader[34] = new Header("expect", "");
    arrayOfHeader[35] = new Header("expires", "");
    arrayOfHeader[36] = new Header("from", "");
    arrayOfHeader[37] = new Header("host", "");
    arrayOfHeader[38] = new Header("if-match", "");
    arrayOfHeader[39] = new Header("if-modified-since", "");
    arrayOfHeader[40] = new Header("if-none-match", "");
    arrayOfHeader[41] = new Header("if-range", "");
    arrayOfHeader[42] = new Header("if-unmodified-since", "");
    arrayOfHeader[43] = new Header("last-modified", "");
    arrayOfHeader[44] = new Header("link", "");
    arrayOfHeader[45] = new Header("location", "");
    arrayOfHeader[46] = new Header("max-forwards", "");
    arrayOfHeader[47] = new Header("proxy-authenticate", "");
    arrayOfHeader[48] = new Header("proxy-authorization", "");
    arrayOfHeader[49] = new Header("range", "");
    arrayOfHeader[50] = new Header("referer", "");
    arrayOfHeader[51] = new Header("refresh", "");
    arrayOfHeader[52] = new Header("retry-after", "");
    arrayOfHeader[53] = new Header("server", "");
    arrayOfHeader[54] = new Header("set-cookie", "");
    arrayOfHeader[55] = new Header("strict-transport-security", "");
    arrayOfHeader[56] = new Header("transfer-encoding", "");
    arrayOfHeader[57] = new Header("user-agent", "");
    arrayOfHeader[58] = new Header("vary", "");
    arrayOfHeader[59] = new Header("via", "");
    arrayOfHeader[60] = new Header("www-authenticate", "");
    STATIC_HEADER_TABLE = arrayOfHeader;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    while (i < STATIC_HEADER_TABLE.length)
    {
      if (!localLinkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      }
      i++;
    }
    NAME_TO_FIRST_INDEX = Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class Reader
  {
    Header[] dynamicTable = new Header[8];
    int dynamicTableByteCount = 0;
    int headerCount = 0;
    final List<Header> headerList = new ArrayList();
    int headerTableSizeSetting = 4096;
    int maxDynamicTableByteCount = 4096;
    int nextHeaderIndex = -1 + this.dynamicTable.length;
    final BufferedSource source;
    
    Reader(int paramInt, Source paramSource)
    {
      this.source = Okio.buffer(paramSource);
    }
    
    private void clearDynamicTable()
    {
      this.headerList.clear();
      Arrays.fill(this.dynamicTable, null);
      this.nextHeaderIndex = (-1 + this.dynamicTable.length);
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      if (paramInt > 0)
      {
        for (int j = -1 + this.dynamicTable.length; (j >= this.nextHeaderIndex) && (paramInt > 0); j--)
        {
          paramInt -= this.dynamicTable[j].hpackSize;
          this.dynamicTableByteCount -= this.dynamicTable[j].hpackSize;
          this.headerCount = (-1 + this.headerCount);
          i++;
        }
        System.arraycopy(this.dynamicTable, 1 + this.nextHeaderIndex, this.dynamicTable, i + (1 + this.nextHeaderIndex), this.headerCount);
        this.nextHeaderIndex = (i + this.nextHeaderIndex);
      }
      return i;
    }
    
    static boolean isStaticHeader(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= -1 + HpackDraft10.STATIC_HEADER_TABLE.length);
    }
    
    private int readByte()
      throws IOException
    {
      return 0xFF & this.source.readByte();
    }
    
    final void adjustDynamicTableByteCount()
    {
      if (this.maxDynamicTableByteCount < this.dynamicTableByteCount)
      {
        if (this.maxDynamicTableByteCount == 0) {
          clearDynamicTable();
        }
      }
      else {
        return;
      }
      evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
    }
    
    final int dynamicTableIndex(int paramInt)
    {
      return paramInt + (1 + this.nextHeaderIndex);
    }
    
    final ByteString getName(int paramInt)
    {
      if (isStaticHeader(paramInt)) {
        return HpackDraft10.STATIC_HEADER_TABLE[paramInt].name;
      }
      return this.dynamicTable[dynamicTableIndex(paramInt - HpackDraft10.STATIC_HEADER_TABLE.length)].name;
    }
    
    final void insertIntoDynamicTable$2acf0583(Header paramHeader)
    {
      this.headerList.add(paramHeader);
      int i = paramHeader.hpackSize;
      if (i > this.maxDynamicTableByteCount)
      {
        clearDynamicTable();
        return;
      }
      evictToRecoverBytes(i + this.dynamicTableByteCount - this.maxDynamicTableByteCount);
      if (1 + this.headerCount > this.dynamicTable.length)
      {
        Header[] arrayOfHeader = new Header[2 * this.dynamicTable.length];
        System.arraycopy(this.dynamicTable, 0, arrayOfHeader, this.dynamicTable.length, this.dynamicTable.length);
        this.nextHeaderIndex = (-1 + this.dynamicTable.length);
        this.dynamicTable = arrayOfHeader;
      }
      int j = this.nextHeaderIndex;
      this.nextHeaderIndex = (j - 1);
      this.dynamicTable[j] = paramHeader;
      this.headerCount = (1 + this.headerCount);
      this.dynamicTableByteCount = (i + this.dynamicTableByteCount);
    }
    
    final ByteString readByteString()
      throws IOException
    {
      int i = 0;
      int j = readByte();
      int k;
      int m;
      Huffman localHuffman;
      byte[] arrayOfByte;
      ByteArrayOutputStream localByteArrayOutputStream;
      int n;
      Huffman.Node localNode2;
      int i1;
      if ((j & 0x80) == 128)
      {
        k = 1;
        m = readInt(j, 127);
        if (k != 0)
        {
          localHuffman = Huffman.get();
          arrayOfByte = this.source.readByteArray(m);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          Huffman.Node localNode1 = localHuffman.root;
          n = 0;
          localNode2 = localNode1;
          i1 = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= arrayOfByte.length) {
            break label190;
          }
          n = 0xFF & arrayOfByte[i] | n << 8;
          i1 += 8;
          for (;;)
          {
            if (i1 < 8) {
              break label184;
            }
            int i3 = 0xFF & n >>> i1 - 8;
            localNode2 = localNode2.children[i3];
            if (localNode2.children == null)
            {
              localByteArrayOutputStream.write(localNode2.symbol);
              i1 -= localNode2.terminalBits;
              localNode2 = localHuffman.root;
              continue;
              k = 0;
              break;
            }
            i1 -= 8;
          }
          label184:
          i++;
        }
        label190:
        while (i1 > 0)
        {
          int i2 = 0xFF & n << 8 - i1;
          Huffman.Node localNode3 = localNode2.children[i2];
          if ((localNode3.children != null) || (localNode3.terminalBits > i1)) {
            break;
          }
          localByteArrayOutputStream.write(localNode3.symbol);
          i1 -= localNode3.terminalBits;
          localNode2 = localHuffman.root;
        }
        return ByteString.of(localByteArrayOutputStream.toByteArray());
      }
      return this.source.readByteString(m);
    }
    
    final int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      int i = paramInt1 & paramInt2;
      if (i < paramInt2) {
        return i;
      }
      int j = paramInt2;
      int m;
      for (int k = 0;; k += 7)
      {
        m = readByte();
        if ((m & 0x80) == 0) {
          break;
        }
        j += ((m & 0x7F) << k);
      }
      return j + (m << k);
    }
  }
  
  static final class Writer
  {
    private final Buffer out;
    
    Writer(Buffer paramBuffer)
    {
      this.out = paramBuffer;
    }
    
    private void writeByteString(ByteString paramByteString)
      throws IOException
    {
      writeInt$4868d30e(paramByteString.data.length, 127);
      this.out.write(paramByteString);
    }
    
    private void writeInt$4868d30e(int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt1 | 0x0);
        return;
      }
      this.out.writeByte(paramInt2 | 0x0);
      int i = paramInt1 - paramInt2;
      while (i >= 128)
      {
        int j = i & 0x7F;
        this.out.writeByte(j | 0x80);
        i >>>= 7;
      }
      this.out.writeByte(i);
    }
    
    final void writeHeaders(List<Header> paramList)
      throws IOException
    {
      int i = 0;
      int j = paramList.size();
      if (i < j)
      {
        ByteString localByteString = ((Header)paramList.get(i)).name.toAsciiLowercase();
        Integer localInteger = (Integer)HpackDraft10.NAME_TO_FIRST_INDEX.get(localByteString);
        if (localInteger != null)
        {
          writeInt$4868d30e(1 + localInteger.intValue(), 15);
          writeByteString(((Header)paramList.get(i)).value);
        }
        for (;;)
        {
          i++;
          break;
          this.out.writeByte(0);
          writeByteString(localByteString);
          writeByteString(((Header)paramList.get(i)).value);
        }
      }
    }
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.spdy.HpackDraft10
 * JD-Core Version:    0.7.0.1
 */