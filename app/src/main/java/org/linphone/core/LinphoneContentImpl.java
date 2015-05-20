/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class LinphoneContentImpl
/*   4:    */   implements LinphoneContent
/*   5:    */ {
/*   6:    */   private String mType;
/*   7:    */   private String mSubtype;
/*   8:    */   private String mEncoding;
/*   9:    */   private String mName;
/*  10:    */   private byte[] mData;
/*  11:    */   private int mExpectedSize;
/*  12:    */   
/*  13:    */   public LinphoneContentImpl(String type, String subtype, byte[] data, String encoding)
/*  14:    */   {
/*  15:  9 */     this.mType = type;
/*  16: 10 */     this.mSubtype = subtype;
/*  17: 11 */     this.mData = data;
/*  18: 12 */     this.mEncoding = encoding;
/*  19: 13 */     this.mName = null;
/*  20: 14 */     this.mExpectedSize = 0;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public LinphoneContentImpl(String name, String type, String subtype, byte[] data, String encoding, int expectedSize)
/*  24:    */   {
/*  25: 18 */     this.mType = type;
/*  26: 19 */     this.mSubtype = subtype;
/*  27: 20 */     this.mData = data;
/*  28: 21 */     this.mEncoding = encoding;
/*  29: 22 */     this.mName = name;
/*  30: 23 */     this.mExpectedSize = expectedSize;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getType()
/*  34:    */   {
/*  35: 28 */     return this.mType;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getSubtype()
/*  39:    */   {
/*  40: 33 */     return this.mSubtype;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public String getDataAsString()
/*  44:    */   {
/*  45: 38 */     if (this.mData != null) {
/*  46: 39 */       return new String(this.mData);
/*  47:    */     }
/*  48: 40 */     return null;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setExpectedSize(int size)
/*  52:    */   {
/*  53: 45 */     this.mExpectedSize = size;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public int getExpectedSize()
/*  57:    */   {
/*  58: 50 */     return this.mExpectedSize;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public int getRealSize()
/*  62:    */   {
/*  63: 55 */     if (this.mData != null) {
/*  64: 56 */       return this.mData.length;
/*  65:    */     }
/*  66: 57 */     return 0;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setType(String type)
/*  70:    */   {
/*  71: 62 */     this.mType = type;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setSubtype(String subtype)
/*  75:    */   {
/*  76: 67 */     this.mSubtype = subtype;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setStringData(String data)
/*  80:    */   {
/*  81: 72 */     if (data != null) {
/*  82: 73 */       this.mData = data.getBytes();
/*  83:    */     } else {
/*  84: 75 */       this.mData = null;
/*  85:    */     }
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setData(byte[] data)
/*  89:    */   {
/*  90: 80 */     this.mData = data;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getEncoding()
/*  94:    */   {
/*  95: 85 */     return this.mEncoding;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public byte[] getData()
/*  99:    */   {
/* 100: 90 */     return this.mData;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setEncoding(String encoding)
/* 104:    */   {
/* 105: 95 */     this.mEncoding = encoding;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setName(String name)
/* 109:    */   {
/* 110:100 */     this.mName = name;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getName()
/* 114:    */   {
/* 115:105 */     return this.mName;
/* 116:    */   }
/* 117:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneContentImpl
 * JD-Core Version:    0.7.0.1
 */